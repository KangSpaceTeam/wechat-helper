package org.kangspace.wechat.helper.work.message.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;

/**
 * 群机器人-语音消息
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/2
 */
@Data
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class VoiceMessage extends WebHookMessage {
    /**
     * 语音消息
     */
    @Nonnull
    @JsonProperty("voice")
    private Voice voice;

    /**
     * 消息类型，此时固定为：voice
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.VOICE.getType();

    @Data
    @Builder
    @NoArgsConstructor
    public static class Voice {
        /**
         * 语音文件id，可以调用上传临时素材接口获取
         */
        @Nonnull
        @JsonProperty("media_id")
        private String mediaId;

        public Voice(@Nonnull String mediaId) {
            this.mediaId = mediaId;
        }
    }


}
