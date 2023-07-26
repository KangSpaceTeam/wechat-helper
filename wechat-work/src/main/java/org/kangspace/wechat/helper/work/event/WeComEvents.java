package org.kangspace.wechat.helper.work.event;

import java.util.Arrays;

/**
 * 企业微信事件枚举<br>
 * 指定各事件类型对应的实体类。
 *
 * @author kango2gler@gmail.com
 * @see WeComChangeTypeEvents
 * @since 2023/7/25
 */
public enum WeComEvents {
    /**
     * 通讯录回调通知-成员变更事件
     */
    CHANGE_CONTACT(ChangeContactEvent.EVENT, ChangeContactEvent.class),

    ;

    /**
     * 事件值
     */
    private final String event;
    /**
     * 事件映射的对象
     */
    private final Class<? extends WeComXmlEvent> mappingClass;

    WeComEvents(String event, Class<? extends WeComXmlEvent> mappingClass) {
        this.event = event;
        this.mappingClass = mappingClass;
    }

    /**
     * 通过Event获取事件处理对象(指定事件不存在时,返回{@link WeComXmlEvent})
     *
     * @param event 事件值
     * @return mappingClass 事件映射的对象
     */
    public static Class<? extends WeComXmlEvent> getMappingClassByEvent(String event) {
        Class<? extends WeComXmlEvent> mappingClass = Arrays.stream(values()).filter(t -> t.getEvent().equals(event)).map(WeComEvents::getMappingClass).findFirst().orElse(null);
        return mappingClass != null ? mappingClass : WeComXmlEvent.class;
    }

    public String getEvent() {
        return event;
    }

    public Class<? extends WeComXmlEvent> getMappingClass() {
        return mappingClass;
    }
}
