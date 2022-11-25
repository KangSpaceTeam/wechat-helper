package org.kangspace.wechat.helper.core.request;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import lombok.Getter;
import org.kangspace.wechat.helper.core.config.WeChatConfig;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.core.token.WeChatTokenService;

/**
 * 微信请求对象 <br/>
 *
 * <pre></pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/4
 */
@Getter
public class DefaultWeChatRequest<Req, Resp> extends AbstractWeChatRequest<Req, Resp> {

    public DefaultWeChatRequest(String url, HttpHeaders httpHeaders, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, WeChatHttpClient weChatHttpClient, RequestFilterChain filterChain) {
        super(url, httpHeaders, responseClass, wechatConfig, weChatTokenService, weChatHttpClient, filterChain);
    }

    public DefaultWeChatRequest(String url, HttpHeaders httpHeaders, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, WeChatHttpClient weChatHttpClient, RequestFilterChain filterChain, boolean needAccessToken) {
        super(url, httpHeaders, responseClass, wechatConfig, weChatTokenService, weChatHttpClient, filterChain, needAccessToken);
    }

    public DefaultWeChatRequest(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, Req requestBody, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, WeChatHttpClient weChatHttpClient, RequestFilterChain filterChain) {
        super(url, httpMethod, httpHeaders, requestBody, responseClass, wechatConfig, weChatTokenService, weChatHttpClient, filterChain);
    }
}
