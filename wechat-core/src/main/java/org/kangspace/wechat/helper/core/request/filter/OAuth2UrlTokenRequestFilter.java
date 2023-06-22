package org.kangspace.wechat.helper.core.request.filter;

import org.kangspace.wechat.helper.core.request.WeChatRequest;

/**
 * oAuth2 AccessToken过滤器(token在Url中)
 * @author kango2gler@gmail.com
 * @since 2023/6/20
 */
public abstract class OAuth2UrlTokenRequestFilter extends OAuth2TokenRequestFilter{
    @Override
    public <Req, Resp> void doTokenCheckAndReplace(WeChatRequest<Req, Resp> request, boolean forceRefresh) {
        replaceUrlToken(request, forceRefresh);
    }
}
