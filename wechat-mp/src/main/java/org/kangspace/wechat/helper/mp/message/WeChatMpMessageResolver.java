package org.kangspace.wechat.helper.mp.message;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.config.WeChatConfig;
import org.kangspace.wechat.helper.core.exception.WeChatMessageResolverException;
import org.kangspace.wechat.helper.core.exception.WeChatSignatureException;
import org.kangspace.wechat.helper.core.message.AbstractWeChatMessageResolver;
import org.kangspace.wechat.helper.core.message.MessageFormat;
import org.kangspace.wechat.helper.core.message.MessageSignature;
import org.kangspace.wechat.helper.core.util.DigestUtil;
import org.kangspace.wechat.helper.core.util.XmlParser;
import org.kangspace.wechat.helper.mp.WeChatMpService;

import java.util.List;

/**
 * 微信公众号事件处理器
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
@Slf4j
public class WeChatMpMessageResolver extends AbstractWeChatMessageResolver<WeChatMpService, WeChatMpMessageHandler, WeChatMpMessage> {

    public WeChatMpMessageResolver(WeChatMpService wechatService) {
        super(wechatService);
    }

    public WeChatMpMessageResolver(WeChatMpService wechatService, List<WeChatMpMessageHandler> weChatMessageHandlers) {
        super(wechatService, weChatMessageHandlers);
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
     * @param signature {@link MessageSignature}
     * @return 验证成功后返回echoStr, 验证失败抛出 TODO xxxx
     */
    @Override
    public String checkSignature(MessageSignature signature) {
        log.debug("checkSignature: signature: {}", signature);
        WeChatConfig config = getWeChatService().getWeChatConfig();
        String signatureStr = signature.getSignature();
        String echoStr = signature.getEchoStr();
        String nonce = signature.getNonce();
        String timestamp = signature.getTimestamp();
        String token = config.getToken();
        String sha1 = DigestUtil.sha1(token, timestamp, nonce);
        log.debug("checkSignature: sha1: {}", sha1);
        if (!signatureStr.equals(sha1)) {
            log.debug("checkSignature: checkSignature failed");
            throw new WeChatSignatureException("checkSignature failed");
        }
        return echoStr;
    }

    @Override
    public void resolve(MessageFormat messageFormat, String message) {
        log.debug("微信公众号消息处理: 消息类型: {}, 事件消息: {}", messageFormat, message);
        switch (messageFormat) {
            case XML:
                xmlMessageResolve(message);
                break;
            default:
                throw new WeChatMessageResolverException("messageType :" + messageFormat + " not supported!");
        }
    }

    /**
     * XML消息处理
     *
     * @param rawMessage 消息
     */
    private void xmlMessageResolve(String rawMessage) {
        log.debug("微信公众号消息处理: XML消息处理: {}", rawMessage);
        WeChatMpXmlMessage message = XmlParser.parse(rawMessage, WeChatMpXmlMessage.class);
        message.setRaw(rawMessage);
        // TODO xxx 需实现转换哪个Message类
        List<WeChatMpMessageHandler> messageHandlers = getWeChatHandlers(message);
        log.debug("微信公众号消息处理: 已知的消息处理器: {}", messageHandlers);
        messageHandlers.forEach(handler -> handler.handle(getWeChatService(), message));
    }
}
