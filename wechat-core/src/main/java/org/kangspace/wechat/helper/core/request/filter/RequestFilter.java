package org.kangspace.wechat.helper.core.request.filter;

import org.kangspace.wechat.helper.core.request.WeChatRequest;
import reactor.core.publisher.Mono;

/**
 * 请求过滤器
 * @author kango2gler@gmail.com
 * @since 2022/10/2
 */
public interface RequestFilter {

    /**
     * 执行过滤器
     * @param request 请求客户端
     * @param chain 过滤器链
     * @return Mono
     */
    Mono<Void> doFilter(WeChatRequest request, RequestFilterChain chain);

    /**
     * 是否支持过滤器
     * @param request 请求客户端
     * @return boolean
     */
    boolean isSupported(WeChatRequest request);
}
