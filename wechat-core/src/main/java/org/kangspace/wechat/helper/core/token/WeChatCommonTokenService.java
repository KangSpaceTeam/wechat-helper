package org.kangspace.wechat.helper.core.token;

import org.kangspace.wechat.helper.core.constant.TimeConstant;
import org.kangspace.wechat.helper.core.storage.WeChatTokenStorage;

/**
 * 微信token公共处理Service
 * @author kango2gler@gmail.com
 * @since 2023/6/22
 */
public interface WeChatCommonTokenService extends WeChatTokenService{

    /**
     * 微信获取Access token
     *
     * @return {@link AccessTokenResponse}
     */
    @Override
    default AccessTokenResponse token() {
        return this.token(false);
    }

    /**
     * 微信获取Access token
     *
     * @param forceRefresh 是否强制刷新
     * @return {@link AccessTokenResponse}
     */
    default AccessTokenResponse token(boolean forceRefresh) {
        AccessTokenResponse cache = getWeChatTokenStorage().getWeChatToken();
        if (cache == null || forceRefresh) {
            synchronized (this) {
                cache = this.tokenRefresh();
                getWeChatTokenStorage().setWeChatToken(cache, cache.getExpiresIn() * TimeConstant.MillisSecond.ONE_SECOND);
            }
        }
        return cache;
    }

    /**
     * 刷新token
     *
     * @return {@link AccessTokenResponse}
     */
    @Override
    AccessTokenResponse tokenRefresh();

    /**
     * 微信获取Access token
     *
     * @param appId  appId
     * @param secret appSecret
     * @return {@link AccessTokenResponse}
     */
    AccessTokenResponse token(String appId, String secret);

    /**
     * 获取微信Token存储器
     *
     * @return {@link WeChatTokenStorage},{@link AccessTokenResponse}
     */
    @SuppressWarnings("unchecked")
    @Override
    WeChatTokenStorage<AccessTokenResponse> getWeChatTokenStorage();
}
