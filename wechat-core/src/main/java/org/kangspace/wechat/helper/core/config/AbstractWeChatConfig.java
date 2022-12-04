package org.kangspace.wechat.helper.core.config;

import lombok.Data;
import org.kangspace.wechat.helper.core.request.WeChatHttpClient;
import org.kangspace.wechat.helper.core.request.WeChatHttpClientFactory;
import org.kangspace.wechat.helper.core.storage.WeChatTokenStorage;
import org.kangspace.wechat.helper.core.token.WeChatToken;

/**
 * 微信配置抽象类
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@Data
public class AbstractWeChatConfig implements WeChatConfig {
    /**
     * Http请求配置
     */
    private RequestConfig requestConfig;
    /**
     * Token存储器
     */
    private WeChatTokenStorage weChatTokenStorage;

    private WeChatHttpClient weChatHttpClient;

    public AbstractWeChatConfig() {
    }

    public <T extends WeChatToken> AbstractWeChatConfig(RequestConfig requestConfig, WeChatTokenStorage<T> weChatTokenStorage) {
        this(requestConfig, weChatTokenStorage, WeChatHttpClientFactory.defaultHttpClient());
    }

    public <T extends WeChatToken> AbstractWeChatConfig(RequestConfig requestConfig, WeChatTokenStorage<T> weChatTokenStorage, WeChatHttpClient weChatHttpClient) {
        this.requestConfig = requestConfig;
        this.weChatTokenStorage = weChatTokenStorage;
        this.weChatHttpClient = weChatHttpClient;
    }

    @Override
    public RequestConfig requestConfig() {
        return requestConfig;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends WeChatToken> WeChatTokenStorage<T> getWeChatTokenStorage() {
        return this.weChatTokenStorage;
    }

    @Override
    public WeChatHttpClient getWeChatHttpClient() {
        return weChatHttpClient;
    }
}
