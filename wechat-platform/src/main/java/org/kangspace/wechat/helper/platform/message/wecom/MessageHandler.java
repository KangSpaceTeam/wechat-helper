package org.kangspace.wechat.helper.platform.message.wecom;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.work.WeComService;
import org.kangspace.wechat.helper.work.message.WeComMessage;
import org.kangspace.wechat.helper.work.message.WeComMessageHandler;
import org.kangspace.wechat.helper.work.message.response.WeComEchoMessage;
import org.springframework.stereotype.Component;

/**
 * @author kango2gler@gmail.com
 * @since 2023/8/6
 */
@Component("weComMessageHandler")
@Slf4j
public class MessageHandler implements WeComMessageHandler<WeComMessage> {
    @Override
    public WeComEchoMessage handle(WeComService service, WeComMessage message, MessageResolverContext context) {
        log.info("企业微信消息解析器: message: {}, context: {}", message, context);
        return WeComMessageHandler.super.handle(service, message, context);
    }
}
