package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import javax.annotation.Nonnull;
import java.util.HashMap;

/**
 * 模板消息-发送模板消息 请求参数 <br>
 * 如:
 * <pre>
 *  {
 *            "touser":"OPENID",
 *            "template_id":"ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY",
 *            "url":"http://weixin.qq.com/download",
 *            "miniprogram":{
 *              "appid":"xiaochengxuappid12345",
 *              "pagepath":"index?foo=bar"
 *            },
 *            "client_msg_id":"MSG_000001",
 *            "data":{
 *                    "first": {
 *                        "value":"恭喜你购买成功！",
 *                        "color":"#173177"
 *                    },
 *                    "keyword1":{
 *                        "value":"巧克力",
 *                        "color":"#173177"
 *                    },
 *                    "keyword2": {
 *                        "value":"39.8元",
 *                        "color":"#173177"
 *                    },
 *                    "keyword3": {
 *                        "value":"2014年9月22日",
 *                        "color":"#173177"
 *                    },
 *                    "remark":{
 *                        "value":"欢迎再次购买！",
 *                        "color":"#173177"
 *                    }
 *            }
 *        }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#MESSAGE_TEMPLATE_SEND
 * @since 2022/12/11
 */
@Builder
@Data
public class MessageTemplateSendRequest {
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
     * 模板跳转链接（海外帐号没有跳转能力）<br>
     * 注：url和 miniprogram 都是非必填字段，若都不传则模板无跳转；若都传，会优先跳转至小程序。开发者可根据实际需要选择其中一种跳转方式即可。当用户的微信客户端版本不支持跳小程序时，将会跳转至url。<br>
     * 必填: 否
     */
    private String url;
    /**
     * 跳小程序所需数据，不需跳小程序可不用传该数据
     * 必填: 否
     */
    @JsonProperty("miniprogram")
    private MiniProgram miniProgram;
    /**
     * 防重入id。对于同一个openid + client_msg_id, 只发送一条消息,10分钟有效,超过10分钟不保证效果。若无防重入需求，可不填
     * 必填: 否
     */
    @JsonProperty("client_msg_id")
    private String clientMsgId;
    /**
     * 模板数据<br>
     * 注意事项: first第一个字段不支持设置颜色值。
     */
    private MessageData data;

    /**
     * 创建新的模版消息对象
     *
     * @param toUser     接收者openid
     * @param templateId 模板ID
     * @return {@link MessageTemplateSendRequest}
     */
    public static MessageTemplateSendRequest newRequest(@Nonnull String toUser, @Nonnull String templateId) {
        return MessageTemplateSendRequest.builder().toUser(toUser).templateId(templateId).build();
    }

    /**
     * 小程序信息
     */
    @Data
    public static class MiniProgram {
        /**
         * 所需跳转到的小程序appid（该小程序 appid 必须与发模板消息的公众号是绑定关联关系，暂不支持小游戏）
         * 必填: 是
         */
        @JsonProperty("appid")
        private String appId;
        /**
         * 所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar），要求该小程序已发布，暂不支持小游戏
         * 必填: 否
         */
        @JsonProperty("pagepath")
        private String pagePath;
    }

    /**
     * 模板数据
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class MessageData extends HashMap<String, MessageDataValue> {
    }

    /**
     * 消息内容值
     */
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class MessageDataValue {
        /**
         * 值
         */
        private String value;
        /**
         * 模板内容字体颜色，不填默认为黑色。
         * 必填: 否
         */
        private String color;

        public MessageDataValue(String value) {
            this.value = value;
        }
    }
}
