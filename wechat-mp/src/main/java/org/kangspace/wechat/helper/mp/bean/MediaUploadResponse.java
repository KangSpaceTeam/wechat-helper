package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.mp.constant.MediaConstant;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

/**
 * 微信公众号素材管理:新增临时素材 响应参数<br>
 * 如:
 * <pre>
 * {"type":"TYPE","media_id":"MEDIA_ID","created_at":123456789}
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#MEDIA_UPLOAD
 * @since 2022/12/12
 */
@Setter
@Getter
public class MediaUploadResponse extends WeChatMpResponseEntity {
    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
     */
    @JsonProperty("type")
    private MediaConstant.MediaType type;

    /**
     * 媒体文件上传后，获取标识
     */
    @JsonProperty("mediaId")
    private String mediaId;

    /**
     * 媒体文件上传时间戳
     */
    @JsonProperty("created_at")
    private String createdAt;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "MediaUploadResponse{" +
                        "type=" + type +
                        ", mediaId='" + mediaId + '\'' +
                        ", createdAt='" + createdAt + '\'' +
                        "}"
        );
    }
}
