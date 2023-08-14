package org.kangspace.wechat.helper.work.bean.appchat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 图文消息（mpnews）
 * <p>
 * mpnews类型的图文消息，跟普通的图文消息一致，唯一的差异是图文内容存储在企业微信。 <br/>
 * 多次发送mpnews，会被认为是不同的图文，阅读、点赞的统计会被分开计算。<br/>
 * </p>
 * @author kango2gler@gmail.com
 * @since 2023/8/14
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MpNewsMessage extends AppChatMessage{
    /**
     * 消息类型，此时固定为：mp_news
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.MP_NEWS.getType();

    /**
     * 消息
     */
    @JsonProperty("mp_news")
    private MpNews mpNews;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MpNews {
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
         * 图文消息缩略图的media_id, 可以通过素材管理接口获得。此处thumb_media_id即上传接口返回的media_id
         */
        @Nonnull
        @JsonProperty("thumb_media_id")
        private String thumbMediaId;
        /**
         * 图文消息的作者，不超过64个字节
         */
        @JsonProperty("author")
        private String author;
        /**
         * 图文消息点击“阅读原文”之后的页面链接
         */
        @JsonProperty("content_source_url")
        private String contentSourceUrl;
        /**
         * 图文消息的内容，支持html标签，不超过666 K个字节
         */
        @Nonnull
        @JsonProperty("content")
        private String content;
        /**
         * 图文消息的描述，不超过512个字节，超过会自动截断
         */
        @JsonProperty("digest")
        private String digest;
    }
}
