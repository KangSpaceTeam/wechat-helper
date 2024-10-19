package org.kangspace.wechat.helper.mp.message.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;
import org.kangspace.wechat.helper.mp.constant.MessageConstant;

/**
 * 回复视频消息 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Passive_user_reply_message.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Passive_user_reply_message.html</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/1
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class VideoEchoMessage extends WeChatMpEchoXmlMessage {

    /**
     * 视频消息
     */
    @JacksonXmlProperty(localName = "Video")
    @JacksonXmlCData
    private Video video;

    public VideoEchoMessage() {
    }

    public VideoEchoMessage(String toUser, String fromUser, Video video) {
        this(toUser, fromUser, null, null, video);
        this.setCreateTime(fetchDefaultCreateTime());
    }

    public VideoEchoMessage(String toUser, String fromUser, Long createTime, Long msgId, Video video) {
        super(toUser, fromUser, createTime, msgId);
        this.video = video;
    }

    @Override
    public MessageConstant.MessageType getMsgType() {
        return MessageConstant.MessageType.VIDEO;
    }

    /**
     * 视频消息
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Video {
        /**
         * 通过素材管理中的接口上传多媒体文件，得到的id。
         */
        @JacksonXmlProperty(localName = "MediaId")
        @JacksonXmlCData
        private String mediaId;


        /**
         * 视频消息的标题
         */
        @JacksonXmlProperty(localName = "Title")
        @JacksonXmlCData
        private String title;

        /**
         * 视频消息的描述
         */
        @JacksonXmlProperty(localName = "Description")
        @JacksonXmlCData
        private String description;
    }
}
