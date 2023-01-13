package org.kangspace.wechat.helper.core.event;

import org.kangspace.wechat.helper.core.WeChatService;
import org.kangspace.wechat.helper.core.message.WeChatMessageHandler;
import org.kangspace.wechat.helper.core.message.WeChatMessageResolver;
import org.kangspace.wechat.helper.core.message.response.WeChatEchoMessage;

/**
 * 微信事件解析器, 同微信消息解析器
 *
 * @author kango2gler@gmail.com
 * @see WeChatMessageResolver
 * @since 2022/12/24
 */
public interface WeChatEventResolver<Service extends WeChatService,
        Handler extends WeChatMessageHandler<Service, Event, EchoMessage>,
        Event extends WeChatEvent,
        EchoMessage extends WeChatEchoMessage>
        extends WeChatMessageResolver<Service, Handler, Event, EchoMessage> {
}
