package org.kangspace.wechat.helper.core.cache;

import java.util.function.Supplier;

/**
 * 基于缓存的service接口
 * @author kango2gler@gmail.com
 * @since 2022/10/28
 */
public interface CachedService<KEY_PATTERN> {


    /**
     * 从缓存中获取值,缓存不存在时,拉取新值,并设置缓存
     * @param key 缓存key
     * @param valueSupplier 获取新值
     * @param ttlSeconds 缓存超时时间
     * @return T
     */
    default <T> T getAndSet(String key, Supplier<T> valueSupplier, Long ttlSeconds){
        T v;
        if ((v = getCacheValue(key)) != null) {
            return v;
        }
        v = valueSupplier.get();
        if (v != null) {
            setCacheValue(key, v, ttlSeconds);
        }
        return v;
    }

    /**
     * 获取缓存Key
     * @param keyPattern key模式
     * @param args key 变量参数
     * @return 缓存key
     */
    String getCacheKey(KEY_PATTERN keyPattern, Object... args);

    /**
     * 获取缓存Key
     * @param key key模式
     * @return 缓存key
     */
    default String getCacheKey(KEY_PATTERN key){ return null; }

    /**
     * 根据key获取缓存结果
     * @param key 缓存key
     * @param <T> 缓存值类型
     * @return 缓存值
     */
    <T> T getCacheValue(String key);

    /**
     * 设置缓存(带超时时间)
     * @param key 缓存key
     * @param value 缓存值
     * @param ttlSeconds 超时时间,秒
     * @param <T> 缓存值类型
     * @return 缓存值
     */
    <T> Boolean setCacheValue(String key, T value, Long ttlSeconds);

    /**
     * 设置缓存
     * @param key 缓存key
     * @param value 缓存值
     * @param <T> 缓存值类型
     * @return 缓存值
     */
    default <T> Boolean setCacheValue(String key, T value){
        return this.setCacheValue(key, value, null);
    }

    /**
     * 清除缓存
     * @param key 缓存key
     * @return Boolean
     */
    default Boolean clearCache(String key){ return false;}

    /**
     * 清除所有缓存
     * @return Boolean
     */
    default Boolean clearCaches(){ return false; }
}
