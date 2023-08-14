package org.kangspace.wechat.helper.work.bean.appchat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 文件消息
 * @author kango2gler@gmail.com
 * @since 2023/8/14
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NewsMessage extends AppChatMessage{
    /**
     * 消息类型，此时固定为：news
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.NEWS.getType();

    /**
     * 消息
     */
    @JsonProperty("news")
    private News news;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class News {
        /**
         * 图文消息，一个图文消息支持1到8条图文
         */
        @Nonnull
        @JsonProperty("articles")
        private List<Article> articles;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Article {
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
         * 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图1068*455，小图150*150。
         */
        @JsonProperty("picurl")
        private String picUrl;
    }
}
