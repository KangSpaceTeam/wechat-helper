package org.kangspace.wechat.helper.work.message.push;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;

/**
 * 消息推送-发送应用消息-文本卡片消息<br>
 * 卡片消息的展现形式非常灵活，支持使用br标签或者空格来进行换行处理，也支持使用div标签来使用不同的字体颜色，目前内置了3种文字颜色：灰色(gray)、高亮(highlight)、默认黑色(normal)，将其作为div标签的class属性即可，具体用法请参考上面的示例。<br>
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
public class TextCardMessage extends WeComPushMessage {
    /**
     * 文本卡片消息
     */
    @Nonnull
    @JsonProperty("textcard")
    private TextCard textCard;

    /**
     * 消息类型，此时固定为：textcard
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.TEXT_CARD.getType();

    @NoArgsConstructor
    @Builder
    @Data
    public static class TextCard {

        /**
         * 标题，不超过128个字节，超过会自动截断（支持id转译）
         */
        @Nonnull
        @JsonProperty("title")
        private String title;

        /**
         * 描述，不超过512个字节，超过会自动截断（支持id转译）
         */
        @Nonnull
        @JsonProperty("description")
        private String description;

        /**
         * 点击后跳转的链接。最长2048字节，请确保包含了协议头(http/https)
         */
        @Nonnull
        @JsonProperty("url")
        private String url;

        /**
         * 按钮文字。 默认为“详情”， 不超过4个文字，超过自动截断。
         */
        @JsonProperty("btntxt")
        private String btnTxt;

        public TextCard(@Nonnull String title, @Nonnull String description, @Nonnull String url) {
            this.title = title;
            this.description = description;
            this.url = url;
        }

        public TextCard(@Nonnull String title, @Nonnull String description, @Nonnull String url, String btnTxt) {
            this.title = title;
            this.description = description;
            this.url = url;
            this.btnTxt = btnTxt;
        }
    }
}
