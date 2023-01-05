package org.kangspace.wechat.helper.platform.message;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.core.message.response.WeChatEchoXmlMessage;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessage;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessageHandler;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoXmlMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 消息解析器
 * @author kango2gler@gmail.com
 * @since 2023/1/5
 */
@Slf4j
@Component
public class MessageResolver implements WeChatMpMessageHandler<WeChatMpMessage> {

    @Override
    public WeChatMpEchoMessage handle(WeChatMpService service, WeChatMpMessage message, MessageResolverContext context) {
        log.info("消息解析器: message: {}, context: {}", message, context);
        WeChatMpEchoXmlMessage xmlMessage = new WeChatMpEchoXmlMessage();
        BeanUtils.copyProperties(message, xmlMessage);
        log.info("消息解析器: 响应消息: {}", xmlMessage);
        return xmlMessage;
    }
}
