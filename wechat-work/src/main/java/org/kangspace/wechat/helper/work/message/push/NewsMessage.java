package org.kangspace.wechat.helper.work.message.push;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 消息推送-发送应用消息-图文消息
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
        @Nonnull
        @JsonProperty("articles")
        private List<Article> articles;

        public News(@Nonnull List<Article> articles) {
            this.articles = articles;
        }
    }

    @NoArgsConstructor
    @Builder
    @Data
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
        /**
         * 小程序appid，必须是与当前应用关联的小程序，appid和pagepath必须同时填写，填写后会忽略url字段
         */
        @JsonProperty("appid")
        private String appId;
        /**
         * 点击消息卡片后的小程序页面，最长128字节，仅限本小程序内的页面。appid和pagepath必须同时填写，填写后会忽略url字段
         */
        @JsonProperty("pagepath")
        private String pagePath;

        public Article(@Nonnull String title) {
            this.title = title;
        }

        public Article(@Nonnull String title, String description, String url, String picUrl, String appId, String pagePath) {
            this.title = title;
            this.description = description;
            this.url = url;
            this.picUrl = picUrl;
            this.appId = appId;
            this.pagePath = pagePath;
        }
    }

}
