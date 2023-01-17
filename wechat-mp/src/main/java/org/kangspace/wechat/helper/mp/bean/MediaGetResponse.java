package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.mp.constant.MediaConstant;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import java.io.File;

/**
 * 微信公众号素材管理:获取临时素材 响应参数<br>
 * 如:
 * <pre>
 * {"type":"TYPE","media_id":"MEDIA_ID","created_at":123456789}
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#MEDIA_GET
 * @since 2022/12/12
 */
@Setter
@Getter
public class MediaGetResponse extends WeChatMpResponseEntity {
    /**
     * 视频消息素材
     */
    @JsonProperty(value = "video_url")
    private String videoUrl;

    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     */
    private MediaConstant.MediaType type;

    /**
     * 下载的文件内容
     */
    private File media;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "MediaGetResponse{" +
                        "videoUrl='" + videoUrl + '\'' +
                        ", type=" + type +
                        ", media=" + media +
                        "}"
        );
    }
}

