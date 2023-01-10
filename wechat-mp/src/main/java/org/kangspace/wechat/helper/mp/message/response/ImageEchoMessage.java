package org.kangspace.wechat.helper.mp.message.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.kangspace.wechat.helper.mp.constant.MessageConstant;

/**
 * 回复图片消息 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Passive_user_reply_message.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Passive_user_reply_message.html</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/1
 */
@Data
@ToString(callSuper = true)
public class ImageEchoMessage extends WeChatMpEchoXmlMessage {

    /**
     * 图片消息
     */
    @JacksonXmlProperty(localName = "Image")
    @JacksonXmlCData
    private Image image;

    public ImageEchoMessage() {
    }

    public ImageEchoMessage(String toUser, String fromUser, Long createTime, Long msgId, Image image) {
        super(toUser, fromUser, createTime, msgId);
        this.image = image;
    }

    @Override
    public MessageConstant.MessageType getMsgType() {
        return MessageConstant.MessageType.IMAGE;
    }

    /**
     * 图片消息
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Image {
        /**
         * 通过素材管理中的接口上传多媒体文件，得到的id。
         */
        @JacksonXmlProperty(localName = "MediaId")
        @JacksonXmlCData
        private String mediaId;
    }
}
