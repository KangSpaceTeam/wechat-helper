package org.kangspace.wechat.helper.work.event;

import org.kangspace.wechat.helper.core.event.WeChatEventHandler;
import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.work.WeComService;
import org.kangspace.wechat.helper.work.message.WeComMessageHandler;
import org.kangspace.wechat.helper.work.message.response.WeComEchoMessage;

/**
 * 企业微信事件处理器
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/25
 */
public interface WeComEventHandler<Event extends WeComEvent> extends WeChatEventHandler<WeComService, Event, WeComEchoMessage>, WeComMessageHandler<Event> {

    /**
     * 处理事件消息
     *
     * @param service {@link WeComService}
     * @param message {@link WeComEvent}
     * @param context {@link MessageResolverContext} 消息处理上下文对象
     * @return {@link WeComEchoMessage}
     */
    @Override
    default WeComEchoMessage handle(WeComService service, Event message, MessageResolverContext context) {
        execute(service, message, context);
        return null;
    }

    @Override
    default void execute(WeComService service, Event weChatMessage, MessageResolverContext context) {
        WeComMessageHandler.super.execute(service, weChatMessage, context);
    }

    @SuppressWarnings("unchecked")
    @Override
    default Class<? extends Event> supportType() {
        return (Class<? extends Event>) WeComEvent.class;
    }
}
