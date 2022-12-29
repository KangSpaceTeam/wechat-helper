package org.kangspace.wechat.helper.mp.event;

import org.kangspace.wechat.helper.core.event.WeChatEventHandler;
import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;

/**
 * 微信公众号事件处理器
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public interface WeChatMpEventHandler extends WeChatEventHandler<WeChatMpService, WeChatMpEvent, WeChatMpEchoMessage> {
    /**
     * 处理消息
     *
     * @param service {@link WeChatMpService}
     * @param event   {@link WeChatMpEvent}
     * @param context {@link MessageResolverContext} 消息处理上下文对象
     */
    @Override
    WeChatMpEchoMessage handle(WeChatMpService service, WeChatMpEvent event, MessageResolverContext context);
}
