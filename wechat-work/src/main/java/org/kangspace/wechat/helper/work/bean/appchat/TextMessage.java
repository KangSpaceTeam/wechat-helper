package org.kangspace.wechat.helper.work.bean.appchat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

/**
 * 文本消息
 * @author kango2gler@gmail.com
 * @since 2023/8/14
 */
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TextMessage extends AppChatMessage{
    /**
     * 消息类型，此时固定为：text
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.TEXT.getType();

    /**
     * 消息
     */
    @JsonProperty("text")
    private Text text;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Text{
        /**
         * 消息内容，最长不超过2048个字节
         */
        @JsonProperty("content")
        private String content;
    }
}
