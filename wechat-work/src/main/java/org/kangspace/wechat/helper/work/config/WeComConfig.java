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
    /**
     * 企业ID
     */
    private String corpId;
    /**
     * 应用的凭证密钥
     */
    private String corpSecret;

    public WeComConfig(String corpId, String corpSecret) {
        this(corpId, corpSecret, new RequestConfig(), null);
        this.setWeChatTokenStorage(new DefaultLocalWeChatTokenStorage<>(this));
    }

    public WeComConfig(String corpId, String corpSecret, RequestConfig requestConfig, WeChatTokenStorage<AccessTokenResponse> weChatTokenStorage) {
        this(corpId, corpSecret, requestConfig, weChatTokenStorage, WeChatHttpClientFactory.defaultHttpClient());
    }

    public WeComConfig(String corpId, String corpSecret, RequestConfig requestConfig, WeChatTokenStorage<AccessTokenResponse> weChatTokenStorage, WeChatHttpClient weChatHttpClient) {
        super(requestConfig, weChatTokenStorage, weChatHttpClient);
        this.corpId = corpId;
        this.corpSecret = corpSecret;
    }

    @Override
    public String getAppId() {
        return corpId;
    }

    @Override
    public String getSecret() {
        return this.corpSecret;
    }
}
