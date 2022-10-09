package org.kangspace.wechat.helper.core.request;

import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufMono;
import reactor.netty.http.client.HttpClientResponse;

/**
 * Http请求接口
 * @author kango2gler@gmail.com
 * @since 2022/10/2
 */
public interface WeChatHttpClient<RequestBody,ResponseBody> {
    /**
     * 同步请求
     * @param uri url
     * @param httpMethod {@link HttpMethod}
     * @param httpHeaders {@link HttpHeaders}
     * @param requestBody 请求体
     * @return {@link FullHttpResponse}
     */
    WeChatResponse<ResponseBody> execute(String uri, HttpMethod httpMethod, HttpHeaders httpHeaders, RequestBody requestBody);
    /**
     * 异步请求
     * @param uri url
     * @param httpMethod {@link HttpMethod}
     * @param httpHeaders {@link HttpHeaders}
     * @param requestBody 请求体
     * @return {@link FullHttpResponse}
     */
    Mono<WeChatResponse<ResponseBody>> executeAsync(String uri, HttpMethod httpMethod, HttpHeaders httpHeaders, RequestBody requestBody);
}
