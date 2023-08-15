package org.kangspace.wechat.helper.work.message.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;

/**
 * 群机器人-markdown消息<br>
 * 目前仅支持markdown语法的子集<br>
 * 微工作台（原企业号）不支持展示markdown消息<br>
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
public class MarkDownMessage extends WebHookMessage {
    /**
     * markdown消息
     */
    @Nonnull
    @JsonProperty("markdown")
    private MarkDown markDown;

    /**
     * 消息类型，此时固定为：markdown
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.MARK_DOWN.getType();

    @NoArgsConstructor
    @Builder
    @Data
    public static class MarkDown {
        /**
         * 消息内容，最长不超过2048个字节，超过将截断,必须是utf8编码
         */
        @Nonnull
        @JsonProperty("content")
        private String content;

        public MarkDown(@Nonnull String content) {
            this.content = content;
        }
    }


}
