package org.kangspace.wechat.helper.work.message.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;
import org.kangspace.wechat.helper.work.message.push.WeComPushMessage;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 群机器人-图文消息
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
public class NewsMessage extends WeComPushMessage {
    /**
     * 图文消息
     */
    @Nonnull
    @JsonProperty("news")
    private News news;

    /**
     * 消息类型，此时固定为：news
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.NEWS.getType();

    @NoArgsConstructor
    @Builder
    @Data
    public static class News {
        /**
         * 图文消息，一个图文消息支持1到8条图文
         */
        @Nonnull
        @JsonProperty("articles")
        private List<Article> articles;

        public News(@Nonnull List<Article> articles) {
            this.articles = articles;
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Article {
        /**
         * 标题，不超过128个字节，超过会自动截断（支持id转译）
         */
        @Nonnull
        @JsonProperty("title")
        private String title;
        /**
         * 描述，不超过512个字节，超过会自动截断（支持id转译）
         */
        @JsonProperty("description")
        private String description;
        /**
         * 点击后跳转的链接。 最长2048字节，请确保包含了协议头(http/https)，小程序或者url必须填写一个
         */
        @JsonProperty("url")
        private String url;
        /**
         * 图文消息的图片链接，最长2048字节，支持JPG、PNG格式，较好的效果为大图 1068*455，小图150*150。
         */
        @JsonProperty("picurl")
        private String picUrl;

        public Article(@Nonnull String title) {
            this.title = title;
        }
    }

}
