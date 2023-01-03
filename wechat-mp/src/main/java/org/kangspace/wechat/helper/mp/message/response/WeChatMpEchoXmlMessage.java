package org.kangspace.wechat.helper.mp.message.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.ToString;
import org.kangspace.wechat.helper.core.message.response.WeChatEchoXmlMessage;
import org.kangspace.wechat.helper.mp.constant.MessageConstant;
import org.kangspace.wechat.helper.mp.message.WeChatMpXmlMessage;

/**
 * 微信公众号响应XML消息
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/29
 */
@Data
@ToString(callSuper = true)
@JacksonXmlRootElement(localName = "xml")
public class WeChatMpEchoXmlMessage extends WeChatMpXmlMessage implements WeChatMpEchoMessage, WeChatEchoXmlMessage {

    public WeChatMpEchoXmlMessage() {
    }

    public WeChatMpEchoXmlMessage(String toUser, String fromUser, Long createTime, Long msgId) {
        super(toUser, fromUser, createTime, msgId);
    }

    public WeChatMpEchoXmlMessage(MessageConstant.MessageType msgType, String event, String toUser, String fromUser, Long createTime, Long msgId) {
        super(msgType, event, toUser, fromUser, createTime, msgId);
    }
}
