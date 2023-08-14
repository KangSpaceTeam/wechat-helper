package org.kangspace.wechat.helper.work.bean.appchat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

/**
 * 语音消息
 * @author kango2gler@gmail.com
 * @since 2023/8/14
 */
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class VoiceMessage extends AppChatMessage{
    /**
     * 消息类型，此时固定为：voice
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.VOICE.getType();

    /**
     * 消息
     */
    @JsonProperty("voice")
    private Voice voice;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Voice{
        /**
         * 文件id，可以调用上传临时素材接口获取
         */
        @JsonProperty("media_id")
        private String mediaId;
    }
}
