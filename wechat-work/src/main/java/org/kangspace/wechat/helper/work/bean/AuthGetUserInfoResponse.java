package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 身份验证-获取访问用户敏感信息 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
@Setter
@Getter
public class AuthGetUserInfoResponse extends WeComResponseEntity {
    /**
     * 成员UserID。若需要获得用户详情信息，可调用通讯录接口：读取成员。如果是互联企业/企业互联/上下游，则返回的UserId格式如：CorpId/userid
     */
    @JsonProperty("userid")
    private String userId;

    /**
     * 成员票据，最大为512字节，有效期为1800s。 <br>
     * scope为snsapi_privateinfo，且用户在应用可见范围之内时返回此参数。 <br>
     * 后续利用该参数可以获取用户信息或敏感信息，参见"获取访问用户敏感信息"。暂时不支持上下游或/企业互联场景 <br>
     */
    @JsonProperty("user_ticket")
    private String user_ticket;

    /**
     * 非企业成员的标识，对当前企业唯一。不超过64字节
     */
    @JsonProperty("openid")
    private String openId;

    /**
     * 外部联系人id，当且仅当用户是企业的客户，且跟进人在应用的可见范围内时返回。如果是第三方应用调用，针对同一个客户，同一个服务商不同应用获取到的id相同
     */
    @JsonProperty("external_userid")
    private String externalUserId;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "AuthGetUserInfoResponse{" +
                        "userId='" + userId + '\'' +
                        ", user_ticket='" + user_ticket + '\'' +
                        ", openId='" + openId + '\'' +
                        ", externalUserId='" + externalUserId + '\'' +
                        "}"
        );
    }
}
