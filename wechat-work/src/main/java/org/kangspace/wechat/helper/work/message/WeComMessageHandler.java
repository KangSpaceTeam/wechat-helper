package org.kangspace.wechat.helper.work.message;

import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.core.message.WeChatMessageHandler;
import org.kangspace.wechat.helper.work.WeComService;
import org.kangspace.wechat.helper.work.message.response.WeComEchoMessage;

/**
 * 企业微信消息处理器
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/25
 */
public interface WeComMessageHandler<Message extends WeComMessage> extends WeChatMessageHandler<WeComService, Message, WeComEchoMessage> {
    /**
     * 处理消息
     *
     * @param service {@link WeComService}
     * @param message {@link WeComMessage}
     * @param context {@link MessageResolverContext} 消息处理上下文对象
     * @return {@link WeComEchoMessage}
     */
    @Override
    default WeComEchoMessage handle(WeComService service, Message message, MessageResolverContext context) {
        execute(service, message, context);
        return null;
    }

    /**
     * 处理消息(无返回值)
     *
     * @param service {@link WeComService}
     * @param message {@link WeComMessage}
     * @param context {@link MessageResolverContext} 消息处理上下文对象
     */
    default void execute(WeComService service, Message message, MessageResolverContext context) {
        WeChatMessageHandler.super.handle(service, message, context);
    }

    @SuppressWarnings("unchecked")
    @Override
    default Class<? extends Message> supportType() {
        return (Class<? extends Message>) WeComMessage.class;
    }
}
