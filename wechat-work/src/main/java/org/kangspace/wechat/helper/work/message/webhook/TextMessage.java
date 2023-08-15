package org.kangspace.wechat.helper.work.message.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 群机器人-文本消息
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/15
 */
@Data
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TextMessage extends WebHookMessage {
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

        /**
         * userid的列表，提醒群中的指定成员(@某个成员)，@all表示提醒所有人，如果开发者获取不到userid，可以使用mentioned_mobile_list
         */
        @JsonProperty("mentioned_list")
        private List<String> mentionedList;
        /**
         * 手机号列表，提醒手机号对应的群成员(@某个成员)，@all表示提醒所有人
         */
        @JsonProperty("mentioned_mobile_list")
        private List<String> mentionedMobileList;

        public Text(@Nonnull String content) {
            this.content = content;
        }

        public Text(@Nonnull String content, List<String> mentionedList, List<String> mentionedMobileList) {
            this.content = content;
            this.mentionedList = mentionedList;
            this.mentionedMobileList = mentionedMobileList;
        }
    }


}
