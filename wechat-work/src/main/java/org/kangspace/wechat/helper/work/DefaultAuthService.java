package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

import javax.annotation.Nonnull;

/**
 * <p>
 *  企业微信"身份验证"相关 Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
public class DefaultAuthService extends AbstractWeComService implements AuthService {

    public DefaultAuthService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultAuthService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultAuthService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }

    @Override
    public String connectOAuth2Authorize(@Nonnull String appId, @Nonnull String redirectUri, @Nonnull String scope, String state, @Nonnull String agentId) {
        return urlTransfer(WeComApiPaths.CONNECT_OAUTH2_AUTHORIZE, appId, redirectUri, scope, state, agentId);
    }

    @Override
    public AuthGetUserInfoResponse authGetUserInfo(@Nonnull String code) {
        String url = urlTransfer(WeComApiPaths.AUTH_GET_USER_INFO, code);
        return get(url, AuthGetUserInfoResponse.class);
    }

    @Override
    public AuthGetUserDetailResponse authGetUserDetail(AuthGetUserDetailRequest request) {
        String url = WeComApiPaths.AUTH_GET_USER_DETAIL;
        return post(url,request, AuthGetUserDetailResponse.class);
    }
}
