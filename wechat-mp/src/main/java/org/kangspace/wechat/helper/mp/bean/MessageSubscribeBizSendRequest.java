package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import javax.annotation.Nonnull;
import java.util.HashMap;

/**
 * send发送订阅通知 请求参数 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html#send%E5%8F%91%E9%80%81%E8%AE%A2%E9%98%85%E9%80%9A%E7%9F%A5">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html#send%E5%8F%91%E9%80%81%E8%AE%A2%E9%98%85%E9%80%9A%E7%9F%A5</a>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#MESSAGE_SUBSCRIBE_BIZ_SEND
 * @since 2023/02/11 16:25:48
 */
@Getter
@Setter
@ToString
public class MessageSubscribeBizSendRequest {
    /**
     * 接收者openid
     * 必填: 是
     */
    @Nonnull
    @JsonProperty("touser")
    private String toUser;

    /**
     * 模板ID
     * 必填: 是
     */
    @Nonnull
    @JsonProperty("template_id")
    private String templateId;

    /**
     * 跳转网页时填写
     * 必填: 否
     */
    @JsonProperty("page")
    private String page;

    /**
     * 跳转小程序时填写，格式如{ "appid": "pagepath": { "value": any } }
     * 必填: 否 <br>
     */
    @JsonProperty("miniprogram")
    private MiniProgram miniProgram;


    /**
     * 模板内容，格式形如 { "key1": { "value": any }, "key2": { "value": any } }
     * 必填: 是 <br>
     */
    @Nonnull
    @JsonProperty("data")
    private TemplateData data;

    public MessageSubscribeBizSendRequest() {
    }

    /**
     * 跳小程序所需数据
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MiniProgram {
        /**
         * 所需跳转到的小程序appid（该小程序 appid 必须与发模板消息的公众号是绑定关联关系，并且小程序要求是已发布的）
         * 必填: 是 <br>
         */
        @JsonProperty("appid")
        private String appId;

        /**
         * 所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar）
         * 必填: 是 <br>
         */
        @JsonProperty("pagepath")
        private String pagePath;
    }

    /**
     * 模版内容数据
     */
    @ToString
    @AllArgsConstructor
    public static class TemplateData extends HashMap<String, TemplateDataValue> {
    }

    /**
     * 模版内容Value值
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class TemplateDataValue extends HashMap<String, String> {
        @JsonProperty("value")
        private String value;
    }
}
