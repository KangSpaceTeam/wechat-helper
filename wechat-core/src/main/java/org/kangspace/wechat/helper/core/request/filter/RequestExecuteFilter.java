package org.kangspace.wechat.helper.core.request.filter;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.request.WeChatRequest;
import reactor.core.publisher.Mono;

/**
 * 执行Http请求过滤器
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@Slf4j
public class RequestExecuteFilter implements RequestFilter {
    @Override
    public <Req, Resp> Mono<Resp> doFilter(WeChatRequest<Req, Resp> request, RequestFilterChain chain) {
        log.debug("request execute filter run.");
        // 执行Http请求
        return Mono.just(request.doExecute());
    }

    @Override
    public <Req, Resp> boolean isSupported(WeChatRequest<Req, Resp> request) {
        return true;
    }

    @Override
    public int order() {
        return RequestFilterOrder.REQUEST_EXECUTE_FILTER.getOrder();
    }
}
