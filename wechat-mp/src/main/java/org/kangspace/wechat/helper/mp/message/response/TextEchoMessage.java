package org.kangspace.wechat.helper.mp.message.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.kangspace.wechat.helper.mp.constant.MessageConstant;

/**
 * 回复文本消息 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Passive_user_reply_message.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Passive_user_reply_message.html</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/1
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TextEchoMessage extends WeChatMpEchoXmlMessage {

    /**
     * 回复的消息内容（换行：在 content 中能够换行，微信客户端就支持换行显示）
     */
    @JacksonXmlProperty(localName = "Content")
    @JacksonXmlCData
    private String content;

    public TextEchoMessage() {
    }


    public TextEchoMessage(String toUser, String fromUser, String content) {
        this(toUser, fromUser, null, null, content);
        this.setCreateTime(fetchDefaultCreateTime());
    }

    public TextEchoMessage(String toUser, String fromUser, Long createTime, Long msgId, String content) {
        super(toUser, fromUser, createTime, msgId);
        this.content = content;
    }

    @Override
    public MessageConstant.MessageType getMsgType() {
        return MessageConstant.MessageType.TEXT;
    }
}
