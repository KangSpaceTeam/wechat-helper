package org.kangspace.wechat.helper.work.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 视频消息<br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90239">https://developer.work.weixin.qq.com/document/path/90239</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/08/10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class VideoMessage extends WeComXmlMessage {

    /**
     * 视频消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    @JacksonXmlProperty(localName = "MediaId")
    @JacksonXmlCData
    private String mediaId;

    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @JacksonXmlProperty(localName = "ThumbMediaId")
    @JacksonXmlCData
    private String thumbMediaId;
}
