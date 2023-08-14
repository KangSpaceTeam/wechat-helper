package org.kangspace.wechat.helper.work.bean.appchat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nullable;

/**
 * 视频消息
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/14
 */
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class VideoMessage extends AppChatMessage {
    /**
     * 消息类型，此时固定为：video
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.VIDEO.getType();

    /**
     * 消息
     */
    @JsonProperty("video")
    private Video video;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Video {
        /**
         * 文件id，可以调用上传临时素材接口获取
         */
        @Nullable
        @JsonProperty("media_id")
        private String mediaId;

        /**
         * 视频消息的标题，不超过128个字节，超过会自动截断
         */
        @JsonProperty("title")
        private String title;
        /**
         * 视频消息的描述，不超过512个字节，超过会自动截断
         */
        @JsonProperty("description")
        private String description;
    }
}
