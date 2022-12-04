package org.kangspace.wechat.helper.core.storage;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.cache.SimpleLocalCache;
import org.kangspace.wechat.helper.core.token.WeChatToken;

/**
 * 微信token存储对象接口
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/27
 */
@Slf4j
public class DefaultLocalWeChatTokenStorage<T extends WeChatToken> implements WeChatTokenStorage<T> {
    /**
     * Token缓存
     */
    private volatile SimpleLocalCache<T> tokenCache;

    @Override
    public void setWeChatToken(T tokenObject, long ttlMillis) {
        synchronized (this) {
            log.debug("Default local wechat token storage: save token: {}, ttlMillis: {}", tokenObject, ttlMillis);
            tokenCache = new SimpleLocalCache<>(tokenObject, ttlMillis);
        }
    }

    @Override
    public T getWeChatToken() {
        return tokenCache != null ? tokenCache.getCache() : null;
    }
}
