package org.kangspace.wechat.helper.mp.token;

import org.kangspace.wechat.helper.core.token.WeChatTokenService;
import org.kangspace.wechat.helper.mp.bean.WeChatMpAccessTokenResponse;

/**
 * 微信公众号AccessTokenService
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public interface WeChatMpAccessTokenService extends WeChatTokenService {
    /**
     * 微信公众号获取Access token
     * @return {@link WeChatMpAccessTokenResponse}
     */
    default WeChatMpAccessTokenResponse token(){
        return this.token(false);
    }
    /**
     * 微信公众号获取Access token
     * @param forceRefresh 是否强制刷新
     * @return {@link WeChatMpAccessTokenResponse}
     */
    default WeChatMpAccessTokenResponse token(boolean forceRefresh){
        WeChatMpAccessTokenResponse cache = getAccessTokenCache();
        if (cache == null || forceRefresh) {
            synchronized (this) {
                cache = this.tokenRefresh();
                setAccessTokenCache(cache);
            }
        }
        return cache;
    }

    /**
     * 刷新token
     * @return {@link WeChatMpAccessTokenResponse}
     */
    WeChatMpAccessTokenResponse tokenRefresh();

    /**
     * 微信公众号获取Access token
     * @param appId appId
     * @param secret appSecret
     * @return {@link WeChatMpAccessTokenResponse}
     */
    WeChatMpAccessTokenResponse token(String appId, String secret);

    /**
     * 设置缓存
     * @param accessTokenResponse {@link WeChatMpAccessTokenResponse}
     */
    void setAccessTokenCache(WeChatMpAccessTokenResponse accessTokenResponse);

    /**
     * 获取缓存
     * @return {@link WeChatMpAccessTokenResponse}
     */
    WeChatMpAccessTokenResponse getAccessTokenCache();
}
