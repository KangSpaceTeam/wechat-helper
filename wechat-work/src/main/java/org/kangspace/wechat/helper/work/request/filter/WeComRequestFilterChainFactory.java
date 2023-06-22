package org.kangspace.wechat.helper.work.request.filter;

import org.kangspace.wechat.helper.core.request.filter.RequestExecuteFilter;
import org.kangspace.wechat.helper.core.request.filter.RequestExecuteRetryFilter;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChainFactory;

/**
 * 企业微信RequestFilterChainFactory
 *
 * @author kango2gler@gmail.com
 * @since 2023/6/22
 */
public class WeComRequestFilterChainFactory {

    /**
     * 默认请求RequestFilterChain,包括:
     * <pre>
     * 1. {@link WeComAccessTokenRequestFilter}
     * 2. {@link RequestExecuteFilter}
     * 2. {@link RequestExecuteRetryFilter}
     * </pre>
     *
     * @return {@link RequestFilterChain}
     */
    public static RequestFilterChain defaultRequestFilterChain() {
        return RequestFilterChainFactory.defaultRequestChain(new WeComAccessTokenRequestFilter());
    }
}
