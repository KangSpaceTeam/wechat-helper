package org.kangspace.wechat.helper.work.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.kangspace.wechat.helper.core.config.AbstractWeChatConfig;
import org.kangspace.wechat.helper.core.request.WeChatHttpClient;
import org.kangspace.wechat.helper.core.request.WeChatHttpClientFactory;
import org.kangspace.wechat.helper.core.storage.DefaultLocalWeChatTokenStorage;
import org.kangspace.wechat.helper.core.storage.WeChatTokenStorage;
import org.kangspace.wechat.helper.core.token.AccessTokenResponse;

/**
 * 企业微信配置类
 *
 * @author kango2gler@gmail.com
 * @since 2023/6/22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WeComConfig extends AbstractWeChatConfig {
    // TODO xxx
    /**
     * appId
     */
    private String appId;
    /**
     * appSecret
     */
    private String appSecret;
    /**
     * 签名Token
     */
    private String token;

    /**
     * 公众号第三方平台的 EncodingAESKey
     */
    private String encodingAESKey;

    /**
     * 原始ID
     */
    private String rawId;


    public WeComConfig(String appId, String appSecret) {
        this(appId, appSecret, new RequestConfig(), null);
        this.setWeChatTokenStorage(new DefaultLocalWeChatTokenStorage<>(this));
    }

    public WeComConfig(String appId, String appSecret, RequestConfig requestConfig, WeChatTokenStorage<AccessTokenResponse> weChatTokenStorage) {
        this(appId, appSecret, requestConfig, weChatTokenStorage, WeChatHttpClientFactory.defaultHttpClient());
    }

    public WeComConfig(String appId, String appSecret, RequestConfig requestConfig, WeChatTokenStorage<AccessTokenResponse> weChatTokenStorage, WeChatHttpClient weChatHttpClient) {
        super(requestConfig, weChatTokenStorage, weChatHttpClient);
        this.appId = appId;
        this.appSecret = appSecret;
    }

    @Override
    public String getSecret() {
        return this.appSecret;
    }

    @Override
    public String getToken() {
        return this.token;
    }

    @Override
    public String getEncodingAESKey() {
        return encodingAESKey;
    }
}
