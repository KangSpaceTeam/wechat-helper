package org.kangspace.wechat.helper.mp.config;

import lombok.Data;
import lombok.ToString;
import org.kangspace.wechat.helper.core.config.AbstractWeChatConfig;
import org.kangspace.wechat.helper.core.request.WeChatHttpClient;
import org.kangspace.wechat.helper.core.request.WeChatHttpClientFactory;
import org.kangspace.wechat.helper.core.storage.DefaultLocalWeChatTokenStorage;
import org.kangspace.wechat.helper.core.storage.WeChatTokenStorage;
import org.kangspace.wechat.helper.mp.bean.WeChatMpAccessTokenResponse;

/**
 * 微信公众号配置类
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@Data
@ToString(callSuper = true)
public class WeChatMpConfig extends AbstractWeChatConfig {
    /**
     * appId
     */
    private String appId;
    /**
     * appSecret
     */
    private String appSecret;


    public WeChatMpConfig(String appId, String appSecret) {
        this(appId, appSecret, new RequestConfig(), new DefaultLocalWeChatTokenStorage<>());
    }

    public WeChatMpConfig(String appId, String appSecret, RequestConfig requestConfig, WeChatTokenStorage<WeChatMpAccessTokenResponse> weChatTokenStorage) {
        this(appId, appSecret, requestConfig, weChatTokenStorage, WeChatHttpClientFactory.defaultHttpClient());
    }

    public WeChatMpConfig(String appId, String appSecret, RequestConfig requestConfig, WeChatTokenStorage<WeChatMpAccessTokenResponse> weChatTokenStorage, WeChatHttpClient weChatHttpClient) {
        super(requestConfig, weChatTokenStorage, weChatHttpClient);
        this.appId = appId;
        this.appSecret = appSecret;
    }

}