package org.kangspace.wechat.helper.mp.event;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.event.AbstractWeChatEventResolver;
import org.kangspace.wechat.helper.core.exception.WeChatMessageResolverException;
import org.kangspace.wechat.helper.core.message.MessageFormat;
import org.kangspace.wechat.helper.core.message.MessageSignature;
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
public class WeChatMpEventResolver extends AbstractWeChatEventResolver<WeChatMpService, WeChatMpEventHandler, WeChatMpEvent> {

    public WeChatMpEventResolver(WeChatMpService wechatService) {
        super(wechatService);
    }

    public WeChatMpEventResolver(WeChatMpService wechatService, List<WeChatMpEventHandler> weChatEventHandlers) {
        super(wechatService, weChatEventHandlers);
    }

    @Override
    public void resolve(MessageFormat messageFormat, MessageSignature messageSignature, String eventMessage) {
        log.debug("微信公众号事件处理: 消息类型: {}, messageSignature: {}, 事件消息: {}", messageFormat, messageSignature, eventMessage);
        // TODO xx
        switch (messageFormat) {
            case XML:
                xmlEventResolve(eventMessage);
                break;
            default:
                throw new WeChatMessageResolverException("messageType :" + messageFormat + " not supported!");
        }
    }

    /**
     * XML事件消息处理
     *
     * @param eventMessage 事件消息
     */
    private void xmlEventResolve(String eventMessage) {
        log.debug("微信公众号事件处理: XML消息处理: {}", eventMessage);
        WeChatMpXmlEvent event = XmlParser.parse(eventMessage, WeChatMpXmlEvent.class);
        event.setRaw(eventMessage);
        // TODO xxx 需实现转换哪个Event类
        List<WeChatMpEventHandler> eventHandlers = getWeChatHandlers(event);
        log.debug("微信公众号事件处理: 已知的事件处理器: {}", eventHandlers);
        eventHandlers.forEach(handler -> handler.handle(getWeChatService(), event));
    }
}
