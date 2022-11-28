package org.kangspace.wechat.helper.core.request.filter;

import org.kangspace.wechat.helper.core.request.WeChatRequest;
import reactor.core.publisher.Mono;

/**
 * 请求过滤器
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/2
 */
public interface RequestFilter {
    /**
     * 无效token重试次数
     */
    int INVALID_TOKEN_RETRY_COUNT = 1;

    /**
     * 执行过滤器
     *
     * @param request 请求客户端
     * @param chain   过滤器链
     * @return Mono
     */
    <Req, Resp> Mono<Resp> doFilter(WeChatRequest<Req, Resp> request, RequestFilterChain chain);

    /**
     * 是否支持过滤器
     *
     * @param request 请求客户端
     * @return boolean
     */
    <Req, Resp> boolean isSupported(WeChatRequest<Req, Resp> request);

    /**
     * 过滤器执行顺序,执行顺序:从小到大
     *
     * @return int
     */
    default int order() {
        return 0;
    }
}
