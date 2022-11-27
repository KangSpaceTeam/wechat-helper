package org.kangspace.wechat.helper.core.request;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import org.kangspace.wechat.helper.core.config.WeChatConfig;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.core.token.WeChatTokenService;

/**
 * <p>
 * 微信公众号公共请求API接口 <br>
 * 1. 每个微信API操作都将封装为{@link WeChatRequest}, 由{@link WeChatRequest}通过{@link #getWeChatHttpClient()}执行Http请求。 <br>
 * 2. {@link #getWeChatHttpClient()}执行Http请求前后,将依次执行{@link #getRequestFilterChain()}过滤器链处理。
 * 3. 每个请求对象都包含{@link #getWeChatTokenService()} tokenService, 用于获取token
 * </p>
 *
 * @author kango2gler@gmail.com
 * @see WeChatHttpClient
 * @see RequestFilterChain
 * @since 2022/10/1
 */
public interface WeChatRequest<Req, Resp> {
    /**
     * 请求的URL
     *
     * @return URL
     */
    String getUrl();

    /**
     * 请求的类型
     *
     * @return {@link HttpMethod}
     */
    HttpMethod getHttpMethod();

    /**
     * 请求体
     *
     * @return requestBody
     */
    Req getRequestBody();

    /**
     * 响应对象
     *
     * @return 响应对象
     */
    Class<Resp> getResponseClass();

    /**
     * 请求的请求头
     *
     * @return {@link HttpHeaders}
     */
    HttpHeaders getHttpHeaders();

    /**
     * 微信配置(包括appId等)
     *
     * @return {@link WeChatConfig}
     */
    WeChatConfig getWechatConfig();

    /**
     * 是否需要AccessToken
     *
     * @return boolean
     */
    boolean isNeedAccessToken();

    /**
     * 最大请求重试次数,默认3次(不含第一次请求);
     *
     * @return boolean
     */
    int getMaxRetryCount();

    /**
     * 获取请求客户端
     *
     * @return {@link WeChatHttpClient}
     */
    WeChatHttpClient getWeChatHttpClient();

    /**
     * 获取请求过滤器链
     *
     * @return {@link RequestFilterChain}
     */
    RequestFilterChain getRequestFilterChain();

    /**
     * 获取Token相关Service
     *
     * @return {@link WeChatTokenService}
     */
    WeChatTokenService getWeChatTokenService();

    /**
     * 执行请求
     *
     * @return Resp
     */
    Resp execute();

    /**
     * 执行请求具体操作(不经过{@link org.kangspace.wechat.helper.core.request.filter.RequestFilter}等操作)
     *
     * @return Resp
     */
    Resp doExecute();
}
