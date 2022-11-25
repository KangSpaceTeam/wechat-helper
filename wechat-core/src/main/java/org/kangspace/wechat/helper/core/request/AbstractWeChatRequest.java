package org.kangspace.wechat.helper.core.request;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.config.WeChatConfig;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.core.token.WeChatTokenService;
import reactor.core.publisher.Mono;

/**
 * 微信公众号公共请求API父类
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/1
 */
@Slf4j
@Data
public abstract class AbstractWeChatRequest<Req, Resp> implements WeChatRequest<Req, Resp> {
    /**
     * 请求的URL
     */
    private String url;

    /**
     * 请求的类型
     */
    private HttpMethod httpMethod = HttpMethod.GET;

    /**
     * 请求的请求头
     */
    private HttpHeaders httpHeaders;

    /**
     * 请求对象
     */
    private Req requestBody;

    /**
     * 响应类
     */
    private Class<Resp> responseClass;

    /**
     * 微信基本配置接口
     */
    private WeChatConfig wechatConfig;

    /**
     * 请求Client
     */
    private WeChatHttpClient weChatHttpClient;

    /**
     * 获取Token相关Service
     */
    private WeChatTokenService weChatTokenService;

    /**
     * 过滤器链
     */
    private RequestFilterChain filterChain;

    /**
     * 是否需要AccessToken
     */
    private boolean needAccessToken = true;

    public AbstractWeChatRequest(String url, HttpHeaders httpHeaders, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, WeChatHttpClient weChatHttpClient, RequestFilterChain filterChain) {
        this.url = url;
        this.httpHeaders = httpHeaders;
        this.responseClass = responseClass;
        this.wechatConfig = wechatConfig;
        this.weChatTokenService = weChatTokenService;
        this.weChatHttpClient = weChatHttpClient;
        this.filterChain = filterChain;
    }

    public AbstractWeChatRequest(String url, HttpHeaders httpHeaders, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, WeChatHttpClient weChatHttpClient, RequestFilterChain filterChain, boolean needAccessToken) {
        this.url = url;
        this.httpHeaders = httpHeaders;
        this.responseClass = responseClass;
        this.wechatConfig = wechatConfig;
        this.weChatTokenService = weChatTokenService;
        this.weChatHttpClient = weChatHttpClient;
        this.filterChain = filterChain;
        this.needAccessToken = needAccessToken;
    }

    public AbstractWeChatRequest(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, Req requestBody, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, WeChatHttpClient weChatHttpClient, RequestFilterChain filterChain) {
        this.url = url;
        this.httpMethod = httpMethod;
        this.httpHeaders = httpHeaders;
        this.requestBody = requestBody;
        this.responseClass = responseClass;
        this.wechatConfig = wechatConfig;
        this.weChatTokenService = weChatTokenService;
        this.weChatHttpClient = weChatHttpClient;
        this.filterChain = filterChain;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    @Override
    public HttpHeaders getHttpHeaders() {
        return this.httpHeaders;
    }

    @Override
    public Req getRequestBody() {
        return requestBody;
    }

    @Override
    public Class<Resp> getResponseClass() {
        return responseClass;
    }

    @Override
    public WeChatConfig getWechatConfig() {
        return wechatConfig;
    }

    @Override
    public boolean isNeedAccessToken() {
        return needAccessToken;
    }

    @Override
    public WeChatHttpClient getWeChatHttpClient() {
        return weChatHttpClient;
    }

    @Override
    public RequestFilterChain getRequestFilterChain() {
        return filterChain;
    }

    @Override
    public WeChatTokenService getWeChatTokenService() {
        return weChatTokenService;
    }

    @Override
    public Resp execute() {
        // http的执行操作,过滤器执行等
        RequestFilterChain requestFilterChain = getRequestFilterChain();
        if (requestFilterChain != null) {
            Mono<Resp> result = requestFilterChain.doFilter(this);
            return result.block();
        }
        return doExecute();
    }

    @Override
    public Resp doExecute() {
        // TODO 添加执行日志
        HttpMethod method = getHttpMethod();
        if (HttpMethod.GET.equals(method)) {
            return get(getUrl(), getHttpHeaders(), getResponseClass());
        }
        if (HttpMethod.POST.equals(method)) {
            return post(getUrl(), getHttpHeaders(), getRequestBody(), getResponseClass());
        }
        if (HttpMethod.PUT.equals(method)) {
            return put(getUrl(), getHttpHeaders(), getRequestBody(), getResponseClass());
        }
        return null;
    }

    /**
     * Http Get请求
     *
     * @param url url
     * @return responseClass
     */
    Resp get(String url, HttpHeaders httpHeaders, Class<Resp> responseClass) {
        WeChatResponse<Resp> response = getWeChatHttpClient().get(url, httpHeaders, responseClass);
        return response.getContent();
    }

    /**
     * Http Post请求
     *
     * @param url           url
     * @param httpHeaders   {@link HttpHeaders}
     * @param requestBody   请求体
     * @param responseClass 响应体对象类型
     * @return Resp
     */
    Resp post(String url, HttpHeaders httpHeaders, Req requestBody, Class<Resp> responseClass) {
        WeChatResponse<Resp> response = getWeChatHttpClient().post(url, httpHeaders, requestBody, responseClass);
        return response.getContent();
    }

    /**
     * Http Put请求
     *
     * @param url           url
     * @param httpHeaders   {@link HttpHeaders}
     * @param requestBody   请求体
     * @param responseClass 响应体对象类型
     * @return Resp
     */
    Resp put(String url, HttpHeaders httpHeaders, Req requestBody, Class<Resp> responseClass) {
        WeChatResponse<Resp> response = getWeChatHttpClient().post(url, httpHeaders, requestBody, responseClass);
        return response.getContent();
    }
}
