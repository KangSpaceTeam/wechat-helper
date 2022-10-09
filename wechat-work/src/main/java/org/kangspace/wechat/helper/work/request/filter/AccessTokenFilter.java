package org.kangspace.wechat.helper.work.request.filter;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.request.WeChatRequest;
import org.kangspace.wechat.helper.core.request.filter.AbstractAccessTokenRequestFilter;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import reactor.core.publisher.Mono;

/**
 * AccessToken过滤器,用于生成/更新AccessToken
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/3
 */
@Slf4j
public class AccessTokenFilter extends AbstractAccessTokenRequestFilter {
    private static String NAME = AccessTokenFilter.class.getName();

    @Override
    public Mono<Void> doFilter(WeChatRequest request, RequestFilterChain chain) {
        log.trace("{} doFilter: request:{}", NAME, request);
        return chain.doFilter(request);
    }
}
