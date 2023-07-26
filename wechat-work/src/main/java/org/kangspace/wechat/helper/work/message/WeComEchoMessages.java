package org.kangspace.wechat.helper.work.message;

import java.util.Arrays;

/**
 * 企业微信响应消息枚举(被动回复)<br>
 * 指定各消息类型对应的实体类。
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/25
 */
public enum WeComEchoMessages {

    ;

    /**
     * 消息类型
     */
    private final MessageConstant.MessageType msgType;
    /**
     * 事件映射的对象
     */
    private final Class<? extends WeComXmlMessage> mappingClass;

    WeComEchoMessages(MessageConstant.MessageType msgType, Class<? extends WeComXmlMessage> mappingClass) {
        this.msgType = msgType;
        this.mappingClass = mappingClass;
    }

    /**
     * 通过MsgType获取事件处理对象(指定消息类型不存在时,返回{@link WeComXmlMessage})
     *
     * @param msgType 消息类型
     * @return mappingClass 消息映射的对象
     */
    public static Class<? extends WeComXmlMessage> getMappingClassByMsgType(MessageConstant.MessageType msgType) {
        Class<? extends WeComXmlMessage> mappingClass = Arrays.stream(values()).filter(t -> t.getMsgType().equals(msgType)).map(WeComEchoMessages::getMappingClass).findFirst().orElse(null);
        return mappingClass != null ? mappingClass : WeComXmlMessage.class;
    }

    public MessageConstant.MessageType getMsgType() {
        return msgType;
    }

    public Class<? extends WeComXmlMessage> getMappingClass() {
        return mappingClass;
    }
}
