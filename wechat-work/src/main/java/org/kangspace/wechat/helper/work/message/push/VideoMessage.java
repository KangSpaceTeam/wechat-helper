package org.kangspace.wechat.helper.work.message.push;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;

/**
 * 消息推送-发送应用消息-视频消息
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/2
 */
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class VideoMessage extends WeComPushMessage {
    /**
     * 视频消息
     */
    @JsonProperty("video")
    private Voice video;

    /**
     * 消息类型，此时固定为：video
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.VIDEO.getType();

    @NoArgsConstructor
    @Builder
    @Data
    public static class Voice {
        /**
         * 视频文件id，可以调用上传临时素材接口获取
         */
        @Nonnull
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

        public Voice(@Nonnull String mediaId) {
            this.mediaId = mediaId;
        }

        public Voice(@Nonnull String mediaId, String title, String description) {
            this.mediaId = mediaId;
            this.title = title;
            this.description = description;
        }
    }


}
