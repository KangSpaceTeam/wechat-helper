package org.kangspace.wechat.helper.mp.constant;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 自定义菜单常量
 * @author kango2gler@gmail.com
 * @since 2022/12/10
 */
public interface CustomMenuConstant {

    /**
     * 按钮类型 <br>
     * 请注意，3到8的所有事件，仅支持微信iPhone5.4.1以上版本，和Android5.4以上版本的微信用户，旧版本微信用户点击后将没有回应，开发者也不能正常接收到事件推送。9～12，是专门给第三方平台旗下未微信认证（具体而言，是资质认证未通过）的订阅号准备的事件类型，它们是没有事件推送的，能力相对受限，其他类型的公众号不必使用。 <br>
     * 公众平台官网上能够设置的菜单类型有view（跳转网页）、text（返回文本，下同）、img、photo、video、voice<br>
     * 使用 API 设置的则有8种，详见《自定义菜单创建接口》<br>
     * 文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Creating_Custom-Defined_Menu.html">https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Creating_Custom-Defined_Menu.html</a>
     */
    enum ButtonType{
        /**
         * 1. click：点击推事件用户点击 click 类型按钮后，微信服务器会通过消息接口推送消息类型为 event 的结构给开发者（参考消息接口指南），并且带上按钮中开发者填写的 key 值，开发者可以通过自定义的 key 值与用户进行交互；
         */
        CLICK,
        /**
         * 2. view：跳转 URL 用户点击 view 类型按钮后，微信客户端将会打开开发者在按钮中填写的网页URL，可与网页授权获取用户基本信息接口结合，获得用户基本信息。
         */
        VIEW,
        /**
         * 3. scancode_push：扫码推事件用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后显示扫描结果（如果是URL，将进入URL），且会将扫码的结果传给开发者，开发者可以下发消息。
         */
        SCANCODE_PUSH,
        /**
         * 4. scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后，将扫码的结果传给开发者，同时收起扫一扫工具，然后弹出“消息接收中”提示框，随后可能会收到开发者下发的消息。
         */
        SCANCODE_WAITMSG,
        /**
         * 5. pic_sysphoto：弹出系统拍照发图用户点击按钮后，微信客户端将调起系统相机，完成拍照操作后，会将拍摄的相片发送给开发者，并推送事件给开发者，同时收起系统相机，随后可能会收到开发者下发的消息。
         */
        PIC_SYSPHOTO,
        /**
         * 6. pic_photo_or_album：弹出拍照或者相册发图用户点击按钮后，微信客户端将弹出选择器供用户选择“拍照”或者“从手机相册选择”。用户选择后即走其他两种流程。
         */
        PIC_PHOTO_OR_ALBUM,
        /**
         * 7. pic_weixin：弹出微信相册发图器用户点击按钮后，微信客户端将调起微信相册，完成选择操作后，将选择的相片发送给开发者的服务器，并推送事件给开发者，同时收起相册，随后可能会收到开发者下发的消息。
         */
        PIC_WEIXIN,
        /**
         * 8. location_select：弹出地理位置选择器用户点击按钮后，微信客户端将调起地理位置选择工具，完成选择操作后，将选择的地理位置发送给开发者的服务器，同时收起位置选择工具，随后可能会收到开发者下发的消息。
         */
        LOCATION_SELECT,
        /**
         * 9. media_id：下发消息（除文本消息）用户点击media_id类型按钮后，微信服务器会将开发者填写的永久素材 id 对应的素材下发给用户，永久素材类型可以是图片、音频、视频 、图文消息。请注意：永久素材 id 必须是在“素材管理/新增永久素材”接口上传后获得的合法id。
         */
        MEDIA_ID,
        /**
         * 11. article_id：用户点击 article_id 类型按钮后，微信客户端将会以卡片形式，下发开发者在按钮中填写的图文消息
         */
        ARTICLE_ID,
        /**
         * 12. article_view_limited：类似 view_limited，但不使用 media_id 而使用 article_id
         */
        ARTICLE_VIEW_LIMITED,
        /**
         * 小程序
         */
        MINIPROGRAM,
        //------- 公众平台官网上能够设置的菜单类型 -------
        /**
         * 文本
         */
        TEXT,
        /**
         * 图片
         */
        IMG,
        /**
         * 图片
         */
        PHOTO,
        /**
         * 视频
         */
        VIDEO,
        /**
         * 语音
         */
        VOICE
        ;
        @JsonValue
        public String getValue() {
            return this.name().toLowerCase();
        }

        @Override
        public String toString() {
            return getValue();
        }
    }

    /**
     * 菜单是否开启，0代表未开启，1代表开启
     */
    enum IsMenuOpen{
        /**
         * 未开启
         */
        NO(0),
        /**
         * 已开启
         */
        YES(1),
        ;
        private final int value;

        IsMenuOpen(int value) {
            this.value = value;
        }
        @JsonValue
        public int getValue() {
            return this.value;
        }

        /**
         * 通过value获取 IsMenuOpen
         * @param value value
         * @return {@link IsMenuOpen}
         */
        public IsMenuOpen parse(int value) {
            return Arrays.stream(values()).filter(t -> t.value == value).findFirst().orElse(null);
        }

        @Override
        public String toString() {
            return String.valueOf(getValue());
        }
    }
    /**
     * 是否显示封面，0为不显示，1为显示
     */
    enum ShowCover{
        /**
         * 不显示
         */
        NO(0),
        /**
         * 显示
         */
        YES(1),
        ;
        private final int value;

        ShowCover(int value) {
            this.value = value;
        }
        @JsonValue
        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(getValue());
        }
    }

    /**
     * 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)
     */
    enum ClientPlatformType{
        /**
         * iOS
         */
        IOS("1"),
        /**
         * Android
         */
        Android("2"),
        /**
         * 其他
         */
        Others("3")
        ;
        private String value;

        ClientPlatformType(String value) {
            this.value = value;
        }
        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return getValue();
        }
    }
}
