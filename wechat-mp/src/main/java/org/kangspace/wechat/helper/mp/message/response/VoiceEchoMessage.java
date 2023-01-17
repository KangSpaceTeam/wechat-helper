package org.kangspace.wechat.helper.mp.message.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.kangspace.wechat.helper.mp.constant.MessageConstant;

/**
 * 回复语音消息 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Passive_user_reply_message.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Passive_user_reply_message.html</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/1
 */
@Data
@ToString(callSuper = true)
public class VoiceEchoMessage extends WeChatMpEchoXmlMessage {

    /**
     * 语音消息
     */
    @JacksonXmlProperty(localName = "Voice")
    @JacksonXmlCData
    private Voice voice;

    public VoiceEchoMessage() {
    }

    public VoiceEchoMessage(String toUser, String fromUser, Long createTime, Long msgId, Voice voice) {
        super(toUser, fromUser, createTime, msgId);
        this.voice = voice;
    }

    @Override
    public MessageConstant.MessageType getMsgType() {
        return MessageConstant.MessageType.VOICE;
    }

    /**
     * 语音消息
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Voice {
        /**
         * 通过素材管理中的接口上传多媒体文件，得到的id。
         */
        @JacksonXmlProperty(localName = "MediaId")
        @JacksonXmlCData
        private String mediaId;
    }
}
