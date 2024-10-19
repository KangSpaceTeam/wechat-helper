package org.kangspace.wechat.helper.mp.message;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.kangspace.devhelper.digest.DigestUtil;
import org.kangspace.devhelper.xml.XmlParser;
import org.kangspace.wechat.helper.core.config.WeChatConfig;
import org.kangspace.wechat.helper.core.exception.WeChatMessageResolverException;
import org.kangspace.wechat.helper.core.exception.WeChatSignatureException;
import org.kangspace.wechat.helper.core.message.*;
import org.kangspace.wechat.helper.core.message.response.WeChatEncryptEchoMessage;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.event.WeChatMpEventHandler;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEncryptEchoXmlMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 微信公众号事件处理器
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
@Getter
@Slf4j
public class WeChatMpMessageResolver
        extends AbstractWeChatMessageResolver<WeChatMpService, WeChatMpMessage, WeChatMpEchoMessage> {
    /**
     * 消息加解密对象
     */
    private final MessageCipher messageCipher;

    public WeChatMpMessageResolver(WeChatMpService wechatService) {
        this(wechatService, new ArrayList<>());
    }

    public WeChatMpMessageResolver(WeChatMpService wechatService, List<WeChatMpMessageHandler<WeChatMpMessage>> weChatMessageHandlers) {
        super(wechatService, weChatMessageHandlers);
        this.messageCipher = new MessageCipher(wechatService.getWeChatConfig());
    }


    /**
     * 微信公众号微信服务器消息签名校验<br>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Access_Overview.html">https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Access_Overview.html</a><br>
     * 说明:
     * <pre>
     * 原样返回 echostr 参数内容，则接入生效，成为开发者成功，否则接入失败。加密/校验流程如下：
     * 1）将token、timestamp、nonce三个参数进行字典序排序
     * 2）将三个参数字符串拼接成一个字符串进行sha1加密
     * 3）开发者获得加密后的字符串可与 signature 对比，标识该请求来源于微信
     * </pre>
     *
     * @param signature {@link BaseMessageSignature}
     * @return 验证成功后返回echoStr, 验证失败抛出 {@link WeChatSignatureException}
     */
    @Override
    public boolean checkSignature(BaseMessageSignature signature) {
        log.debug("checkSignature: signature: {}", signature);
        WeChatConfig config = getWeChatService().getWeChatConfig();
        String signatureStr = signature.getSignature();
        String nonce = signature.getNonce();
        String timestamp = signature.getTimestamp();
        String token = config.getToken();
        String sha1 = DigestUtil.sha1(token, timestamp, nonce);
        log.debug("checkSignature: sha1: {}", sha1);
        if (!signatureStr.equals(sha1)) {
            log.debug("checkSignature: checkSignature failed, sha1: {}", sha1);
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <EEM extends WeChatEncryptEchoMessage> EEM encryptEcho(WeChatMpEchoMessage echoMessage) {
        String echoMessageStr = XmlParser.toXmlString(echoMessage);
        return (EEM) messageCipher.encrypt(echoMessageStr, WeChatMpEncryptEchoXmlMessage.class);
    }

    @SuppressWarnings("uncheck")
    @Override
    public WeChatMpEchoMessage resolve(MessageFormat messageFormat, MessageSignature messageSignature, String message, MessageResolverContext context) {
        log.debug("微信公众号消息处理: 消息类型: {}, messageSignature: {}, 事件消息: {}, 上下文: {}", messageFormat, messageSignature, message, context);
        if (context == null) {
            context = MessageResolverContext.newContext();
        }
        if (messageFormat == MessageFormat.XML) {
            return xmlMessageResolve(messageSignature, message, context);
        } else {
            throw new WeChatMessageResolverException("messageType :" + messageFormat + " not supported!");
        }
    }

    /**
     * XML消息处理
     *
     * @param messageSignature 消息签名
     * @param rawMessage       消息
     * @param context          {@link MessageResolverContext} 处理器上下文
     */
    private WeChatMpEchoMessage xmlMessageResolve(MessageSignature messageSignature, String rawMessage, MessageResolverContext context) {
        log.debug("微信公众号消息处理: XML消息处理: messageSignature: {}, rawMessage: {}", messageSignature, rawMessage);
        boolean isEncrypt = messageSignature.isEncrypt();
        if (isEncrypt) {
            // 加密消息处理
            rawMessage = messageCipher.decrypt(messageSignature, rawMessage, WeChatMpEncryptXmlMessage.class);
        } else {
            // 校验消息签名
            this.checkSignatureThrows(messageSignature);
        }
        context.setEncryptMessage(isEncrypt).setMessageCipher(messageCipher);
        WeChatMpXmlMessage message = XmlParser.parse(rawMessage, WeChatMpXmlMessage.class);
        message.setRaw(rawMessage);
        message = MessageMappingClassConverter.convert(message);
        log.info("微信公众号消息处理: 目标消息实体: {}", message.getClass());
        return executeHandlers(message, context);
    }

    /**
     * 执行处理器
     *
     * @param message {@link WeChatMpXmlMessage} 最终的消息内容
     * @param context {@link MessageResolverContext} 处理器上下文对象
     * @return {@link WeChatMpEchoMessage} 输出的原始响应对象(未加密)
     */
    private WeChatMpEchoMessage executeHandlers(WeChatMpXmlMessage message, MessageResolverContext context) {
        List<WeChatMpMessageHandler<WeChatMpMessage>> messageHandlers = getWeChatHandlers(message);
        log.debug("微信公众号消息处理: 已知的消息处理器: {}", messageHandlers);
        // 若同一个消息存在多个处理器, 返回第一个有返回值的处理器的返回值; 若存在异步执行器,则返回所有执行器中最先执行完的有返回值的处理器的返回值.
        List<CompletableFuture<WeChatMpEchoMessage>> completableFutures = new ArrayList<>();
        ConcurrentHashMap<Long, WeChatMpEchoMessage> resultMap = new ConcurrentHashMap<>(16);
        for (WeChatMpMessageHandler<WeChatMpMessage> handler : messageHandlers) {
            if (handler.isAsync()) {
                // 异步执行器处理
                CompletableFuture<WeChatMpEchoMessage> echoMessageFeature = CompletableFuture.supplyAsync(() -> handler.handle(getWeChatService(), message, context), handler.getExecutor());
                // 异步执行器-记录执行结果
                echoMessageFeature.thenAccept(echoMessage -> {
                    if (echoMessage != null) {
                        resultMap.put(System.nanoTime(), echoMessage);
                    }
                });
                completableFutures.add(echoMessageFeature);
            } else {
                // 同步执行器处理
                WeChatMpEchoMessage echoMessage = handler.handle(getWeChatService(), message, context);
                // 同步执行器-记录执行结果
                if (echoMessage != null) {
                    resultMap.put(System.nanoTime(), echoMessage);
                    break;
                }
            }
        }
        if (!completableFutures.isEmpty()) {
            CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();
        }
        // 取第一条结果数据
        return !resultMap.isEmpty() ? resultMap.values().stream().findFirst().orElse(null) : null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<WeChatMpMessageHandler<WeChatMpMessage>> getWeChatHandlers(WeChatMpMessage message) {
        List<WeChatMpMessageHandler<WeChatMpMessage>> list = (List<WeChatMpMessageHandler<WeChatMpMessage>>) super.getWeChatHandlers(message);
        if (message.isEvent()) {
            return list.stream().filter(t -> t instanceof WeChatMpEventHandler).collect(Collectors.toList());
        }
        return list;
    }

    /**
     * 提取消息中的ToUserName
     *
     * @param messageFormat 消息格式{@link MessageFormat}
     * @param message       消息内容
     * @return toUserName
     */
    public static String extractToUserName(MessageFormat messageFormat, String message) {
        if (MessageFormat.XML.equals(messageFormat)) {
            WeChatMpXmlMessage xmlMessage = XmlParser.parse(message, WeChatMpXmlMessage.class);
            return xmlMessage.getToUser();
        }
        return null;
    }

    /**
     * 提取消息中的ToUserName
     *
     * @param message 消息内容
     * @return toUserName
     */
    public static String extractToUserName(String message) {
        return extractToUserName(MessageFormat.XML, message);
    }
}
