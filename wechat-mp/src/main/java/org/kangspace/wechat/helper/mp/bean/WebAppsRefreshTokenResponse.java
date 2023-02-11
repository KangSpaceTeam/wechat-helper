package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.core.token.WeChatToken;

/**
 * 微信公众号RefreshToken响应
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/11 17:55:40
 */
@Setter
@Getter
public class WebAppsRefreshTokenResponse extends WeChatMpResponseEntity implements WeChatToken {
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
                "WebAppsRefreshTokenResponse{" +
                        "accessToken='" + accessToken + '\'' +
                        ", expiresIn=" + expiresIn +
                        ", refreshToken='" + refreshToken + '\'' +
                        ", openId='" + openId + '\'' +
                        ", scope=" + scope +
                        "}"
        );
    }
}
