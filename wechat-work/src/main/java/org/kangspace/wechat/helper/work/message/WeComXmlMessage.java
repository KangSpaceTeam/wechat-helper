package org.kangspace.wechat.helper.work.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import org.kangspace.wechat.helper.core.message.WeChatXmlMessage;

/**
 * 企业微信基础XML消息实体
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/25
 */
@Data
@JacksonXmlRootElement(localName = "xml")
public class WeComXmlMessage implements WeComMessage, WeChatXmlMessage {
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
     * 若为ChangeType event时,ChangeType类型
     */
    @JacksonXmlProperty(localName = "ChangeType")
    @JacksonXmlCData
    private String changeType;

    /**
     * 开发者微信号
     */
    @JacksonXmlProperty(localName = "ToUserName")
    @JacksonXmlCData
    private String toUser;

    /**
     * 接收的应用id，可在应用的设置页面获取
     */
    @JacksonXmlProperty(localName = "AgentID")
    @JacksonXmlCData
    private String agentId;

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
    @JsonIgnore
    private String raw;

    public WeComXmlMessage() {
    }

    public WeComXmlMessage(String toUser, String fromUser, Long createTime, Long msgId) {
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.createTime = createTime;
        this.msgId = msgId;
    }

    public WeComXmlMessage(MessageConstant.MessageType msgType, String event, String toUser, String fromUser, Long createTime, Long msgId) {
        this.msgType = msgType;
        this.event = event;
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.createTime = createTime;
        this.msgId = msgId;
    }

    public WeComXmlMessage(MessageConstant.MessageType msgType, String event, String toUser, String fromUser, Long createTime, Long msgId, String raw) {
        this.msgType = msgType;
        this.event = event;
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.createTime = createTime;
        this.msgId = msgId;
        this.raw = raw;
    }

    @Override
    public String getRaw() {
        return this.raw;
    }
}
