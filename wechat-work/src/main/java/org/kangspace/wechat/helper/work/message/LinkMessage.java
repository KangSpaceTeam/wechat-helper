package org.kangspace.wechat.helper.work.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 链接消息<br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90239">https://developer.work.weixin.qq.com/document/path/90239</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/08/10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LinkMessage extends WeComXmlMessage {

    /**
     * 消息标题
     */
    @JacksonXmlProperty(localName = "Title")
    @JacksonXmlCData
    private String title;

    /**
     * 消息描述
     */
    @JacksonXmlProperty(localName = "Description")
    @JacksonXmlCData
    private String description;

    /**
     * 消息链接
     */
    @JacksonXmlProperty(localName = "Url")
    @JacksonXmlCData
    private String url;

    /**
     * 封面缩略图的url
     */
    @JacksonXmlProperty(localName = "PicUrl")
    @JacksonXmlCData
    private String picUrl;
}
