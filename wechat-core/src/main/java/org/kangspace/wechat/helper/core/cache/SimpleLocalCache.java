package org.kangspace.wechat.helper.core.cache;

import lombok.Data;

/**
 * 简单的本地缓存
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/25
 */
@Data
public class SimpleLocalCache<T> {
    /**
     * 缓存对象
     */
    private T cache;
    /**
     * 超时时间,单位ms
     */
    private long ttlMs;

    /**
     * 创建时间
     */
    private long createTime;

    public SimpleLocalCache(T cache, long ttlMs) {
        this.cache = cache;
        this.ttlMs = ttlMs;
        this.createTime = System.currentTimeMillis();
    }

    /**
     * 获取缓存
     * <p>
     * 当缓存超时时,返回null
     * </p>
     *
     * @return T
     */
    public T getCache() {
        return isValid() ? cache : null;
    }

    /**
     * 缓存是否在有效期内
     *
     * @return boolean
     */
    private boolean isValid() {
        return System.currentTimeMillis() - createTime <= ttlMs;
    }

    private void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
