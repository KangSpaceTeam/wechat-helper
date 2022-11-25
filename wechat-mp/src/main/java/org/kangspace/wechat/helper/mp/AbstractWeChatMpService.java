package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.core.request.WeChatHttpClient;
import org.kangspace.wechat.helper.core.request.WeChatHttpClientFactory;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChainFactory;
import org.kangspace.wechat.helper.core.token.WeChatTokenService;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.request.filter.WeChatMpAccessTokenRequestFilter;
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
    private final WeChatMpAccessTokenService weChatMpAccessTokenService;
    private final WeChatHttpClient weChatHttpClient;

    private final RequestFilterChain requestFilterChain;

    public AbstractWeChatMpService(WeChatMpConfig weChatConfig) {
        this(weChatConfig, null, null, null);
    }

    public AbstractWeChatMpService(WeChatMpConfig weChatConfig, WeChatHttpClient weChatHttpClient) {
        this(weChatConfig, null, weChatHttpClient, null);
    }

    public AbstractWeChatMpService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService) {
        this(weChatConfig, weChatMpAccessTokenService, null, null);
    }

    public AbstractWeChatMpService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService, WeChatHttpClient weChatHttpClient, RequestFilterChain requestFilterChain) {
        this.weChatConfig = weChatConfig;
        this.weChatMpAccessTokenService = weChatMpAccessTokenService != null ? weChatMpAccessTokenService : (!(this instanceof WeChatTokenService) ? new DefaultWeChatMpAccessTokenService(weChatConfig) : null);
        this.weChatHttpClient = weChatHttpClient != null ? weChatHttpClient : WeChatHttpClientFactory.defaultHttpClient();
        this.requestFilterChain = requestFilterChain != null ? requestFilterChain : RequestFilterChainFactory.defaultRequestChain(new WeChatMpAccessTokenRequestFilter());
    }


    @Override
    public WeChatHttpClient getWeChatHttpClient() {
        return weChatHttpClient;
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
