package org.kangspace.wechat.helper.core.config;

import lombok.Data;
import org.kangspace.wechat.helper.core.request.WeChatHttpClient;
import org.kangspace.wechat.helper.core.request.WeChatHttpClientFactory;
import org.kangspace.wechat.helper.core.storage.WeChatTokenStorage;

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

    public <T> AbstractWeChatConfig(RequestConfig requestConfig, WeChatTokenStorage<T> weChatTokenStorage) {
        this(requestConfig, weChatTokenStorage, WeChatHttpClientFactory.defaultHttpClient());
    }

    public <T> AbstractWeChatConfig(RequestConfig requestConfig, WeChatTokenStorage<T> weChatTokenStorage, WeChatHttpClient weChatHttpClient) {
        this.requestConfig = requestConfig;
        this.weChatTokenStorage = weChatTokenStorage;
        this.weChatHttpClient = weChatHttpClient;
    }

    @Override
    public RequestConfig requestConfig() {
        return requestConfig;
    }

    @Override
    public <T> WeChatTokenStorage<T> getWeChatTokenStorage() {
        return this.weChatTokenStorage;
    }

    @Override
    public WeChatHttpClient getWeChatHttpClient(){
        return weChatHttpClient;
    }
}
