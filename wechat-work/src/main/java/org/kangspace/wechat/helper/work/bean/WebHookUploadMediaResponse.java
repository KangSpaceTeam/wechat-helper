package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 群机器人-文件上传接口 响应对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/15
 */
@Setter
@Getter
public class WebHookUploadMediaResponse extends WeComResponseEntity {

    /**
     * 文件类型，分别有语音(voice)和普通文件(file)
     */
    @JsonProperty("type")
    private String type;
    /**
     * 媒体文件上传后获取的唯一标识，3天内有效
     */
    @JsonProperty("media_id")
    private String mediaId;
    /**
     * 媒体文件上传时间戳
     */
    @JsonProperty("created_at")
    private Long createdAt;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "WebHookUploadMediaResponse{" +
                        "type='" + type + '\'' +
                        ", mediaId='" + mediaId + '\'' +
                        ", createdAt=" + createdAt +
                        "}"
        );
    }
}
