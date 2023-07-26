package org.kangspace.wechat.helper.work.event;

import java.util.Arrays;

/**
 * 企业微信事件-changeType子类型枚举<br>
 * 指定各事件类型对应的实体类。<br>
 * 依赖 {@link WeComEvents} 确认主事件, 并且主事件对象需实现{@link WeComChangeTypeEvent}<br>
 *
 * @author kango2gler@gmail.com
 * @see WeComEvents
 * @since 2023/7/25
 */
public enum WeComChangeTypeEvents {
    /**
     * 通讯录回调通知-成员变更事件-创建成员
     */
    CHANGE_CONTACT_CREATE_USER_EVENT(ChangeContactEvent.ChangeType.CREATE_USER.getChangeType(), ChangeContactCreateUserEvent.class),
    /**
     * 通讯录回调通知-成员变更事件-更新成员
     */
    CHANGE_CONTACT_UPDATE_USER_EVENT(ChangeContactEvent.ChangeType.UPDATE_USER.getChangeType(), ChangeContactUpdateUserEvent.class),
    /**
     * 通讯录回调通知-成员变更事件-删除成员
     */
    CHANGE_CONTACT_DELETE_USER_EVENT(ChangeContactEvent.ChangeType.DELETE_USER.getChangeType(), ChangeContactDeleteUserEvent.class),

    /**
     * 通讯录回调通知-部门变更事件-创建部门
     */
    CHANGE_CONTACT_CREATE_PARTY_EVENT(ChangeContactEvent.ChangeType.CREATE_PARTY.getChangeType(), ChangeContactCreatePartyEvent.class),
    /**
     * 通讯录回调通知-部门变更事件-更新部门
     */
    CHANGE_CONTACT_UPDATE_PARTY_EVENT(ChangeContactEvent.ChangeType.UPDATE_PARTY.getChangeType(), ChangeContactUpdatePartyEvent.class),
    /**
     * 通讯录回调通知-部门变更事件-删除部门
     */
    CHANGE_CONTACT_DELETE_PARTY_EVENT(ChangeContactEvent.ChangeType.DELETE_PARTY.getChangeType(), ChangeContactDeletePartyEvent.class),

    /**
     * 通讯录回调通知-标签变更通知-标签成员变更事件
     */
    CHANGE_CONTACT_UPDATE_TAG_EVENT(ChangeContactEvent.ChangeType.UPDATE_TAG.getChangeType(), ChangeContactUpdateTagEvent.class),

    ;

    /**
     * 事件值
     */
    private final String changeType;
    /**
     * 事件映射的对象
     */
    private final Class<? extends WeComXmlEvent> mappingClass;

    WeComChangeTypeEvents(String changeType, Class<? extends WeComXmlEvent> mappingClass) {
        this.changeType = changeType;
        this.mappingClass = mappingClass;
    }

    /**
     * 通过Event获取事件处理对象(指定事件不存在时,返回{@link WeComXmlEvent})
     *
     * @param changeType 事件值
     * @return mappingClass 事件映射的对象
     */
    public static Class<? extends WeComXmlEvent> getMappingClassByChangeType(String changeType) {
        Class<? extends WeComXmlEvent> mappingClass = Arrays.stream(values()).filter(t -> t.getChangeType().equals(changeType)).map(WeComChangeTypeEvents::getMappingClass).findFirst().orElse(null);
        return mappingClass != null ? mappingClass : WeComXmlEvent.class;
    }

    public String getChangeType() {
        return changeType;
    }

    public Class<? extends WeComXmlEvent> getMappingClass() {
        return mappingClass;
    }
}
