package org.kangspace.wechat.helper.mp.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

/**
 * location_select：弹出地理位置选择器的事件 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Custom_Menu_Push_Events.html">https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Custom_Menu_Push_Events.html</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/31
 */
@Data
public class MenuLocationSelectEvent extends WeChatMpXmlEvent {
    /**
     * 发送的位置信息
     */
    @JacksonXmlProperty(localName = "SendLocationInfo")
    @JacksonXmlCData
    private SendLocationInfo sendLocationInfo;

    /**
     * 发送的位置信息
     */
    @Data
    public static class SendLocationInfo{
        /**
         * 	X坐标信息
         */
        @JacksonXmlProperty(localName = "Location_X")
        @JacksonXmlCData
        private String locationX;
        /**
         * 	Y坐标信息
         */
        @JacksonXmlProperty(localName = "Location_Y")
        @JacksonXmlCData
        private String locationY;
        /**
         * 	精度，可理解为精度或者比例尺、越精细的话 scale越高
         */
        @JacksonXmlProperty(localName = "Scale")
        @JacksonXmlCData
        private String scale;
        /**
         * 	地理位置的字符串信息
         */
        @JacksonXmlProperty(localName = "Label")
        @JacksonXmlCData
        private String label;
        /**
         * 	朋友圈 POI 的名字，可能为空
         */
        @JacksonXmlProperty(localName = "Poiname")
        @JacksonXmlCData
        private String poiName;
    }
}
