package org.kangspace.wechat.helper.mp.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import org.kangspace.wechat.helper.core.message.WeChatXmlMessage;
import org.kangspace.wechat.helper.mp.constant.MessageConstant;

/**
 * 微信公众号基础XML消息实体
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/12
 */
@Data
@JacksonXmlRootElement(localName = "xml")
public class WeChatMpXmlMessage implements WeChatMpMessage, WeChatXmlMessage {
    /**
     * 消息类型
     */
    @JacksonXmlProperty(localName = "MsgType")
    @JacksonXmlCData
    private MessageConstant.MessageType msgType;

    /**
     * 若为event时,event类型
     */
    @JacksonXmlProperty(localName = "Event")
    @JacksonXmlCData
    private String event;

    /**
     * 开发者微信号
     */
    @JacksonXmlProperty(localName = "ToUserName")
    @JacksonXmlCData
    private String toUser;

    /**
     * 发送方帐号（一个OpenID）
     */
    @JacksonXmlProperty(localName = "FromUserName")
    @JacksonXmlCData
    private String fromUser;

    /**
     * 消息创建时间 （整型）
     */
    @JacksonXmlProperty(localName = "CreateTime")
    @JacksonXmlCData
    private Long createTime;

    /**
     * 消息id，64位整型
     */
    @JacksonXmlProperty(localName = "MsgId")
    @JacksonXmlCData
    private Long msgId;

    /**
     * 原始消息
     */
    private String raw;

    @Override
    public String getRaw() {
        return this.raw;
    }
}
