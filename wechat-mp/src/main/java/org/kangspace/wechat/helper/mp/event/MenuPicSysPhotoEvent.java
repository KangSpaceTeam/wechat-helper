package org.kangspace.wechat.helper.mp.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * pic_sysphoto：弹出系统拍照发图的事件 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Custom_Menu_Push_Events.html">https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Custom_Menu_Push_Events.html</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/31
 */
@Data
@ToString(callSuper = true)
public class MenuPicSysPhotoEvent extends WeChatMpXmlEvent {
    /**
     * 发送的图片信息
     */
    @JacksonXmlProperty(localName = "SendPicsInfo")
    @JacksonXmlCData
    private SendPicsInfo sendPicsInfo;

    /**
     * 发送的图片信息
     */
    @Data
    public static class SendPicsInfo {
        /**
         * 发送的图片数量
         */
        @JacksonXmlProperty(localName = "Count")
        private Integer count;
        /**
         * 图片列表
         */
        @JacksonXmlElementWrapper(localName = "PicList")
        @JacksonXmlProperty(localName = "item")
        @JacksonXmlCData
        private List<PicItem> picList;
    }

    /**
     * 图片列表
     */
    @Data
    public static class PicItem {
        /**
         * 图片的MD5值，开发者若需要，可用于验证接收到图片
         */
        @JacksonXmlProperty(localName = "PicMd5Sum")
        @JacksonXmlCData
        private String picMd5Sum;
    }
}
