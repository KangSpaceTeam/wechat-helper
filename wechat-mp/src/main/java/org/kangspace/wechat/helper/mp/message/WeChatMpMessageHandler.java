package org.kangspace.wechat.helper.mp.message;

import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.core.message.WeChatMessage;
import org.kangspace.wechat.helper.core.message.WeChatMessageHandler;
import org.kangspace.wechat.helper.mp.WeChatMpService;

/**
 * 微信公众号消息处理器
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public interface WeChatMpMessageHandler extends WeChatMessageHandler<WeChatMpService, WeChatMpMessage> {
    /**
     * 处理消息
     *
     * @param service {@link WeChatMpService}
     * @param message {@link WeChatMessage}
     * @param context {@link MessageResolverContext} 消息处理上下文对象
     */
    @Override
    void handle(WeChatMpService service, WeChatMpMessage message, MessageResolverContext context);
}
