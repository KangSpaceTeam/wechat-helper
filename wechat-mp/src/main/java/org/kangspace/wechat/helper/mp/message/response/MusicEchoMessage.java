package org.kangspace.wechat.helper.mp.message.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.kangspace.wechat.helper.mp.constant.MessageConstant;

/**
 * 回复音乐消息 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Passive_user_reply_message.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Passive_user_reply_message.html</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/1
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
public class MusicEchoMessage extends WeChatMpEchoXmlMessage {

    /**
     * 音乐消息
     */
    @JacksonXmlProperty(localName = "Music")
    @JacksonXmlCData
    private Music music;

    public MusicEchoMessage() {
    }

    public MusicEchoMessage(String toUser, String fromUser, Long createTime, Long msgId, Music music) {
        super(toUser, fromUser, createTime, msgId);
        this.music = music;
    }

    @Override
    public MessageConstant.MessageType getMsgType() {
        return MessageConstant.MessageType.MUSIC;
    }

    /**
     * 音乐消息
     */
    @Data
    public static class Music {

        /**
         * 音乐标题
         * 必填: 否
         */
        @JacksonXmlProperty(localName = "Title")
        @JacksonXmlCData
        private String title;

        /**
         * 音乐描述
         * 必填: 否
         */
        @JacksonXmlProperty(localName = "Description")
        @JacksonXmlCData
        private String description;

        /**
         * 音乐链接
         * 必填: 否
         */
        @JacksonXmlProperty(localName = "MusicURL")
        @JacksonXmlCData
        private String musicUrl;

        /**
         * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
         * 必填: 否
         */
        @JacksonXmlProperty(localName = "HQMusicUrl")
        @JacksonXmlCData
        private String hqMusicUrl;

        /**
         * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
         * 必填: 是
         */
        @JacksonXmlProperty(localName = "ThumbMediaId")
        @JacksonXmlCData
        private String thumbMediaId;

        public Music(String title, String description, String musicUrl, String hqMusicUrl, String thumbMediaId) {
            this.title = title;
            this.description = description;
            this.musicUrl = musicUrl;
            this.hqMusicUrl = hqMusicUrl;
            this.thumbMediaId = thumbMediaId;
        }
    }
}
