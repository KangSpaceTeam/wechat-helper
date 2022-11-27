package org.kangspace.wechat.helper.core.storage;

import org.kangspace.wechat.helper.core.cache.SimpleLocalCache;

/**
 * 微信token存储对象接口
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/27
 */
public class DefaultLocalWeChatTokenStorage<T> implements WeChatTokenStorage<T> {
    /**
     * Token缓存
     */
    private volatile SimpleLocalCache<T> tokenCache;

    @Override
    public void setToken(T tokenObject, long ttlMillis) {
        synchronized (this) {
            tokenCache = new SimpleLocalCache<>(tokenObject, ttlMillis);
        }
    }

    @Override
    public T getToken() {
        return tokenCache != null ? tokenCache.getCache() : null;
    }
}
