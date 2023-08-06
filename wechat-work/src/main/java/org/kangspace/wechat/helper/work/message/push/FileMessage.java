package org.kangspace.wechat.helper.work.message.push;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;

/**
 * 消息推送-发送应用消息-文件消息
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
public class FileMessage extends WeComPushMessage {
    /**
     * 文件消息
     */
    @Nonnull
    @JsonProperty("file")
    private File file;

    /**
     * 消息类型，此时固定为：file
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.FILE.getType();

    @NoArgsConstructor
    @Builder
    @Data
    public static class File {
        /**
         * 文件id，可以调用上传临时素材接口获取
         */
        @Nonnull
        @JsonProperty("media_id")
        private String mediaId;

        public File(@Nonnull String mediaId) {
            this.mediaId = mediaId;
        }
    }
}
