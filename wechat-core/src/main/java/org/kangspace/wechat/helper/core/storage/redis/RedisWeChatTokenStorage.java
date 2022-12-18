package org.kangspace.wechat.helper.core.storage.redis;

import lombok.Data;
import org.kangspace.wechat.helper.core.config.WeChatConfig;
import org.kangspace.wechat.helper.core.storage.WeChatTokenStorage;
import org.kangspace.wechat.helper.core.token.WeChatToken;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

/**
 * RedisToken存储器
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/27
 */
@Data
public class RedisWeChatTokenStorage<T extends WeChatToken> implements WeChatTokenStorage<T> {
    private String cacheKeyPrefix = "";

    /**
     * Token格式: wechat-helper:appId
     */
    private static final String REDIS_TOKEN_KEY = "wechat-helper:{0}";

    private WeChatConfig weChatConfig;
    private RedissonClient redissonClient;

    public RedisWeChatTokenStorage(WeChatConfig weChatConfig) {
        this("", weChatConfig);
    }

    public RedisWeChatTokenStorage(String cacheKeyPrefix, WeChatConfig weChatConfig) {
        this.cacheKeyPrefix = cacheKeyPrefix;
        this.weChatConfig = weChatConfig;
        this.redissonClient = weChatConfig.getRedissonClient();
    }

    @Override
    public void setWeChatToken(T tokenObject, long ttlMillis) {
        String redisKey = getRedisKey();
        redissonClient.getBucket(redisKey, JsonJacksonCodec.INSTANCE).set(tokenObject, ttlMillis, TimeUnit.MILLISECONDS);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getWeChatToken() {
        String redisKey = getRedisKey();
        return (T) redissonClient.getBucket(redisKey, JsonJacksonCodec.INSTANCE).get();
    }


    /**
     * 获取换成的RedisKey<br>
     * 格式: {@link #cacheKeyPrefix} + {@link #REDIS_TOKEN_KEY}
     * 如: wechat-mp:wechat-helper:xxxxxxx
     *
     * @return 最终RedisKey
     */
    private String getRedisKey() {
        String appId = getWeChatConfig().getAppId();
        return cacheKeyPrefix + MessageFormat.format(REDIS_TOKEN_KEY, appId);
    }

    @Override
    public WeChatConfig getWeChatConfig() {
        return weChatConfig;
    }

    public void setWeChatConfig(WeChatConfig weChatConfig) {
        this.weChatConfig = weChatConfig;
    }
}
