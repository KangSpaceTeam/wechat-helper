package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 菜单事件-弹出地理位置选择器的事件推送 <br>
 * 接口文档:
 * <a href="https://developer.work.weixin.qq.com/document/path/90240">https://developer.work.weixin.qq.com/document/path/90240</a> <br>
 * <p>
 * 成员点击自定义菜单后，企业微信会把点击事件推送给应用。<br>
 * 点击菜单弹出子菜单，不会产生上报。<br>
 * 企业微信iPhone1.2.2/Android1.2.2版本开始支持菜单事件，旧版本企业微信成员点击后将没有回应，应用不能正常接收到事件推送。<br>
 * 自定义菜单可以在管理后台的应用设置界面配置。<br>
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LocationSelectEvent extends WeComXmlEvent {
    public static final String EVENT = "location_select";

    /**
     * 发送的位置信息
     */
    @JacksonXmlProperty(localName = "SendLocationInfo")
    private SendLocationInfo sendLocationInfo;

    /**
     * app类型，在企业微信固定返回wxwork，在微信不返回该字段
     */
    @JacksonXmlProperty(localName = "AppType")
    @JacksonXmlCData
    private String appType;


    @Data
    public static class SendLocationInfo {
        /**
         * X坐标信息
         */
        @JacksonXmlProperty(localName = "Location_X")
        @JacksonXmlCData
        private String locationX;
        /**
         * Y坐标信息
         */
        @JacksonXmlProperty(localName = "Location_Y")
        @JacksonXmlCData
        private String locationY;
        /**
         * 精度，可理解为精度或者比例尺、越精细的话 scale越高
         */
        @JacksonXmlProperty(localName = "Scale")
        private Integer scale;
        /**
         * 地理位置的字符串信息
         */
        @JacksonXmlProperty(localName = "Label")
        @JacksonXmlCData
        private String label;
        /**
         * POI的名字，可能为空
         */
        @JacksonXmlProperty(localName = "Poiname")
        @JacksonXmlCData
        private String poiName;
    }
}
