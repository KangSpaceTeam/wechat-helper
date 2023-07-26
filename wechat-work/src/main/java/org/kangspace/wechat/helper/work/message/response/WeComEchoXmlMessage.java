package org.kangspace.wechat.helper.work.message.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.ToString;
import org.kangspace.wechat.helper.core.message.WeChatMessage;
import org.kangspace.wechat.helper.core.message.response.WeChatEchoXmlMessage;
import org.kangspace.wechat.helper.work.message.MessageConstant;
import org.kangspace.wechat.helper.work.message.WeComXmlMessage;

/**
 * 企业微信响应XML消息
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/25
 */
@Data
@ToString(callSuper = true)
@JacksonXmlRootElement(localName = "xml")
public class WeComEchoXmlMessage extends WeComXmlMessage implements WeComEchoMessage, WeChatEchoXmlMessage, WeChatMessage {

    public WeComEchoXmlMessage() {
    }

    public WeComEchoXmlMessage(String toUser, String fromUser, Long createTime, Long msgId) {
        super(toUser, fromUser, createTime, msgId);
    }

    public WeComEchoXmlMessage(MessageConstant.MessageType msgType, String event, String toUser, String fromUser, Long createTime, Long msgId) {
        super(msgType, event, toUser, fromUser, createTime, msgId);
    }

    public WeComEchoXmlMessage(MessageConstant.MessageType msgType, String event, String toUser, String fromUser, Long createTime, Long msgId, String raw) {
        super(msgType, event, toUser, fromUser, createTime, msgId, raw);
    }
}
