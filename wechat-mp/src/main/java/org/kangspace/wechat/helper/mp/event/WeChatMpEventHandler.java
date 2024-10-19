package org.kangspace.wechat.helper.mp.event;

import org.kangspace.wechat.helper.core.event.WeChatEventHandler;
import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessage;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessageHandler;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;

/**
 * 微信公众号事件处理器
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public interface WeChatMpEventHandler<Event extends WeChatMpEvent> extends WeChatEventHandler<WeChatMpService, Event, WeChatMpEchoMessage>, WeChatMpMessageHandler<Event> {

    /**
     * 处理事件消息
     *
     * @param service {@link WeChatMpService}
     * @param message {@link WeChatMpEvent}
     * @param context {@link MessageResolverContext} 消息处理上下文对象
     * @return {@link WeChatMpEchoMessage}
     */
    @Override
    default WeChatMpEchoMessage handle(WeChatMpService service, Event message, MessageResolverContext context) {
        execute(service, message, context);
        return null;
    }

    @Override
    default void execute(WeChatMpService service, Event weChatMessage, MessageResolverContext context) {
        WeChatMpMessageHandler.super.execute(service, weChatMessage, context);
    }

    Class<? extends Event> supportType();

    @SuppressWarnings("unchecked")
    default Class<? extends Event> defaultSupportType() {
        return (Class<? extends Event>) WeChatMpEvent.class;
    }
}
