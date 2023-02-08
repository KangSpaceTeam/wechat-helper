package org.kangspace.wechat.helper.mp.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.ToString;
import org.kangspace.wechat.helper.mp.constant.SubscriptionMessagesConstant;

/**
 * 用户管理订阅通知<br>
 * 场景：用户在服务通知管理页面做通知管理时的操作<br>
 * 文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html</a><br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/08
 */
@Data
@ToString(callSuper = true)
public class SubscribeMsgChangeEventEvent extends WeChatMpXmlEvent {

    /**
     * 用户管理订阅通知
     */
    @JacksonXmlElementWrapper(localName = "SubscribeMsgChangeEvent")
    @JacksonXmlProperty(localName = "List")
    private SubscribeMsgChangeEvent subscribeMsgChangeEvent;


    /**
     * 事件内容
     */
    @Data
    public static class SubscribeMsgChangeEvent {
        /**
         * 模板 id（一次订阅可能有多条通知，带有多个 id）
         */
        @JacksonXmlProperty(localName = "TemplateId")
        @JacksonXmlCData
        private String templateId;

        /**
         * 用户点击行为（仅推送用户拒收通知）<br>
         * SubscribeStatusString 的合法值: <br>
         * reject	用户点击“取消”
         */
        @JacksonXmlProperty(localName = "SubscribeStatusString")
        @JacksonXmlCData
        private SubscriptionMessagesConstant.SubscribeStatusString subscribeStatusString;
    }
}
