package org.kangspace.wechat.helper.work.message;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.kangspace.devhelper.digest.DigestUtil;
import org.kangspace.devhelper.xml.XmlParser;
import org.kangspace.wechat.helper.core.config.WeChatConfig;
import org.kangspace.wechat.helper.core.exception.WeChatMessageResolverException;
import org.kangspace.wechat.helper.core.exception.WeChatSignatureException;
import org.kangspace.wechat.helper.core.message.*;
import org.kangspace.wechat.helper.core.message.response.WeChatEncryptEchoMessage;
import org.kangspace.wechat.helper.work.WeComService;
import org.kangspace.wechat.helper.work.event.WeComEventHandler;
import org.kangspace.wechat.helper.work.message.response.WeComEchoMessage;
import org.kangspace.wechat.helper.work.message.response.WeComEncryptEchoXmlMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 企业微信事件处理器
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/25
 */
@Getter
@Slf4j
public class WeComMessageResolver
        extends AbstractWeChatMessageResolver<WeComService, WeComMessage, WeComEchoMessage> {
    /**
     * 消息加解密对象
     */
    private final MessageCipher messageCipher;

    public WeComMessageResolver(WeComService wechatService) {
        this(wechatService, new ArrayList<>());
    }

    public WeComMessageResolver(WeComService wechatService, List<WeComMessageHandler<WeComMessage>> weChatMessageHandlers) {
        super(wechatService, weChatMessageHandlers);
        this.messageCipher = new MessageCipher(wechatService.getWeChatConfig());
    }

    @Override
    public <T extends BaseMessageSignature> boolean checkSignature(T signature) {
        if (signature instanceof GetMessageSignature) {
            return this.checkSignature((GetMessageSignature) signature);
        }
        throw new IllegalArgumentException("不支持该类型对象的签名校验");
    }

    /**
     * 企业微信微信服务器消息签名校验<br>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/10514">https://developer.work.weixin.qq.com/document/10514</a><br>
     * <a href="https://developer.work.weixin.qq.com/document/path/90238#%E4%BD%BF%E7%94%A8%E6%8E%A5%E6%94%B6%E6%B6%88%E6%81%AF">https://developer.work.weixin.qq.com/document/path/90238#%E4%BD%BF%E7%94%A8%E6%8E%A5%E6%94%B6%E6%B6%88%E6%81%AF</a><br>
     * <a href="https://developer.work.weixin.qq.com/document/path/90968#%E6%B6%88%E6%81%AF%E4%BD%93%E7%AD%BE%E5%90%8D%E6%A0%A1%E9%AA%8C">https://developer.work.weixin.qq.com/document/path/90968#%E6%B6%88%E6%81%AF%E4%BD%93%E7%AD%BE%E5%90%8D%E6%A0%A1%E9%AA%8C</a><br>
     * 说明:
     * <pre>
     * 原样返回 echostr 参数内容，则接入生效，成为开发者成功，否则接入失败。加密/校验流程如下：
     * 1）第一步：准备相关参数，
     * 2） 将token、timestamp、nonce、msg_encrypt 4个参数进行字典序排序
     * 3）将4个参数字符串拼接成一个字符串进行sha1加密
     * 4）开发者获得加密后的字符串可与 msg_encrypt 对比，标识该请求来源于企业微信
     * </pre>
     *
     * @param signature {@link BaseMessageSignature}
     * @return 验证成功后返回echoStr, 验证失败抛出 {@link WeChatSignatureException}
     */
    public boolean checkSignature(GetMessageSignature signature) {
        log.debug("checkSignature: signature: {}", signature);
        WeChatConfig config = getWeChatService().getWeChatConfig();
        String signatureStr = signature.getSignature();
        String nonce = signature.getNonce();
        String timestamp = signature.getTimestamp();
        String echoStr = signature.getEchoStr();
        String token = config.getToken();
        String sha1 = DigestUtil.sha1(token, timestamp, nonce, echoStr);
        log.debug("checkSignature: sha1: {}", sha1);
        if (!signatureStr.equals(sha1)) {
            log.debug("checkSignature: checkSignature failed, sha1: {}", sha1);
            return false;
        }
        return true;
    }

    /**
     * 企业微信微信服务器消息签名校验<br>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/10514">https://developer.work.weixin.qq.com/document/10514</a><br>
     * <a href="https://developer.work.weixin.qq.com/document/path/90238#%E4%BD%BF%E7%94%A8%E6%8E%A5%E6%94%B6%E6%B6%88%E6%81%AF">https://developer.work.weixin.qq.com/document/path/90238#%E4%BD%BF%E7%94%A8%E6%8E%A5%E6%94%B6%E6%B6%88%E6%81%AF</a><br>
     * <a href="https://developer.work.weixin.qq.com/document/path/90968#%E6%B6%88%E6%81%AF%E4%BD%93%E7%AD%BE%E5%90%8D%E6%A0%A1%E9%AA%8C">https://developer.work.weixin.qq.com/document/path/90968#%E6%B6%88%E6%81%AF%E4%BD%93%E7%AD%BE%E5%90%8D%E6%A0%A1%E9%AA%8C</a><br>
     * 说明:
     * <pre>
     * 原样返回 echostr 参数内容，则接入生效，成为开发者成功，否则接入失败。加密/校验流程如下：
     * 1）第一步：准备相关参数，
     * 2） 将token、timestamp、nonce、msg_encrypt 4个参数进行字典序排序
     * 3）将4个参数字符串拼接成一个字符串进行sha1加密
     * 4）开发者获得加密后的字符串可与 msg_encrypt 对比，标识该请求来源于企业微信
     * </pre>
     *
     * @param signature {@link BaseMessageSignature}
     * @return 验证成功后返回echoStr, 验证失败抛出 {@link WeChatSignatureException}
     */
    public String checkSignatureWithReplyEchoStr(GetMessageSignature signature) {
        if (checkSignature(signature)) {
            return decodeMsgSignature(signature.getEchoStr());
        }
        return null;
    }

    /**
     * 解密MsgSignature中的消息
     *
     * @param echoStr URL中的 echoStr
     * @return 响应消息 echoStr中的msg
     */
    public String decodeMsgSignature(String echoStr) {
        String msg = getMessageCipher().decrypt(echoStr);
        log.debug("decodeMsgSignature: msg: {}", msg);
        return msg;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <EEM extends WeChatEncryptEchoMessage> EEM encryptEcho(WeComEchoMessage echoMessage) {
        String echoMessageStr = XmlParser.toXmlString(echoMessage);
        return (EEM) messageCipher.encrypt(echoMessageStr, WeComEncryptEchoXmlMessage.class);
    }

    @SuppressWarnings("uncheck")
    @Override
    public WeComEchoMessage resolve(MessageFormat messageFormat, MessageSignature messageSignature, String message, MessageResolverContext context) {
        log.debug("企业微信消息处理: 消息类型: {}, messageSignature: {}, 事件消息: {}, 上下文: {}", messageFormat, messageSignature, message, context);
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
    private WeComEchoMessage xmlMessageResolve(MessageSignature messageSignature, String rawMessage, MessageResolverContext context) {
        log.debug("企业微信消息处理: XML消息处理: messageSignature: {}, rawMessage: {}", messageSignature, rawMessage);
        boolean isEncrypt = messageSignature.isEncrypt();
        if (isEncrypt) {
            // 加密消息处理
            rawMessage = messageCipher.decrypt(messageSignature, rawMessage, WeComEncryptXmlMessage.class);
        } else {
            // 校验消息签名
            this.checkSignatureThrows(messageSignature);
        }
        context.setEncryptMessage(isEncrypt).setMessageCipher(messageCipher);
        WeComXmlMessage message = XmlParser.parse(rawMessage, WeComXmlMessage.class);
        message.setRaw(rawMessage);
        message = MessageMappingClassConverter.convert(message);
        log.info("企业微信消息处理: 目标消息实体: {}", message.getClass());
        return executeHandlers(message, context);
    }

    /**
     * 执行处理器
     *
     * @param message {@link WeComXmlMessage} 最终的消息内容
     * @param context {@link MessageResolverContext} 处理器上下文对象
     * @return {@link WeComEchoMessage} 输出的原始响应对象(未加密)
     */
    private WeComEchoMessage executeHandlers(WeComXmlMessage message, MessageResolverContext context) {
        List<WeComMessageHandler<WeComMessage>> messageHandlers = getWeChatHandlers(message);
        log.debug("企业微信消息处理: 已知的消息处理器: {}", messageHandlers);
        // 若同一个消息存在多个处理器, 返回第一个有返回值的处理器的返回值; 若存在异步执行器,则返回所有执行器中最先执行完的有返回值的处理器的返回值.
        List<CompletableFuture<WeComEchoMessage>> completableFutures = new ArrayList<>();
        ConcurrentHashMap<Long, WeComEchoMessage> resultMap = new ConcurrentHashMap<>(16);
        messageHandlers.forEach(handler -> {
            if (handler.isAsync()) {
                // 异步执行器处理
                CompletableFuture<WeComEchoMessage> echoMessageFeature = CompletableFuture.supplyAsync(() -> handler.handle(getWeChatService(), message, context), handler.getExecutor());
                // 异步执行器-记录执行结果
                echoMessageFeature.thenAccept(echoMessage -> {
                    if (echoMessage != null) {
                        resultMap.put(System.nanoTime(), echoMessage);
                    }
                });
                completableFutures.add(echoMessageFeature);
            } else {
                // 同步执行器处理
                WeComEchoMessage echoMessage = handler.handle(getWeChatService(), message, context);
                // 同步执行器-记录执行结果
                if (echoMessage != null) {
                    resultMap.put(System.nanoTime(), echoMessage);
                }
            }
        });
        if (!completableFutures.isEmpty()) {
            CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();
        }
        // 取第一条结果数据
        return !resultMap.isEmpty() ? resultMap.values().stream().findFirst().orElse(null) : null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<WeComMessageHandler<WeComMessage>> getWeChatHandlers(WeComMessage message) {
        List<WeComMessageHandler<WeComMessage>> list = (List<WeComMessageHandler<WeComMessage>>) super.getWeChatHandlers(message);
        if (message.isEvent()) {
            return list.stream().filter(t -> t instanceof WeComEventHandler).collect(Collectors.toList());
        }
        return list;
    }

    /**
     * 提取消息中的 ToUserName
     *
     * @param messageFormat 消息格式{@link MessageFormat}
     * @param message       消息内容
     * @return toUserName
     */
    public static String extractToUserName(MessageFormat messageFormat, String message) {
        if (MessageFormat.XML.equals(messageFormat)) {
            WeComXmlMessage xmlMessage = XmlParser.parse(message, WeComXmlMessage.class);
            return xmlMessage.getToUser();
        }
        return null;
    }

    /**
     * 提取消息中的 AgentID
     *
     * @param messageFormat 消息格式{@link MessageFormat}
     * @param message       消息内容
     * @return toUserName
     */
    public static String extractAgentId(MessageFormat messageFormat, String message) {
        if (MessageFormat.XML.equals(messageFormat)) {
            WeComXmlMessage xmlMessage = XmlParser.parse(message, WeComXmlMessage.class);
            return xmlMessage.getAgentId();
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

    /**
     * 提取消息中的AgentId
     *
     * @param message 消息内容
     * @return toUserName
     */
    public static String extractToAgentId(String message) {
        return extractAgentId(MessageFormat.XML, message);
    }
}
