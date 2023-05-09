package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.core.constant.StringLiteral;
import org.kangspace.wechat.helper.core.constant.WeChatLang;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.core.util.DigestUtil;
import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;
import org.kangspace.wechat.helper.mp.constant.WebAppConstant;
import org.kangspace.wechat.helper.mp.request.filter.WeChatMpRequestFilterChainFactory;
import org.kangspace.wechat.helper.mp.token.DefaultWeChatMpAccessTokenService;
import org.kangspace.wechat.helper.mp.token.WeChatMpAccessTokenService;

import javax.annotation.Nonnull;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * <p>
 * 微信公众号"网页开发"相关Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/11 17:18:54
 */
public class DefaultWebAppsService extends AbstractWeChatMpService implements WebAppsService {

    public DefaultWebAppsService(WeChatMpConfig weChatConfig) {
        this(weChatConfig, new DefaultWeChatMpAccessTokenService(weChatConfig));
    }

    public DefaultWebAppsService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService) {
        this(weChatConfig, weChatMpAccessTokenService, WeChatMpRequestFilterChainFactory.defaultRequestFilterChain());
    }

    public DefaultWebAppsService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weChatConfig, weChatMpAccessTokenService, requestFilterChain);
    }

    @Override
    public String authorizeUrl(@Nonnull String appId, @Nonnull String redirectUrl, @Nonnull WebAppConstant.Scope scope, String state, boolean forcePopup) {
        return urlTransfer(WeChatMpApiPaths.WEB_APP_AUTHORIZE, appId, redirectUrl, scope.getScope(), state, Boolean.valueOf(forcePopup).toString());
    }

    @Override
    public WebAppsAccessTokenResponse accessToken(String appId, String secret, String code) {
        String url = urlTransfer(WeChatMpApiPaths.WEB_APP_ACCESS_TOKEN, appId, secret, code);
        return get(url, WebAppsAccessTokenResponse.class, false);
    }

    @Override
    public WebAppsRefreshTokenResponse refreshToken(String appId, String refreshToken) {
        String url = urlTransfer(WeChatMpApiPaths.WEB_APP_REFRESH_TOKEN, appId, refreshToken);
        return get(url, WebAppsRefreshTokenResponse.class, false);
    }

    @Override
    public WeChatMpResponseEntity auth(String accessToken, String openId) {
        String url = urlTransfer(WeChatMpApiPaths.WEB_APP_AUTH, accessToken, openId);
        return get(url, WebAppsRefreshTokenResponse.class, false);
    }

    @Override
    public WebAppsUserInfoResponse userInfo(String accessToken, String openId, WeChatLang lang) {
        String url = urlTransfer(WeChatMpApiPaths.WEB_APP_USER_INFO, accessToken, openId, lang.getLang());
        return get(url, WebAppsUserInfoResponse.class, false);
    }

    @Override
    public WebAppsJsApiTicketResponse jsApiTicket() {
        String url = WeChatMpApiPaths.WEB_APP_JS_API_TICKET;
        return get(url, WebAppsJsApiTicketResponse.class);
    }

    @Override
    public WebAppsJsApiSignResponse jsApiSign(String jsApiTicket, String url, String nonceStr, String timestamp) {
        if (url.contains(StringLiteral.HASH_TAG)) {
            url = url.substring(0, url.indexOf(StringLiteral.HASH_TAG));
        }
        SortedMap<String, String> signParams = new TreeMap<>();
        signParams.put("jsapi_ticket", jsApiTicket);
        signParams.put("timestamp", timestamp);
        signParams.put("noncestr", nonceStr);
        signParams.put("url", url);
        String sign = DigestUtil.sha1Url(signParams);
        return new WebAppsJsApiSignResponse(jsApiTicket, url, nonceStr, timestamp, sign);
    }
}
