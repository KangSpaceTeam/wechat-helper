package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kangspace.wechat.helper.mp.constant.MessageConstant;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

/**
 * 公众号一次性订阅消息: 发送订阅消息 请求参数 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/One-time_subscription_info.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/One-time_subscription_info.html</a>
 * 如:
 * <pre>
 *  {
 *     "touser":"OPENID",
 *     "template_id":"TEMPLATE_ID",
 *     "url":"URL",
 *     "miniprogram":{
 *          "appid":"xiaochengxuappid12345",
 *          "pagepath":"index?foo=bar"
 *      },
 *     "scene":"SCENE",
 *     "title":"TITLE",
 *     "data":{
 *          "content":{
 *          "value":"VALUE",
 *          "color":"COLOR"
 *      }
 *      }
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#MESSAGE_TEMPLATE_SUBSCRIBE
 * @since 2023/01/16
 */
@Data
public class MessageTemplateSubscribeRequest {
    /**
     * 接收者openid
     * 必填: 是
     */
    @JsonProperty("touser")
    private String toUser;
    /**
     * 模板ID
     * 必填: 是
     */
    @JsonProperty("template_id")
    private String templateId;

    /**
     * 点击消息跳转的链接，需要有 ICP 备案
     * 必填: 否
     */
    @JsonProperty("url")
    private String url;

    /**
     * 跳小程序所需数据，不需跳小程序可不用传该数据
     * 必填: 否 <br>
     */
    @JsonProperty("miniProgram")
    private MiniProgram miniProgram;

    /**
     * 订阅场景值
     * 必填: 否 <br>
     */
    @JsonProperty("scene")
    private String scene;

    /**
     * 消息标题，15字以内
     * 必填: 否 <br>
     */
    @JsonProperty("title")
    private String title;

    /**
     * 消息正文，value为消息内容文本（200字以内），没有固定格式，可用\n换行，color为整段消息内容的字体颜色（目前仅支持整段消息为一种颜色）
     * 必填: 否 <br>
     */
    @JsonProperty("data")
    private TemplateData data;

    public MessageTemplateSubscribeRequest() {
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
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TemplateData {
        @JsonProperty("content")
        private TemplateDataContent content;
    }

    /**
     * 模版内容 <br>
     * value为消息内容文本（200字以内），没有固定格式，可用\n换行，color为整段消息内容的字体颜色（目前仅支持整段消息为一种颜色）
     *
     * @see org.kangspace.wechat.helper.mp.constant.MessageConstant.Color
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TemplateDataContent {

        @JsonProperty("value")
        private String value;

        @JsonProperty("color")
        private MessageConstant.Color color = MessageConstant.Color.DEFAULT;

        public TemplateDataContent(String value) {
            this.value = value;
        }
    }
}
