package org.kangspace.wechat.helper.mp.event;

import org.kangspace.wechat.helper.core.event.WeChatEventHandler;
import org.kangspace.wechat.helper.mp.WeChatMpService;

/**
 * 微信公众号事件处理器
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public interface WeChatMpEventHandler extends WeChatEventHandler<WeChatMpService, WeChatMpEvent> {
    /**
     * 处理消息
     *
     * @param service {@link WeChatMpService}
     * @param event   {@link WeChatMpEvent}
     */
    @Override
    void handle(WeChatMpService service, WeChatMpEvent event);
}
