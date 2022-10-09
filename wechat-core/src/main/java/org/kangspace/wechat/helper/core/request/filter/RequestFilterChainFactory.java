package org.kangspace.wechat.helper.core.request.filter;

/**
 * RequestFilter工厂类
 * @author kango2gler@gmail.com
 * @since 2022/10/4
 */
public class RequestFilterChainFactory {

    /**
     * 获取默认空的过滤器链
     * @return {@link RequestFilterChain}
     */
    public static RequestFilterChain emptyChain() {
        return new DefaultRequestFilterChain();
    }
}
