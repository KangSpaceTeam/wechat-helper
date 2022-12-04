package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.core.token.WeChatTokenService;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.request.filter.WeChatMpAccessTokenRequestFilter;
import org.kangspace.wechat.helper.mp.request.filter.WeChatMpRequestFilterChainFactory;
import org.kangspace.wechat.helper.mp.token.DefaultWeChatMpAccessTokenService;
import org.kangspace.wechat.helper.mp.token.WeChatMpAccessTokenService;

/**
 * 微信公众号抽象Service
 * <pre>
 * requestFilterChain: 请求过滤器, 需添加{@link WeChatMpAccessTokenRequestFilter}
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public class AbstractWeChatMpService implements WeChatMpService {
    private final WeChatMpConfig weChatConfig;
    private final RequestFilterChain requestFilterChain;
    private final WeChatMpAccessTokenService weChatMpAccessTokenService;

    public AbstractWeChatMpService(WeChatMpConfig weChatConfig) {
        this(weChatConfig, new DefaultWeChatMpAccessTokenService(weChatConfig));
    }

    public AbstractWeChatMpService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService) {
        this(weChatConfig, weChatMpAccessTokenService, WeChatMpRequestFilterChainFactory.defaultRequestFilterChain());
    }

    public AbstractWeChatMpService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService, RequestFilterChain requestFilterChain) {
        this.weChatConfig = weChatConfig;
        this.requestFilterChain = requestFilterChain;
        this.weChatMpAccessTokenService = weChatMpAccessTokenService != null && !(this instanceof WeChatTokenService) ? weChatMpAccessTokenService : null;
    }

    @Override
    public WeChatMpConfig getWeChatConfig() {
        return weChatConfig;
    }

    @Override
    public RequestFilterChain getRequestFilterChain() {
        return requestFilterChain;
    }

    @Override
    public WeChatTokenService getWeChatTokenService() {
        return weChatMpAccessTokenService;
    }
}
