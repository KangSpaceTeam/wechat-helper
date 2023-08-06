package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 消息推送-发送应用消息 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
@Setter
@Getter
public class MessageSendResponse extends WeComResponseEntity {
    /**
     * 不合法的userid，不区分大小写，统一转为小写<br>
     * 如: "userid1|userid2"<br>
     */
    @JsonProperty("invaliduser")
    private String invalidUser;
    /**
     * 不合法的partyid<br>
     * 如: "partyid1|partyid2"<br>
     */
    @JsonProperty("invalidparty")
    private String invalidParty;
    /**
     * 不合法的标签id<br>
     * 如: "tagid1|tagid2"<br>
     */
    @JsonProperty("invalidtag")
    private String invalidTag;
    /**
     * 没有基础接口许可(包含已过期)的userid
     * 如: "partyid1|partyid2"<br>
     */
    @JsonProperty("unlicenseduser")
    private String unlicensedUser;
    /**
     * 消息id，用于撤回应用消息
     */
    @JsonProperty("msgid")
    private String msgId;
    /**
     * 仅消息类型为“按钮交互型”，“投票选择型”和“多项选择型”的模板卡片消息返回，应用可使用response_code调用更新模版卡片消息接口，72小时内有效，且只能使用一次
     */
    @JsonProperty("response_code")
    private String responseCode;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "MessageSendResponse{" +
                        "invalidUser='" + invalidUser + '\'' +
                        ", invalidParty='" + invalidParty + '\'' +
                        ", invalidTag='" + invalidTag + '\'' +
                        ", unlicensedUser='" + unlicensedUser + '\'' +
                        ", msgId='" + msgId + '\'' +
                        ", responseCode='" + responseCode + '\'' +
                        "}"
        );
    }
}
