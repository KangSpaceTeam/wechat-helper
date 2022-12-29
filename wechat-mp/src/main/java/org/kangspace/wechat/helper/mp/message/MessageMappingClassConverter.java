package org.kangspace.wechat.helper.mp.message;

import org.kangspace.wechat.helper.core.util.XmlParser;
import org.kangspace.wechat.helper.mp.constant.MessageConstant;
import org.kangspace.wechat.helper.mp.event.WeChatMpEvents;
import org.kangspace.wechat.helper.mp.event.WeChatMpXmlEvent;

/**
 * "消息映射处理类"转换器<br>
 * 目的: 将消息转换为已知的处理类型
 *
 * @author kango2gler@gmail.com
 * @see org.kangspace.wechat.helper.mp.event.WeChatMpEvents
 * @see org.kangspace.wechat.helper.mp.message.WeChatMpMessages
 * @since 2022/12/29
 */
public class MessageMappingClassConverter {

    /**
     * "消息映射处理类"转换<br>
     * <pre>
     * 规则:
     * 1. event 转换为 {@link WeChatMpXmlEvent}
     * 2. message 转换为 {@link WeChatMpXmlMessage}
     * </pre>
     *
     * @param message 原始消息
     * @see org.kangspace.wechat.helper.mp.event.WeChatMpEvents
     * @see org.kangspace.wechat.helper.mp.message.WeChatMpMessages
     */
    public static WeChatMpXmlMessage convert(WeChatMpXmlMessage message) {
        boolean isEvent = MessageConstant.MessageType.EVENT.equals(message.getMsgType());
        Class<?> messageMappingClass;
        if (isEvent) {
            String event = message.getEvent();
            messageMappingClass = WeChatMpEvents.getMappingClassByEvent(event);
        } else {
            messageMappingClass = WeChatMpMessages.getMappingClassByMsgType(message.getMsgType());
        }
        // 若非通用消息类型时, 解析原始数据为指定的对象类型
        if (!messageMappingClass.equals(WeChatMpXmlMessage.class)) {
            String rawMessage = message.getRaw();
            message = (WeChatMpXmlMessage) XmlParser.parse(rawMessage, messageMappingClass);
            message.setRaw(rawMessage);
        }
        return message;
    }
}
