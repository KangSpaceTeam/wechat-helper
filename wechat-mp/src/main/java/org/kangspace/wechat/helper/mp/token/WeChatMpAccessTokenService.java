package org.kangspace.wechat.helper.mp.token;

import org.kangspace.wechat.helper.core.constant.TimeConstant;
import org.kangspace.wechat.helper.core.storage.WeChatTokenStorage;
import org.kangspace.wechat.helper.core.token.WeChatTokenService;
import org.kangspace.wechat.helper.mp.bean.MpAccessTokenResponse;

/**
 * 微信公众号AccessTokenService
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public interface WeChatMpAccessTokenService extends WeChatTokenService {
    /**
     * 微信公众号获取Access token
     *
     * @return {@link MpAccessTokenResponse}
     */
    @Override
    default MpAccessTokenResponse token() {
        return this.token(false);
    }

    /**
     * 微信公众号获取Access token
     *
     * @param forceRefresh 是否强制刷新
     * @return {@link MpAccessTokenResponse}
     */
    default MpAccessTokenResponse token(boolean forceRefresh) {
        MpAccessTokenResponse cache = getWeChatTokenStorage().getWeChatToken();
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
     * @return {@link MpAccessTokenResponse}
     */
    @Override
    MpAccessTokenResponse tokenRefresh();

    /**
     * 微信公众号获取Access token
     *
     * @param appId  appId
     * @param secret appSecret
     * @return {@link MpAccessTokenResponse}
     */
    MpAccessTokenResponse token(String appId, String secret);

    /**
     * 获取微信公众号Token存储器
     *
     * @return {@link WeChatTokenStorage},{@link MpAccessTokenResponse}
     */
    @SuppressWarnings("unchecked")
    @Override
    WeChatTokenStorage<MpAccessTokenResponse> getWeChatTokenStorage();
}
