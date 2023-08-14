package org.kangspace.wechat.helper.work.bean.appchat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;

/**
 * 文本卡片消息
 * <p>
 * 卡片消息的展现形式非常灵活，支持使用br标签或者空格来进行换行处理，也支持使用div标签来使用不同的字体颜色，目前内置了3种文字颜色：灰色(gray)、高亮(highlight)、默认黑色(normal)，将其作为div标签的class属性即可，具体用法请参考上面的示例。
 * </p>
 * @author kango2gler@gmail.com
 * @since 2023/8/14
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TextCardMessage extends AppChatMessage {
    /**
     * 消息类型，此时固定为：textcard
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.TEXT_CARD.getType();

    /**
     * 消息
     */
    @JsonProperty("textcard")
    private TextCard textcard;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TextCard {
        /**
         * 标题，不超过128个字节，超过会自动截断
         */
        @Nonnull
        @JsonProperty("title")
        private String title;
        /**
         * 描述，不超过512个字节，超过会自动截断
         */
        @Nonnull
        @JsonProperty("description")
        private String description;
        /**
         * 点击后跳转的链接。
         */
        @Nonnull
        @JsonProperty("url")
        private String url;
        /**
         * 按钮文字。 默认为“详情”， 不超过4个文字，超过自动截断。
         */
        @JsonProperty("btntxt")
        private String btnTxt;
    }
}
