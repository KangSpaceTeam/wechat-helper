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
    // 自定义菜单事件 start
    /**
     * 菜单点击事件
     */
    Click("CLICK", MenuClickEvent.class),
    /**
     * 点击菜单跳转链接时的事件
     */
    View("VIEW", MenuViewEvent.class),
    /**
     * scancode_push：扫码推事件的事件推送
     */
    ScanCodePush("scancode_push", MenuScanCodePushEvent.class),
    /**
     * scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框的事件
     */
    ScanCodeWaitMsg("scancode_waitmsg", MenuScanCodeWaitMsgEvent.class),
    /**
     * pic_sysphoto：弹出系统拍照发图的事件
     */
    PicSysPhoto("pic_sysphoto", MenuPicSysPhotoEvent.class),
    /**
     * pic_photo_or_album：弹出拍照或者相册发图的事件
     */
    PicPhotoOrAlbum("pic_photo_or_album", MenuPicPhotoOrAlbumEvent.class),
    /**
     * pic_weixin：弹出微信相册发图器的事件
     */
    PicWeiXin("pic_weixin", MenuPicWeiXinEvent.class),
    /**
     * location_select：弹出地理位置选择器的事件
     */
    LocationSelect("location_select", MenuLocationSelectEvent.class),
    /**
     * pic_weixin：弹出微信相册发图器的事件
     */
    ViewMiniProgram("view_miniprogram", MenuPicWeiXinEvent.class),
    // 自定义菜单事件 end

    /**
     * 关注事件
     */
    Subscribe("subscribe", SubscribeEvent.class),
    /**
     * 取消关注事件
     */
    Unsubscribe("unsubscribe", UnsubscribeEvent.class),
    /**
     * 用户已关注时的事件推送
     */
    Scan("SCAN", ScanEvent.class),
    /**
     * 上报地理位置事件
     */
    Location("LOCATION", LocationEvent.class),

    /**
     * 模板消息发送成功事件推送
     * 文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html#5">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html#5</a>
     */
    TemplateSendJobFinish("TEMPLATESENDJOBFINISH", LocationEvent.class),

    // 用户管理订阅通知事件 start

    /**
     * 用户操作订阅通知弹窗<br>
     * 场景：用户在图文等场景内订阅通知的操作<br>
     * 文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html</a><br>
     */
    SubscribeMsgPopupEvent("subscribe_msg_popup_event", SubscribeMsgPopupEventEvent.class),

    /**
     * 用户管理订阅通知<br>
     * 场景：用户在服务通知管理页面做通知管理时的操作<br>
     * 文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html</a><br>
     */
    SubscribeMsgChangeEvent("subscribe_msg_change_event", SubscribeMsgChangeEventEvent.class),

    /**
     * 发送订阅通知<br>
     * 场景：调用 bizsend 接口发送通知<br>
     * 文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html</a><br>
     */
    SubscribeMsgSentEvent("subscribe_msg_sent_event", SubscribeMsgChangeEventEvent.class),

    // 用户管理订阅通知事件 end

    // 授权用户信息变更事件 start
    /**
     * 授权用户信息变更-授权用户资料变更<br>
     * <p>
     * 1、 授权用户资料变更：当部分用户的资料存在风险时，平台会对用户资料进行清理，并通过消息推送服务器通知最近30天授权过的公众号开发者，我们建议开发者留意响应该事件，及时主动更新或清理用户的头像及昵称，降低风险。
     * (user_info_modified)<br>
     * 2、 授权用户资料撤回：当用户撤回授权信息时，平台会通过消息推送服务器通知给公众号开发者，请开发者注意及时删除用户信息。
     * (user_authorization_revoke)<br>
     * 3、 授权用户完成注销：当授权用户完成注销后，平台会通过消息推送服务器通知给公众号开发者，请依法依规及时履行相应个人信息保护义务，保护用户权益。
     * (user_authorization_cancellation)<br>
     * </p>
     * 文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/authorization_change.html">https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/authorization_change.html</a><br>
     */
    UserInfoModifiedEvent("user_info_modified", UserAuthorizationRevokeEvent.class),
    /**
     * 授权用户信息变更-授权用户资料撤回<br>
     * <p>
     * 1、 授权用户资料变更：当部分用户的资料存在风险时，平台会对用户资料进行清理，并通过消息推送服务器通知最近30天授权过的公众号开发者，我们建议开发者留意响应该事件，及时主动更新或清理用户的头像及昵称，降低风险。
     * (user_info_modified)<br>
     * 2、 授权用户资料撤回：当用户撤回授权信息时，平台会通过消息推送服务器通知给公众号开发者，请开发者注意及时删除用户信息。
     * (user_authorization_revoke)<br>
     * 3、 授权用户完成注销：当授权用户完成注销后，平台会通过消息推送服务器通知给公众号开发者，请依法依规及时履行相应个人信息保护义务，保护用户权益。
     * (user_authorization_cancellation)<br>
     * </p>
     * 文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/authorization_change.html">https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/authorization_change.html</a><br>
     */
    UserAuthorizationRevokeEvent("user_authorization_revoke", UserAuthorizationRevokeEvent.class),

    /**
     * 授权用户信息变更-授权用户完成注销<br>
     * <p>
     * 1、 授权用户资料变更：当部分用户的资料存在风险时，平台会对用户资料进行清理，并通过消息推送服务器通知最近30天授权过的公众号开发者，我们建议开发者留意响应该事件，及时主动更新或清理用户的头像及昵称，降低风险。
     * (user_info_modified)<br>
     * 2、 授权用户资料撤回：当用户撤回授权信息时，平台会通过消息推送服务器通知给公众号开发者，请开发者注意及时删除用户信息。
     * (user_authorization_revoke)<br>
     * 3、 授权用户完成注销：当授权用户完成注销后，平台会通过消息推送服务器通知给公众号开发者，请依法依规及时履行相应个人信息保护义务，保护用户权益。
     * (user_authorization_cancellation)<br>
     * </p>
     * 文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/authorization_change.html">https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/authorization_change.html</a><br>
     */
    UserAuthorizationCancellationEvent("user_authorization_cancellation", UserAuthorizationRevokeEvent.class),

    // 授权用户信息变更事件 end


    ;

    /**
     * 事件值
     */
    private final String event;
    /**
     * 事件映射的对象
     */
    private final Class<? extends WeChatMpXmlEvent> mappingClass;

    WeChatMpEvents(String event, Class<? extends WeChatMpXmlEvent> mappingClass) {
        this.event = event;
        this.mappingClass = mappingClass;
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

    public String getEvent() {
        return event;
    }

    public Class<? extends WeChatMpXmlEvent> getMappingClass() {
        return mappingClass;
    }
}
