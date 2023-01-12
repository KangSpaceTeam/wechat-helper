package org.kangspace.wechat.helper.platform.message;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.event.WeChatMpEventHandler;
import org.kangspace.wechat.helper.mp.event.WeChatMpEvents;
import org.kangspace.wechat.helper.mp.event.WeChatMpXmlEvent;
import org.kangspace.wechat.helper.mp.message.response.TextEchoMessage;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 事件消息解析器
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/5
 */
@Slf4j
@Component
public class EventResolver implements WeChatMpEventHandler<WeChatMpXmlEvent> {

    @Override
    public WeChatMpEchoMessage handle(WeChatMpService service, WeChatMpXmlEvent event, MessageResolverContext context) {
        log.info("消息解析器: message: {}, context: {}", event, context);
        TextEchoMessage xmlMessage = null;
        String eventType = event.getEvent();
        // 存在对应类型的被动回复消息类型
        if (WeChatMpEvents.Click.getEvent().equals(eventType) ||
                WeChatMpEvents.ScanCodeWaitMsg.getEvent().equals(eventType) ||
                WeChatMpEvents.Subscribe.getEvent().equals(eventType)) {
            xmlMessage = new TextEchoMessage();
            BeanUtils.copyProperties(event, xmlMessage);
            xmlMessage.setEvent(null);
            String content = "event: " + event.getEvent() + ", eventKey: " + event.getEventKey();
            xmlMessage.setContent(content);
            String toUser = event.getToUser();
            String fromUser = event.getFromUser();
            xmlMessage.setFromUser(toUser);
            xmlMessage.setToUser(fromUser);
        }
        log.info("消息解析器: 响应消息: {}", xmlMessage);
        return xmlMessage;
    }
}
