package org.kangspace.wechat.helper.core.config;

import lombok.Data;
import org.kangspace.wechat.helper.core.request.WeChatHttpClient;
import org.kangspace.wechat.helper.core.request.WeChatHttpClientFactory;
import org.kangspace.wechat.helper.core.storage.WeChatTokenStorage;
import org.kangspace.wechat.helper.core.storage.redis.RedissonClientFactory;
import org.kangspace.wechat.helper.core.token.WeChatToken;
import org.redisson.api.RedissonClient;

/**
 * 微信配置抽象类
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@Data
public abstract class AbstractWeChatConfig implements WeChatConfig {
    /**
     * Http请求配置
     */
    private RequestConfig requestConfig;
    /**
     * Token存储器
     */
    private WeChatTokenStorage weChatTokenStorage;

    private WeChatHttpClient weChatHttpClient;

    private WeChatRedisConfig redisConfig;

    private volatile RedissonClient redissonClient;

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

    @Override
    public WeChatRedisConfig getRedisConfig() {
        return redisConfig;
    }

    @Override
    public RedissonClient getRedissonClient() {
        if (this.redissonClient == null && getRedisConfig() != null) {
            synchronized (this) {
                if (this.redissonClient == null) {
                    this.redissonClient = RedissonClientFactory.newRedisson(getRedisConfig());

                }
            }
        }
        return redissonClient;
    }
}
