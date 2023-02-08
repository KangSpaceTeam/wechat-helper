package org.kangspace.wechat.helper.mp.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.ToString;

/**
 * 发送订阅通知<br>
 * <p>
 * 场景：调用 bizsend 接口发送通知<br>
 * *失败仅包含因异步推送导致的系统失败<br>
 * 文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html</a><br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/08
 */
@Data
@ToString(callSuper = true)
public class SubscribeMsgSentEventEvent extends WeChatMpXmlEvent {

    /**
     * 发送订阅通知
     */
    @JacksonXmlElementWrapper(localName = "SubscribeMsgSentEvent")
    @JacksonXmlProperty(localName = "List")
    private SubscribeMsgSentEvent subscribeMsgPopupEvent;

    /**
     * 事件内容
     */
    @Data
    public static class SubscribeMsgSentEvent {
        /**
         * 模板 id（一次订阅可能有多条通知，带有多个 id）
         */
        @JacksonXmlProperty(localName = "TemplateId")
        @JacksonXmlCData
        private String templateId;

        /**
         * 消息 id
         */
        @JacksonXmlProperty(localName = "MsgID")
        private Long msgId;

        /**
         * 推送结果状态码（0表示成功）
         */
        @JacksonXmlProperty(localName = "ErrorCode")
        @JacksonXmlCData
        private Integer errorCode;

        /**
         * 推送结果状态码文字含义
         */
        @JacksonXmlProperty(localName = "ErrorStatus")
        @JacksonXmlCData
        private String errorStatus;
    }

}
