package org.kangspace.wechat.helper.core.request;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.bean.WeChatResponseEntity;
import org.kangspace.wechat.helper.core.config.WeChatConfig;
import org.kangspace.wechat.helper.core.constant.WeChatResponseCode;
import org.kangspace.wechat.helper.core.exception.WeChatException;
import org.kangspace.wechat.helper.core.exception.WeChatHttpFaultException;
import org.kangspace.wechat.helper.core.exception.WeChatRequestException;
import org.kangspace.wechat.helper.core.exception.WeChatServerErrorException;
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

    public AbstractWeChatRequest(String url, HttpHeaders httpHeaders, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, RequestFilterChain filterChain) {
        this(url, httpHeaders, responseClass, wechatConfig, weChatTokenService, filterChain, true);
    }

    public AbstractWeChatRequest(String url, HttpHeaders httpHeaders, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, RequestFilterChain filterChain, boolean needAccessToken) {
        this(url, HttpMethod.GET, httpHeaders, null, responseClass, wechatConfig, weChatTokenService, filterChain, needAccessToken);
    }

    public AbstractWeChatRequest(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, Req requestBody, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, RequestFilterChain filterChain) {
        this(url, httpMethod, httpHeaders, requestBody, responseClass, wechatConfig, weChatTokenService, filterChain, true);
    }

    public AbstractWeChatRequest(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, Req requestBody, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, RequestFilterChain filterChain, boolean needAccessToken) {
        this.url = url;
        this.httpMethod = httpMethod;
        this.httpHeaders = httpHeaders;
        this.requestBody = requestBody;
        this.responseClass = responseClass;
        this.wechatConfig = wechatConfig;
        this.weChatTokenService = weChatTokenService;
        this.weChatHttpClient = wechatConfig.getWeChatHttpClient();
        this.filterChain = filterChain;
        this.needAccessToken = needAccessToken;
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
        log.debug("Request execute: request: {}", this);
        // http的执行操作,过滤器执行等
        RequestFilterChain requestFilterChain = getRequestFilterChain();
        log.debug("Request execute filter chain: {}", requestFilterChain);
        if (requestFilterChain != null) {
            Mono<Resp> result = requestFilterChain.doFilter(this);
            return result.block();
        }
        return doExecute();
    }

    @Override
    public Resp doExecute() {
        log.debug("Request doExecute: url: {}, method: {}, httpHeader: {}, requestBody: {}, responseClass: {}", getUrl(), getHttpMethod(), getHttpHeaders(), getRequestBody(), getResponseClass());
        HttpMethod method = getHttpMethod();
        WeChatResponse<Resp> response;
        if (HttpMethod.GET.equals(method)) {
            response = get(getUrl(), getHttpHeaders(), getResponseClass());
        } else if (HttpMethod.POST.equals(method)) {
            response = post(getUrl(), getHttpHeaders(), getRequestBody(), getResponseClass());
        } else if (HttpMethod.PUT.equals(method)) {
            response = put(getUrl(), getHttpHeaders(), getRequestBody(), getResponseClass());
        } else {
            throw new WeChatException("Request HttpMethod: " + method + " not support!");
        }
        log.debug("Request doExecute: response: {}", response);
        // 非200/201时抛出异常
        if (response == null || !HttpUtil.isSuccess(response.status())) {
            throw new WeChatHttpFaultException(response);
        }
        Resp resp = response.getContent();
        // 检查响应内容为微信服务异常时抛出异常
        throwExceptionOnWeChatServerError(resp);
        return resp;
    }

    /**
     * 检查响应内容为微信服务异常时抛出异常
     *
     * @param resp {@link Resp}
     */
    private void throwExceptionOnWeChatServerError(Resp resp) {
        WeChatResponseEntity serverError;
        if (resp instanceof WeChatResponseEntity) {
            boolean isWeChatServerError = WeChatResponseCode.CODE_NE_1.getCode().equals((serverError = (WeChatResponseEntity) resp).getErrCode());
            if (isWeChatServerError) {
                log.warn("Request response: wechat server error, response: {}", resp);
                throw new WeChatServerErrorException(serverError.getErrCode(), serverError.getErrMsg());
            }
            boolean isNotSuccessResponse = !(serverError.getErrCode() == null || WeChatResponseCode.SUCCESS.getCode().equals(serverError.getErrCode()));
            if (isNotSuccessResponse) {
                log.warn("Request response: wechat request not success, response: {}", resp);
                throw new WeChatRequestException(serverError.getErrCode(), serverError.getErrMsg());
            }
        }
    }

    /**
     * Http Get请求
     *
     * @param url url
     * @return responseClass
     */
    WeChatResponse<Resp> get(String url, HttpHeaders httpHeaders, Class<Resp> responseClass) {
        return getWeChatHttpClient().get(url, httpHeaders, responseClass);
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
    WeChatResponse<Resp> post(String url, HttpHeaders httpHeaders, Req requestBody, Class<Resp> responseClass) {
        return getWeChatHttpClient().post(url, httpHeaders, requestBody, responseClass);
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
    WeChatResponse<Resp> put(String url, HttpHeaders httpHeaders, Req requestBody, Class<Resp> responseClass) {
        return getWeChatHttpClient().post(url, httpHeaders, requestBody, responseClass);
    }
}
