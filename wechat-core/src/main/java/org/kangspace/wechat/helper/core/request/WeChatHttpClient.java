package org.kangspace.wechat.helper.core.request;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import reactor.core.publisher.Mono;

/**
 * Http请求接口
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/2
 */
public interface WeChatHttpClient {
    /**
     * 同步请求
     *
     * @param uri         url
     * @param httpMethod  {@link HttpMethod}
     * @param httpHeaders {@link HttpHeaders}
     * @param requestBody 请求体
     * @return {@link WeChatResponse}
     */
    default <RequestBody> WeChatResponse<String> execute(String uri, HttpMethod httpMethod, HttpHeaders httpHeaders, RequestBody requestBody) {
        return execute(uri, httpMethod, httpHeaders, requestBody, String.class);
    }

    /**
     * 同步请求
     *
     * @param uri           url
     * @param httpMethod    {@link HttpMethod}
     * @param httpHeaders   {@link HttpHeaders}
     * @param requestBody   请求体
     * @param responseClass 响应体对象
     * @return {@link WeChatResponse}
     */
    default <RequestBody, ResponseBody> WeChatResponse<ResponseBody> execute(String uri, HttpMethod httpMethod, HttpHeaders httpHeaders, RequestBody requestBody, Class<ResponseBody> responseClass) {
        return executeAsync(uri, httpMethod, httpHeaders, requestBody, responseClass).block();
    }

    /**
     * 异步请求
     *
     * @param uri         url
     * @param httpMethod  {@link HttpMethod}
     * @param httpHeaders {@link HttpHeaders}
     * @param requestBody 请求体
     * @return {@link WeChatResponse}
     */
    default <RequestBody> Mono<WeChatResponse<String>> executeAsync(String uri, HttpMethod httpMethod, HttpHeaders httpHeaders, RequestBody requestBody) {
        return executeAsync(uri, httpMethod, httpHeaders, requestBody, String.class);
    }

    /**
     * 异步请求
     *
     * @param uri           url
     * @param httpMethod    {@link HttpMethod}
     * @param httpHeaders   {@link HttpHeaders}
     * @param requestBody   请求体
     * @param responseClass 响应体对象类型
     * @return {@link WeChatResponse}
     */
    <RequestBody, ResponseBody> Mono<WeChatResponse<ResponseBody>> executeAsync(String uri, HttpMethod httpMethod, HttpHeaders httpHeaders, RequestBody requestBody, Class<ResponseBody> responseClass);


    /**
     * 同步Get请求
     *
     * @param uri         url
     * @param httpHeaders {@link HttpHeaders}
     * @return {@link WeChatResponse}
     */
    default WeChatResponse<String> get(String uri, HttpHeaders httpHeaders) {
        return execute(uri, HttpMethod.GET, httpHeaders, null, String.class);
    }

    /**
     * 同步Get请求
     *
     * @param uri url
     * @return {@link WeChatResponse}
     */
    default WeChatResponse<String> get(String uri) {
        return this.get(uri, String.class);
    }

    /**
     * 同步Get请求
     *
     * @param uri           url
     * @param httpHeaders   {@link HttpHeaders}
     * @param responseClass 响应体对象
     * @return {@link WeChatResponse}
     */
    default <ResponseBody> WeChatResponse<ResponseBody> get(String uri, HttpHeaders httpHeaders, Class<ResponseBody> responseClass) {
        return this.execute(uri, HttpMethod.GET, httpHeaders, null, responseClass);
    }

    /**
     * 同步Get请求
     *
     * @param uri           url
     * @param responseClass 响应体对象
     * @return {@link WeChatResponse}
     */
    default <ResponseBody> WeChatResponse<ResponseBody> get(String uri, Class<ResponseBody> responseClass) {
        return this.get(uri, null, responseClass);
    }

    /**
     * 同步Post请求
     *
     * @param uri           url
     * @param httpHeaders   {@link HttpHeaders}
     * @param requestBody   请求体
     * @param responseClass 响应体对象
     * @return {@link WeChatResponse}
     */
    default <RequestBody, ResponseBody> WeChatResponse<ResponseBody> post(String uri, HttpHeaders httpHeaders, RequestBody requestBody, Class<ResponseBody> responseClass) {
        return this.execute(uri, HttpMethod.POST, httpHeaders, requestBody, responseClass);
    }

    /**
     * 同步Put请求
     *
     * @param uri           url
     * @param httpHeaders   {@link HttpHeaders}
     * @param requestBody   请求体
     * @param responseClass 响应体对象
     * @return {@link WeChatResponse}
     */
    default <RequestBody, ResponseBody> WeChatResponse<ResponseBody> put(String uri, HttpHeaders httpHeaders, RequestBody requestBody, Class<ResponseBody> responseClass) {
        return this.execute(uri, HttpMethod.PUT, httpHeaders, requestBody, responseClass);
    }
}
