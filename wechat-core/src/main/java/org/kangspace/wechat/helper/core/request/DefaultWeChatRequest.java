package org.kangspace.wechat.helper.core.request;

import lombok.Getter;
import org.kangspace.wechat.helper.core.env.WeChatConfig;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChainFactory;

import java.net.URI;

/**
 * @author kango2gler@gmail.com
 * @since 2022/10/4
 */
@Getter
public class DefaultWeChatRequest implements WeChatRequest {

    private String url;
    private WeChatHttpClient weChatHttpClient;
    private WeChatConfig weChatConfig;

    private RequestFilterChain filterChain;

    public DefaultWeChatRequest() {
        this(new WeChatConfig(), WeChatHttpClientFactory.defaultHttpClient(), RequestFilterChainFactory.emptyChain());
    }

    public DefaultWeChatRequest(WeChatConfig weChatConfig, WeChatHttpClient weChatHttpClient, RequestFilterChain filterChain) {
        this.weChatConfig = weChatConfig;
        this.weChatHttpClient = weChatHttpClient;
        this.filterChain = filterChain;
    }

    private static int getPort(URI uri) {
        int port = uri.getPort();
        if (port == -1) {
            if ("http".equalsIgnoreCase(uri.getScheme())) {
                port = 80;
            } else if ("https".equalsIgnoreCase(uri.getScheme())) {
                port = 443;
            }
        }
        return port;
    }

    @Override
    public String url() {
        return null;
    }

    @Override
    public WeChatHttpClient getWeChatHttpClient() {
        return weChatHttpClient;
    }
}
