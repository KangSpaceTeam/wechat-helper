package org.kangspace.wechat.helper.core.request.filter;

import org.kangspace.wechat.helper.core.request.WeChatRequest;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 请求过滤器链
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/3
 */
public interface RequestFilterChain {
    /**
     * 获取过滤器链
     *
     * @return List-{@link RequestFilter}
     */
    List<RequestFilter> getRequestFilters();

    /**
     * 执行过滤器,代理过滤器链中的next {@link RequestFilter}
     *
     * @param request request
     * @return Mono
     */
    <Req,Resp> Mono<Resp> doFilter(WeChatRequest<Req,Resp> request);

}
