package org.kangspace.wechat.helper.work.message.push;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;

/**
 * 消息推送-发送应用消息-文本消息
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
public class TextMessage extends WeComPushMessage {
    /**
     * 文本消息
     */
    @Nonnull
    @JsonProperty("text")
    private Text text;

    /**
     * 消息类型，此时固定为：text
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.TEXT.getType();

    @NoArgsConstructor
    @Builder
    @Data
    public static class Text {
        /**
         * 消息内容，最长不超过2048个字节，超过将截断（支持id转译）
         */
        @Nonnull
        @JsonProperty("content")
        private String content;

        public Text(@Nonnull String content) {
            this.content = content;
        }
    }


}
