package org.kangspace.wechat.helper.core.request;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import org.kangspace.wechat.helper.core.config.WeChatConfig;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.core.token.WeChatTokenService;

/**
 * 微信请求对象工厂类
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public class WeChatRequestFactory {


    /**
     * Get请求
     *
     * @param url              url
     * @param responseClass    响应对象类型
     * @param wechatConfig     微信配置
     * @param weChatHttpClient 微信HttpClient
     * @param filterChain      过滤器链
     * @return {@link WeChatRequest}
     */
    public static <Req, Resp> WeChatRequest<Req, Resp> get(String url, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, WeChatHttpClient weChatHttpClient, RequestFilterChain filterChain) {
        return new DefaultWeChatRequest<>(url, null, responseClass, wechatConfig, weChatTokenService, weChatHttpClient, filterChain);
    }

    /**
     * Get请求
     *
     * @param url              url
     * @param responseClass    响应对象类型
     * @param wechatConfig     微信配置
     * @param weChatHttpClient 微信HttpClient
     * @param filterChain      过滤器链
     * @param needAccessToken  是否需要token
     * @return {@link WeChatRequest}
     */
    public static <Req, Resp> WeChatRequest<Req, Resp> get(String url, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService,  WeChatHttpClient weChatHttpClient, RequestFilterChain filterChain, boolean needAccessToken) {
        return new DefaultWeChatRequest<>(url, null, responseClass, wechatConfig, weChatTokenService, weChatHttpClient, filterChain, needAccessToken);
    }

    /**
     * Get请求
     *
     * @param url              url
     * @param responseClass    响应对象类型
     * @param wechatConfig     微信配置
     * @param weChatHttpClient 微信HttpClient
     * @param filterChain      过滤器链
     * @return {@link WeChatRequest}
     */
    public static <Req, Resp> WeChatRequest<Req, Resp> get(String url, HttpHeaders httpHeaders, Class<Resp> responseClass, WeChatTokenService weChatTokenService, WeChatConfig wechatConfig, WeChatHttpClient weChatHttpClient, RequestFilterChain filterChain) {
        return new DefaultWeChatRequest<>(url, httpHeaders, responseClass, wechatConfig, weChatTokenService, weChatHttpClient, filterChain);
    }

    /**
     * Post或Put请求
     *
     * @param url              url
     * @param responseClass    响应对象类型
     * @param wechatConfig     微信配置
     * @param weChatHttpClient 微信HttpClient
     * @param filterChain      过滤器链
     * @return {@link WeChatRequest}
     */
    public static <Req, Resp> WeChatRequest<Req, Resp> postOrPut(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, Req requestBody, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, WeChatHttpClient weChatHttpClient, RequestFilterChain filterChain) {
        return new DefaultWeChatRequest<>(url, httpMethod, httpHeaders, requestBody, responseClass, wechatConfig, weChatTokenService, weChatHttpClient, filterChain);
    }
}
