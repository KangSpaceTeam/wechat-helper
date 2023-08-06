package org.kangspace.wechat.helper.platform.message.wecom;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.work.WeComService;
import org.kangspace.wechat.helper.work.event.WeComEventHandler;
import org.kangspace.wechat.helper.work.event.WeComXmlEvent;
import org.kangspace.wechat.helper.work.message.response.WeComEchoMessage;
import org.springframework.stereotype.Component;

/**
 * 企业微信事件处理器
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/6
 */
@Component("weComEventHandler")
@Slf4j
public class EventHandler implements WeComEventHandler<WeComXmlEvent> {
    @Override
    public WeComEchoMessage handle(WeComService service, WeComXmlEvent event, MessageResolverContext context) {
        log.info("企业微信事件解析器: message: {}, context: {}", event, context);
        return WeComEventHandler.super.handle(service, event, context);
    }

}
