package org.kangspace.wechat.helper.work.bean.appchat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

/**
 * markdown消息
 * <p>
 * 目前仅支持markdown语法的子集
 * 微信插件（原企业号）不支持展示markdown消息
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/14
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MarkdownMessage extends AppChatMessage {
    /**
     * 消息类型，此时固定为：markdown
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.MARK_DOWN.getType();

    /**
     * 消息
     */
    @JsonProperty("markdown")
    private Markdown markdown;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Markdown {
        /**
         * markdown内容，最长不超过2048个字节，必须是utf8编码
         */
        @JsonProperty("content")
        private String content;
    }
}
