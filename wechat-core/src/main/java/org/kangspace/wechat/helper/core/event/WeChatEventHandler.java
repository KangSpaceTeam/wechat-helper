package org.kangspace.wechat.helper.core.event;

import org.kangspace.wechat.helper.core.WeChatService;
import org.kangspace.wechat.helper.core.message.WeChatMessageHandler;

/**
 * 事件处理器
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/12
 */
public interface WeChatEventHandler<Service extends WeChatService, Event extends WeChatEvent> extends WeChatMessageHandler<Service, Event> {
}
