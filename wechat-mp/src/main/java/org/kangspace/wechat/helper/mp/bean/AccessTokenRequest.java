package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kangspace.wechat.helper.core.constant.StringLiteral;
import org.kangspace.wechat.helper.core.constant.WeChatConstant;

/**
 * 微信公众号AccessToken请求参数
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@Data
public class AccessTokenRequest {
    /**
     * AppId参数名
     */
    private static final String APP_ID_PARAM = "appid";
    /**
     * secret参数名
     */
    private static final String SECRET_PARAM = "secret";

    /**
     * grant_type 参数名
     */
    private static final String GRANT_TYPE_PARAM = "grant_type";

    /**
     * 获取access_token填写client_credential
     * 必填: 是
     */
    @JsonProperty(GRANT_TYPE_PARAM)
    private String grantType = WeChatConstant.OAuthGrantType.CLIENT_CREDENTIAL.toString();

    /**
     * 第三方用户唯一凭证
     * 必填: 是
     */
    @JsonProperty(APP_ID_PARAM)
    private String appId;

    /**
     * 第三方用户唯一凭证密钥，即appsecret
     * 必填: 是
     */
    private String secret;

    public AccessTokenRequest() {
    }

    public AccessTokenRequest(String appId, String secret) {
        this.appId = appId;
        this.secret = secret;
    }

    /**
     * 转换为Url QueryString
     *
     * @return queryString
     */
    public static String toQueryString(String appId, String secret) {
        return APP_ID_PARAM + StringLiteral.EQUALS + (appId != null ? appId : "") + StringLiteral.AND + SECRET_PARAM + StringLiteral.EQUALS + (secret != null ? secret : "")
                + StringLiteral.AND + GRANT_TYPE_PARAM + StringLiteral.EQUALS + WeChatConstant.OAuthGrantType.CLIENT_CREDENTIAL;
    }
}
