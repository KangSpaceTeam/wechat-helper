package org.kangspace.wechat.helper.mp.request.filter;

import org.kangspace.wechat.helper.core.request.AbstractWeChatRequest;
import org.kangspace.wechat.helper.core.request.WeChatRequest;
import org.kangspace.wechat.helper.core.request.filter.AbstractTokenRequestFilter;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.core.retry.RetryRunner;
import org.kangspace.wechat.helper.core.util.TokenUtil;
import org.kangspace.wechat.helper.mp.bean.WeChatMpAccessTokenResponse;
import org.kangspace.wechat.helper.mp.bean.WeChatMpResponseEntity;
import org.kangspace.wechat.helper.mp.constant.WeChatMpResponseCode;
import org.kangspace.wechat.helper.mp.token.WeChatMpAccessTokenService;
import reactor.core.publisher.Mono;

/**
 * 微信公众号AccessToken处理过滤器
 * <p>
 * 作用:
 * 1. 补充需要AccessToken的URL
 * 2. 替换请求URL中失效的AccessToken
 * 3. AccessToken过期时刷新AccessToken
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public class WeChatMpAccessTokenRequestFilter extends AbstractTokenRequestFilter {

    /**
     * 微信公众号AccessToken处理
     *
     * @param request 请求客户端
     * @param chain   过滤器链
     * @return Mono&lt;Resp&gt;
     */
    @Override
    public <Req, Resp> Mono<Resp> doFilter(WeChatRequest<Req, Resp> request, RequestFilterChain chain) {
        return RetryRunner.runWithMonoResult((isRetry) -> {
                    tokenCheckAndReplaceInUrl(request, isRetry);
                    return chain.doFilter(request);
                }, INVALID_TOKEN_RETRY_COUNT,
                (monoResp) -> monoResp != null && monoResp instanceof WeChatMpResponseEntity
                        && WeChatMpResponseCode.CODE_40014.getCode().equals(((WeChatMpResponseEntity) monoResp).getErrCode()));
    }


    /**
     * 检查和替换Url中的token
     *
     * @param request           {@link WeChatRequest}
     * @param forceRefreshToken 强制刷新token
     */
    private <Req, Resp> void tokenCheckAndReplaceInUrl(WeChatRequest<Req, Resp> request, boolean forceRefreshToken) {
        // 检查URL中是否包含Token
        String url = request.getUrl();
        WeChatMpAccessTokenService weChatMpAccessTokenService = (WeChatMpAccessTokenService) request.getWeChatTokenService();
        // 获取token
        WeChatMpAccessTokenResponse token = weChatMpAccessTokenService.token(forceRefreshToken);
        String currAccessToken = token.getAccessToken();
        String oldAccessToken;
        if (TokenUtil.containAccessToken(url) && (oldAccessToken = TokenUtil.getAccessToken(url)) != null && !oldAccessToken.equals(currAccessToken)) {
            url = TokenUtil.replaceAccessToken(url, currAccessToken);
        } else {
            url = TokenUtil.appendAccessToken(url, currAccessToken);
        }
        ((AbstractWeChatRequest<Req, Resp>) request).setUrl(url);
    }

    @Override
    public int order() {
        return Integer.MAX_VALUE - 1;
    }
}
