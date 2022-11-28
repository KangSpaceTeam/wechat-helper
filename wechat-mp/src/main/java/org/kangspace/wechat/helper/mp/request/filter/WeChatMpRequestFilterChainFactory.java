package org.kangspace.wechat.helper.mp.request.filter;

import org.kangspace.wechat.helper.core.request.filter.RequestExecuteFilter;
import org.kangspace.wechat.helper.core.request.filter.RequestExecuteRetryFilter;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChainFactory;

/**
 * 微信公众号RequestFilterChainFactory
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/27
 */
public class WeChatMpRequestFilterChainFactory {

    /**
     * 默认请求RequestFilterChain,包括:
     * <pre>
     * 1. {@link WeChatMpAccessTokenRequestFilter}
     * 2. {@link RequestExecuteFilter}
     * 2. {@link RequestExecuteRetryFilter}
     * </pre>
     *
     * @return {@link RequestFilterChain}
     */
    public static RequestFilterChain defaultRequestFilterChain() {
        return RequestFilterChainFactory.defaultRequestChain(new WeChatMpAccessTokenRequestFilter());
    }
}
