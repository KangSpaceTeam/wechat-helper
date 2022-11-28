package org.kangspace.wechat.helper.core.request.filter;

import lombok.Getter;
import org.kangspace.wechat.helper.core.request.WeChatRequest;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 * 请求过滤器链类,由该类调度各个Filter处理
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/3
 */
@Getter
public class DefaultRequestFilterChain implements RequestFilterChain {
    private final List<RequestFilter> filters;
    private final RequestFilter currentFilter;
    private final DefaultRequestFilterChain chain;

    public DefaultRequestFilterChain() {
        this(Collections.emptyList());
    }

    public DefaultRequestFilterChain(RequestFilter filter) {
        this(Collections.singletonList(filter));
    }

    public DefaultRequestFilterChain(List<RequestFilter> filters) {
        filters.sort(Comparator.comparingInt(RequestFilter::order));
        this.filters = Collections.unmodifiableList(filters);
        DefaultRequestFilterChain chain = initChain(this.filters);
        this.chain = chain.getChain();
        this.currentFilter = chain.getCurrentFilter();
    }

    /**
     * 子过滤器链
     *
     * @param filters       过滤器列表
     * @param currentFilter 当前过滤器
     * @param chain         过滤器链
     */
    private DefaultRequestFilterChain(List<RequestFilter> filters,
                                      RequestFilter currentFilter, DefaultRequestFilterChain chain) {
        sortFilters(filters);
        this.filters = filters;
        this.currentFilter = currentFilter;
        this.chain = chain;
    }

    /**
     * 初始化过滤器链<br>
     *
     * @return {@link  DefaultRequestFilterChain}
     */
    private static DefaultRequestFilterChain initChain(List<RequestFilter> filters) {
        DefaultRequestFilterChain chain = new DefaultRequestFilterChain(filters, null, null);
        ListIterator<? extends RequestFilter> iterator = filters.listIterator(filters.size());
        while (iterator.hasPrevious()) {
            chain = new DefaultRequestFilterChain(filters, iterator.previous(), chain);
        }
        return chain;
    }

    private void sortFilters(List<RequestFilter> filters) {
        try {
            filters.sort(Comparator.comparingInt(RequestFilter::order));
        } catch (Exception e) {
            // 无法排序时忽略
        }
    }

    @Override
    public List<RequestFilter> getRequestFilters() {
        return this.filters;
    }

    @Override
    public <Req, Resp> Mono<Resp> doFilter(WeChatRequest<Req, Resp> request) {
        return Mono.defer(() ->
                this.currentFilter != null && this.chain != null ?
                        invokeFilter(this.currentFilter, this.chain, request) : Mono.empty());
    }

    /**
     * 执行过滤器
     *
     * @param current 当前过滤器
     * @param chain   过滤器链
     * @param request 请求
     * @param <Req>   请求对象类型
     * @param <Resp>  响应对象类型
     * @return Resp
     */
    private <Req, Resp> Mono<Resp> invokeFilter(RequestFilter current, DefaultRequestFilterChain chain, WeChatRequest<Req, Resp> request) {
        String currentName = current.getClass().getName();
        if (current.isSupported(request)) {
            return current.doFilter(request, chain).checkpoint(currentName + " [DefaultRequestFilterChain]");
        }
        return chain.doFilter(request).checkpoint(currentName + " [DefaultRequestFilterChain]");
    }
}
