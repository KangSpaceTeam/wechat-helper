package org.kangspace.wechat.helper.mp.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.ToString;

/**
 * scancode_push：扫码推事件的事件推送 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Custom_Menu_Push_Events.html">https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Custom_Menu_Push_Events.html</a> <br>
 * @author kango2gler@gmail.com
 * @since 2022/12/31
 */
@Data
@ToString(callSuper = true)
public class MenuScanCodePushEvent extends WeChatMpXmlEvent {

    /**
     * 扫描信息
     */
    @JacksonXmlProperty(localName = "ScanCodeInfo")
    @JacksonXmlCData
    private ScanCodeInfo scanCodeInfo;

    /**
     * 扫描信息
     */
    @Data
    public static class ScanCodeInfo {
        /**
         * 扫描类型，一般是qrcode
         */
        @JacksonXmlProperty(localName = "ScanType")
        @JacksonXmlCData
        private ScanType scanType;

        /**
         * 扫描结果，即二维码对应的字符串信息
         */
        @JacksonXmlProperty(localName = "ScanResult")
        @JacksonXmlCData
        private String scanResult;
    }
}
