package org.kangspace.wechat.helper.platform.message;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.core.util.ReflectUtil;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.constant.MessageConstant;
import org.kangspace.wechat.helper.mp.message.WeChatMpEchoMessages;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessage;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessageHandler;
import org.kangspace.wechat.helper.mp.message.response.TextEchoMessage;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoXmlMessage;
import org.springframework.beans.BeanUtils;
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
        MessageConstant.MessageType messageType = message.getMsgType();
        Class<?> mappingClassByMsgType = WeChatMpEchoMessages.getMappingClassByMsgType(messageType);
        WeChatMpEchoXmlMessage xmlMessage;
        // 存在对应类型的被动回复消息类型
        if (mappingClassByMsgType != null) {
            xmlMessage = (WeChatMpEchoXmlMessage) ReflectUtil.newInstance(mappingClassByMsgType);
            BeanUtils.copyProperties(message, xmlMessage);
        }else {
            // 返回文本消息
            String content = "msgId: " + message.getMsgId() + ", msgType: {}" + message.getMsgType();
            xmlMessage = new TextEchoMessage(message.getToUser(), message.getFromUser(), message.getCreateTime(), System.currentTimeMillis(), content);
        }
        String toUser = message.getToUser();
        String fromUser = message.getFromUser();
        xmlMessage.setFromUser(toUser);
        xmlMessage.setToUser(fromUser);
        log.info("消息解析器: 响应消息: {}", xmlMessage);
        return xmlMessage;
    }
}
