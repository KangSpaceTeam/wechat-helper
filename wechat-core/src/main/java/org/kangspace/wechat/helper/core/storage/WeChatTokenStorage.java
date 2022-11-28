package org.kangspace.wechat.helper.core.storage;

/**
 * 微信token存储对象接口
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/27
 */
public interface WeChatTokenStorage<T> {
    /**
     * 设置缓存
     *
     * @param tokenObject {@link T}
     * @param ttlMillis   超时时间(毫秒)
     */
    void setToken(T tokenObject, long ttlMillis);

    /**
     * 获取缓存
     *
     * @return {@link T}
     */
    T getToken();
}
