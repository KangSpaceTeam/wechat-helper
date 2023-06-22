package org.kangspace.wechat.helper.core.request.filter;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.request.AbstractWeChatRequest;
import org.kangspace.wechat.helper.core.request.WeChatRequest;
import org.kangspace.wechat.helper.core.retry.RetryRunner;
import org.kangspace.wechat.helper.core.token.WeChatTokenService;
import org.kangspace.wechat.helper.core.util.TokenUtil;
import reactor.core.publisher.Mono;

/**
 * oAuth2 AccessToken抽象过滤器
 *
 * @author kango2gler@gmail.com
 * @since 2023/06/20
 */
@Slf4j
public abstract class OAuth2TokenRequestFilter extends AbstractTokenRequestFilter {


    /**
     * 测试Token是否有效
     * @param response 响应对象
     * @return boolean
     */
    public abstract <T> boolean testToken(T response);

    /**
     * 执行Token检查和替换
     * @param request {@link WeChatRequest}
     * @param forceRefresh 是否强制刷新Token
     */
    public abstract <Req, Resp> void doTokenCheckAndReplace(WeChatRequest<Req, Resp> request, boolean forceRefresh);



    /**
     * 微信公众号AccessToken处理
     *
     * @param request 请求客户端
     * @param chain   过滤器链
     * @return Mono&lt;Resp&gt;
     */
    @Override
    public <Req, Resp> Mono<Resp> doFilter(WeChatRequest<Req, Resp> request, RequestFilterChain chain) {
        log.debug("WeChatMpAccessTokenRequestFilter run.");
        return RetryRunner.run((isRetry) -> {
                    tokenCheckAndReplace(request, isRetry);
                    return chain.doFilter(request);}
                , INVALID_TOKEN_RETRY_COUNT, this::testToken);
    }

    /**
     * Token检查和替换处理
     * @param request {@link WeChatRequest}
     * @param forceRefreshToken 是否强制刷新Token
     */
    public <Req, Resp> void tokenCheckAndReplace(WeChatRequest<Req, Resp> request, boolean forceRefreshToken) {
        // 检查URL中是否包含Token
        String url = request.getUrl();
        log.debug("tokenCheckAndReplace run: raw url: {}", url);
        doTokenCheckAndReplace(request, forceRefreshToken);
        log.debug("tokenCheckAndReplace run: final url: {}", url);
    }

    /**
     * 替换Url中的token
     * @param request {@link WeChatRequest}
     * @param forceRefresh 是否强制刷新Token
     */
    public <Req, Resp> void replaceUrlToken(WeChatRequest<Req, Resp> request, boolean forceRefresh) {
        String url = request.getUrl();
        String currentToken = fetchCurrentToken(request, forceRefresh);
        String oldAccessToken;
        if (TokenUtil.containAccessToken(url) && (oldAccessToken = TokenUtil.getAccessToken(url)) != null && !oldAccessToken.equals(currentToken)) {
            url = TokenUtil.replaceAccessToken(url, currentToken);
        } else {
            url = TokenUtil.appendAccessToken(url, currentToken);
        }
        ((AbstractWeChatRequest<Req, Resp>) request).setUrl(url);
    }

    /**
     * 获取当前Token
     * @param request {@link WeChatRequest}
     * @param forceRefresh 是否强制刷新
     * @return token
     */
    public <Req, Resp> String fetchCurrentToken(WeChatRequest<Req, Resp> request, boolean forceRefresh){
        WeChatTokenService tokenService = request.getWeChatTokenService();
        return (forceRefresh? tokenService.token(): tokenService.tokenRefresh()).getToken();
    }

}
