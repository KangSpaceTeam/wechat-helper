package org.kangspace.wechat.helper.mp.message;

import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.core.message.WeChatMessageHandler;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;

/**
 * 微信公众号消息处理器
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public interface WeChatMpMessageHandler<Message extends WeChatMpMessage> extends WeChatMessageHandler<WeChatMpService, Message, WeChatMpEchoMessage> {
    /**
     * 处理消息
     *
     * @param service {@link WeChatMpService}
     * @param message {@link WeChatMpMessage}
     * @param context {@link MessageResolverContext} 消息处理上下文对象
     * @return {@link WeChatMpEchoMessage}
     */
    @Override
    default WeChatMpEchoMessage handle(WeChatMpService service, Message message, MessageResolverContext context) {
        execute(service, message, context);
        return null;
    }

    /**
     * 处理消息(无返回值)
     *
     * @param service {@link WeChatMpService}
     * @param message {@link WeChatMpMessage}
     * @param context {@link MessageResolverContext} 消息处理上下文对象
     */
    default void execute(WeChatMpService service, Message message, MessageResolverContext context) {
        WeChatMessageHandler.super.handle(service, message, context);
    }

    @SuppressWarnings("unchecked")
    default Class<? extends Message> supportType() {
        return (Class<? extends Message>) WeChatMpMessage.class;
    }
}
