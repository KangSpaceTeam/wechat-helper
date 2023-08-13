package org.kangspace.wechat.helper.work.event;

import lombok.Getter;

import java.util.Arrays;

/**
 * 企业微信事件枚举<br>
 * 指定各事件类型对应的实体类。
 *
 * @author kango2gler@gmail.com
 * @see WeComChangeTypeEvents
 * @since 2023/7/25
 */
@Getter
public enum WeComEvents {
    /**
     * 通讯录回调通知-成员变更事件
     */
    CHANGE_CONTACT(ChangeContactEvent.EVENT, ChangeContactEvent.class),
    /**
     * 成员关注事件
     */
    SUBSCRIBE(SubscribeEvent.EVENT, SubscribeEvent.class),
    /**
     * 成员取消关注事件
     */
    UNSUBSCRIBE(UnsubscribeEvent.EVENT, UnsubscribeEvent.class),
    /**
     * 进入应用
     */
    ENTER_AGENT(EnterAgentEvent.EVENT, EnterAgentEvent.class),
    /**
     * 上报地理位置
     */
    LOCATION(LocationEvent.EVENT, LocationEvent.class),
    /**
     * 异步任务完成事件推送
     */
    BATCH_JOB_RESULT(BatchJobResultEvent.EVENT, BatchJobResultEvent.class),
    /**
     * 菜单事件-点击菜单拉取消息的事件推送
     */
    CLICK(ClickEvent.EVENT, ClickEvent.class),
    /**
     * 菜单事件-点击菜单跳转链接的事件推送
     */
    VIEW(ViewEvent.EVENT, ViewEvent.class),

    /**
     * 菜单事件-扫码推事件的事件推送
     */
    SCAN_CODE_PUSH(ScanCodePushEvent.EVENT, ScanCodePushEvent.class),

    /**
     * 菜单事件-扫码推事件且弹出“消息接收中”提示框的事件推送
     */
    SCANCODE_WAIT_MSG(ScanCodeWaitMsgEvent.EVENT, ScanCodeWaitMsgEvent.class),

    /**
     * 菜单事件-弹出系统拍照发图的事件推送
     */
    PIC_SYS_PHOTO(PicSysPhotoEvent.EVENT, PicSysPhotoEvent.class),

    /**
     * 菜单事件-弹出拍照或者相册发图的事件推送
     */
    PIC_PHOTO_OR_ALBUM(PicPhotoOrAlbumEvent.EVENT, PicPhotoOrAlbumEvent.class),

    /**
     * 菜单事件-弹出微信相册发图器的事件推送
     */
    pic_wei_xin(PicWeiXinEvent.EVENT, PicWeiXinEvent.class),

    /**
     * 菜单事件-弹出地理位置选择器的事件推送
     */
    LOCATION_SELECT(LocationSelectEvent.EVENT, LocationSelectEvent.class),

    /**
     * 审批状态通知事件
     */
    OPEN_APPROVAL_CHANGE(OpenApprovalChangeEvent.EVENT, OpenApprovalChangeEvent.class),

    /**
     * 企业互联共享应用事件回调
     */
    SHARE_AGENT_CHANGE(ShareAgentChangeEvent.EVENT, ShareAgentChangeEvent.class),

    /**
     * 上下游共享应用事件回调
     */
    SHARE_CHAIN_CHANGE(ShareChainChangeEvent.EVENT, ShareChainChangeEvent.class),

    /**
     * 模板卡片事件推送
     */
    TEMPLATE_CARD_EVENT(TemplateCardEventEvent.EVENT, TemplateCardEventEvent.class),

    /**
     * 通用模板卡片右上角菜单事件推送
     */
    TEMPLATE_CARD_MENU_EVENT(TemplateCardMenuEventEvent.EVENT, TemplateCardMenuEventEvent.class),

    /**
     * 长期未使用应用临时停用事件
     */
    CLOSE_INACTIVE_AGENT(CloseInactiveAgentEvent.EVENT, CloseInactiveAgentEvent.class),

    /**
     * 长期未使用应用重新启用事件
     */
    REOPEN_INACTIVE_AGENT(ReopenInactiveAgentEvent.EVENT, ReopenInactiveAgentEvent.class),

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

}
