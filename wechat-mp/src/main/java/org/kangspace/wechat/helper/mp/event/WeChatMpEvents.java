package org.kangspace.wechat.helper.mp.event;

import java.util.Arrays;

/**
 * 微信公众号事件枚举<br>
 * 指定各事件类型对应的实体类。
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/29
 */
public enum WeChatMpEvents {
    /**
     * 菜单点击事件
     */
    CLICK("CLICK", MenuClickEvent.class),
    ;
    /**
     * 事件值
     */
    private String event;
    /**
     * 事件映射的对象
     */
    private Class<? extends WeChatMpXmlEvent> mappingClass;

    WeChatMpEvents(String event, Class<? extends WeChatMpXmlEvent> mappingClass) {
        this.event = event;
        this.mappingClass = mappingClass;
    }

    public String getEvent() {
        return event;
    }

    public Class<? extends WeChatMpXmlEvent> getMappingClass() {
        return mappingClass;
    }

    /**
     * 通过Event获取事件处理对象(指定事件不存在时,返回{@link WeChatMpXmlEvent})
     *
     * @param event 事件值
     * @return mappingClass 事件映射的对象
     */
    public static Class<? extends WeChatMpXmlEvent> getMappingClassByEvent(String event) {
        Class<? extends WeChatMpXmlEvent> mappingClass = Arrays.stream(values()).filter(t -> t.getEvent().equals(event)).map(WeChatMpEvents::getMappingClass).findFirst().orElse(null);
        return mappingClass != null ? mappingClass : WeChatMpXmlEvent.class;
    }
}
