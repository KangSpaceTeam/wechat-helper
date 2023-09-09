package org.kangspace.wechat.helper.work.message;

import org.kangspace.devhelper.xml.XmlParser;
import org.kangspace.wechat.helper.work.event.WeComChangeTypeEvents;
import org.kangspace.wechat.helper.work.event.WeComEvents;
import org.kangspace.wechat.helper.work.event.WeComXmlEvent;

/**
 * "消息映射处理类"转换器<br>
 * 目的: 将消息转换为已知的处理类型
 *
 * @author kango2gler@gmail.com
 * @see org.kangspace.wechat.helper.work.event.WeComEvents
 * @see org.kangspace.wechat.helper.work.message.WeComMessages
 * @since 2023/7/25
 */
public class MessageMappingClassConverter {

    /**
     * "消息映射处理类"转换<br>
     * <pre>
     * 规则:
     * 1. event 转换为 {@link WeComXmlEvent}
     * 2. message 转换为 {@link WeComXmlMessage}
     * </pre>
     *
     * @param message 原始消息
     * @see org.kangspace.wechat.helper.work.event.WeComEvents
     * @see org.kangspace.wechat.helper.work.message.WeComMessages
     */
    public static WeComXmlMessage convert(WeComXmlMessage message) {
        boolean isEvent = MessageConstant.MessageType.EVENT.equals(message.getMsgType());
        Class<?> messageMappingClass;
        if (isEvent) {
            String event = message.getEvent();
            messageMappingClass = WeComEvents.getMappingClassByEvent(event);
            String changeType;
            if (messageMappingClass.isAssignableFrom(WeComChangeTypeEvents.class)
                    && (changeType = message.getChangeType()) != null) {
                messageMappingClass = WeComChangeTypeEvents.getMappingClassByChangeType(changeType);
            }
        } else {
            messageMappingClass = WeComMessages.getMappingClassByMsgType(message.getMsgType());
        }
        // 若非通用消息类型时, 解析原始数据为指定的对象类型
        if (!messageMappingClass.equals(WeComXmlMessage.class)) {
            String rawMessage = message.getRaw();
            message = (WeComXmlMessage) XmlParser.parse(rawMessage, messageMappingClass);
            message.setRaw(rawMessage);
        }
        return message;
    }
}
