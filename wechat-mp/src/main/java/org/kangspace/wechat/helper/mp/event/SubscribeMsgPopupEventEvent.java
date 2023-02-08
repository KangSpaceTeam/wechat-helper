package org.kangspace.wechat.helper.mp.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.ToString;
import org.kangspace.wechat.helper.mp.constant.SubscriptionMessagesConstant;

/**
 * 用户操作订阅通知弹窗<br>
 * 场景：用户在图文等场景内订阅通知的操作<br>
 * 文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html</a><br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/08
 */
@Data
@ToString(callSuper = true)
public class SubscribeMsgPopupEventEvent extends WeChatMpXmlEvent {

    /**
     * 用户操作订阅通知弹窗
     */
    @JacksonXmlElementWrapper(localName = "SubscribeMsgPopupEvent")
    @JacksonXmlProperty(localName = "List")
    private SubscribeMsgPopupEvent subscribeMsgPopupEvent;

    /**
     * 事件内容
     */
    @Data
    public static class SubscribeMsgPopupEvent {
        /**
         * 模板 id（一次订阅可能有多条通知，带有多个 id）
         */
        @JacksonXmlProperty(localName = "TemplateId")
        @JacksonXmlCData
        private String templateId;

        /**
         * 用户点击行为（同意、取消发送通知）<br>
         * SubscribeStatusString 的合法值: <br>
         * accept	用户点击“同意”
         * reject	用户点击“取消”
         */
        @JacksonXmlProperty(localName = "SubscribeStatusString")
        @JacksonXmlCData
        private SubscriptionMessagesConstant.SubscribeStatusString subscribeStatusString;

        /**
         * 场景
         * PopupScene 的合法值<br>
         * 1	弹窗来自 H5 页面<br>
         * 2	弹窗来自图文消息<br>
         */
        @JacksonXmlProperty(localName = "PopupScene")
        private SubscriptionMessagesConstant.PopupScene popupScene;
    }

}
