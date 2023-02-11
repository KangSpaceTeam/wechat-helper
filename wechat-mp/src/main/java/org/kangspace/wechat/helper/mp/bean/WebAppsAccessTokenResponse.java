package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.core.token.WeChatToken;

/**
 * 微信公众号网页授权获取AccessToken响应
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/11 17:55:40
 */
@Setter
@Getter
public class WebAppsAccessTokenResponse extends WeChatMpResponseEntity implements WeChatToken {
    /**
     * AccessToken
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 超时时间,单位s,默认: 2小时
     */
    @JsonProperty("expires_in")
    private Long expiresIn;

    /**
     * 用户刷新access_token
     */
    @JsonProperty("refresh_token")
    private String refreshToken;

    /**
     * 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
     */
    @JsonProperty("openid")
    private String openId;

    /**
     * 用户授权的作用域，使用逗号（,）分隔
     */
    @JsonProperty("scope")
    private String scope;

    /**
     * 是否为快照页模式虚拟账号，只有当用户是快照页模式虚拟账号时返回，值为1
     */
    @JsonProperty("is_snapshotuser")
    private String isSnapshotUser;

    /**
     * 用户统一标识（针对一个微信开放平台帐号下的应用，同一用户的 unionid 是唯一的），只有当 scope 为"snsapi_userinfo"时返回
     */
    @JsonProperty("unionid")
    private String unionId;


    @Override
    public String getToken() {
        return this.accessToken;
    }

    @Override
    public Long getExpiresIn() {
        return this.expiresIn;
    }

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "WebAppsAccessTokenResponse{" +
                        "accessToken='" + accessToken + '\'' +
                        ", expiresIn=" + expiresIn +
                        ", refreshToken='" + refreshToken + '\'' +
                        ", openId='" + openId + '\'' +
                        ", scope=" + scope +
                        ", isSnapshotUser='" + isSnapshotUser + '\'' +
                        ", unionId='" + unionId + '\'' +
                        "}"
        );
    }
}
