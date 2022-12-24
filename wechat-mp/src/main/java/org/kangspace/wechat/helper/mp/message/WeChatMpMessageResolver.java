package org.kangspace.wechat.helper.mp.message;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.exception.WeChatMessageResolverException;
import org.kangspace.wechat.helper.core.message.AbstractWeChatMessageResolver;
import org.kangspace.wechat.helper.core.message.MessageFormat;
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
