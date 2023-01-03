package org.kangspace.wechat.helper.mp.message.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.ToString;
import org.kangspace.wechat.helper.mp.constant.MessageConstant;

import java.util.List;

/**
 * 回复图文消息 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Passive_user_reply_message.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Passive_user_reply_message.html</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/1
 */
@Data
@ToString(callSuper = true)
public class NewsEchoMessage extends WeChatMpEchoXmlMessage {

    /**
     * 图文消息个数；当用户发送文本、图片、语音、视频、图文、地理位置这六种消息时，开发者只能回复1条图文消息；其余场景最多可回复8条图文消息
     */
    @JacksonXmlProperty(localName = "ArticleCount")
    @JacksonXmlCData
    private Integer articleCount;

    /**
     * 图文消息信息，注意，如果图文数超过限制，则将只发限制内的条数
     */
    @JacksonXmlElementWrapper(localName = "Articles")
    @JacksonXmlProperty(localName = "item")
    private List<Article> articles;

    public NewsEchoMessage() {
    }

    public NewsEchoMessage(String toUser, String fromUser, Long createTime, Long msgId, Integer articleCount, List<Article> articles) {
        super(toUser, fromUser, createTime, msgId);
        this.articleCount = articleCount;
        this.articles = articles;
    }

    @Override
    public MessageConstant.MessageType getMsgType() {
        return MessageConstant.MessageType.NEWS;
    }

    /**
     * 图文消息信息，注意，如果图文数超过限制，则将只发限制内的条数
     */
    @Data
    private static class Article {
        /**
         * 图文消息标题
         */
        @JacksonXmlProperty(localName = "Title")
        @JacksonXmlCData
        private String title;

        /**
         * 图文消息描述
         */
        @JacksonXmlProperty(localName = "Description")
        @JacksonXmlCData
        private String description;

        /**
         * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
         */
        @JacksonXmlProperty(localName = "PicUrl")
        @JacksonXmlCData
        private String picUrl;

        /**
         * 点击图文消息跳转链接
         */
        @JacksonXmlProperty(localName = "Url")
        @JacksonXmlCData
        private String url;
    }
}
