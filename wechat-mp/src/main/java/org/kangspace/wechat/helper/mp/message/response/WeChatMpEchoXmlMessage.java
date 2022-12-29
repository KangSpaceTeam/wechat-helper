package org.kangspace.wechat.helper.mp.message.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import org.kangspace.wechat.helper.core.message.response.WeChatEchoXmlMessage;

/**
 * 微信公众号响应XML消息
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/29
 */
@Data
@JacksonXmlRootElement(localName = "xml")
public class WeChatMpEchoXmlMessage implements WeChatMpEchoMessage, WeChatEchoXmlMessage {

}
