package org.kangspace.wechat.helper.core.storage.redis;

import org.kangspace.wechat.helper.core.storage.WeChatTokenStorage;
import org.kangspace.wechat.helper.core.token.WeChatToken;

/**
 * RedisToken存储器
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/27
 */
public class RedisWeChatTokenStorage<T extends WeChatToken> implements WeChatTokenStorage<T> {
    @Override
    public void setWeChatToken(T tokenObject, long ttlMillis) {

    }

    @Override
    public T getWeChatToken() {
        return null;
    }
}
