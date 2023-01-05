package org.kangspace.wechat.helper.platform.message;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.event.WeChatMpEvent;
import org.kangspace.wechat.helper.mp.event.WeChatMpEventHandler;
import org.kangspace.wechat.helper.mp.event.WeChatMpXmlEvent;
import org.kangspace.wechat.helper.mp.message.response.TextEchoMessage;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 事件消息解析器
 * @author kango2gler@gmail.com
 * @since 2023/1/5
 */
@Slf4j
@Component
public class EventResolver implements WeChatMpEventHandler<WeChatMpXmlEvent> {

    @Override
    public WeChatMpEchoMessage handle(WeChatMpService service, WeChatMpXmlEvent event, MessageResolverContext context) {
        log.info("消息解析器: message: {}, context: {}", event, context);
        TextEchoMessage xmlMessage = new TextEchoMessage();
        BeanUtils.copyProperties(event, xmlMessage);
        String content = "event: " + event.getEvent() + ", eventKey: " + event.getEventKey();
        xmlMessage.setContent(event.getEventKey());
        log.info("消息解析器: 响应消息: {}", xmlMessage);
        return xmlMessage;
    }
}
