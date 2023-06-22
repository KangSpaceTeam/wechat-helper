package org.kangspace.wechat.helper.core.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.core.bean.WeChatResponseEntity;

/**
 * 微信公众号AccessToken响应
 * <pre>
 * 如: {"access_token":"ACCESS_TOKEN","expires_in":7200}
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@Setter
@Getter
public class AccessTokenResponse extends WeChatResponseEntity implements WeChatToken {
    /**
     * AccessToken, 最长为512字节
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

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "AccessTokenResponse{" +
                        "accessToken='" + accessToken + '\'' +
                        ", expiresIn=" + expiresIn +
                        "}"
        );
    }
}
