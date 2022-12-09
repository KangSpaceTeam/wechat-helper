package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.kangspace.wechat.helper.core.token.WeChatToken;

/**
 * 微信公众号AccessToken响应
 * <pre>
 * 如: {"access_token":"ACCESS_TOKEN","expires_in":7200}
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@ToString(callSuper = true)
@Data
public class AccessTokenResponse extends WeChatMpResponseEntity implements WeChatToken {
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

    @Override
    public String getToken() {
        return this.accessToken;
    }

    @Override
    public Long getExpiresIn() {
        return this.expiresIn;
    }
}
