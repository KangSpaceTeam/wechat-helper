package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;

/**
 * 发送的图片信息
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/13
 */

@Data
public class SendPicsInfo {
    /**
     * 发送的图片数量
     */
    @JacksonXmlProperty(localName = "count")
    private Integer count;
    /**
     * 图片列表
     */
    @JacksonXmlElementWrapper(localName = "PicList")
    @JacksonXmlProperty(localName = "item")
    private List<Item> picList;

    @Data
    public static class Item {
        /**
         * 图片的MD5值，开发者若需要，可用于验证接收到图片
         */
        @JacksonXmlProperty(localName = "PicMd5Sum")
        @JacksonXmlCData
        private String picMd5Sum;
    }
}



