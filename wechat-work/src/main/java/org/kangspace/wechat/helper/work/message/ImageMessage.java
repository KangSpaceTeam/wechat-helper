package org.kangspace.wechat.helper.work.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 图片消息<br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90239">https://developer.work.weixin.qq.com/document/path/90239</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/08/10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ImageMessage extends WeComXmlMessage {

    /**
     * 图片链接
     */
    @JacksonXmlProperty(localName = "PicUrl")
    @JacksonXmlCData
    private String picUrl;

    /**
     * 图片消息媒体id，图片媒体文件id，可以调用获取媒体文件接口拉取，仅三天内有效。
     */
    @JacksonXmlProperty(localName = "MediaId")
    @JacksonXmlCData
    private String mediaId;

}
