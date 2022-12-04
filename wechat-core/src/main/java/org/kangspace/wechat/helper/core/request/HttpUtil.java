package org.kangspace.wechat.helper.core.request;

import io.netty.handler.codec.http.HttpHeaders;
import reactor.netty.http.client.HttpClientResponse;

/**
 * Http工具类
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/26
 */
public class HttpUtil {


    /**
     * 是否成功请求(200/201)
     *
     * @param statusCode Http状态码
     * @return boolean
     */
    public static boolean isSuccess(int statusCode) {
        return HttpConstant.OK_CODE == statusCode || HttpConstant.CREATED_CODE == statusCode;
    }

    /**
     * 是否需要重试的http状态
     * <pre>
     * true: 502,503,504状态码
     * false: 其他非{@link #isSuccess(int)}的状态码
     * </pre>
     *
     * @param statusCode Http状态码
     * @return boolean
     */
    public static boolean isRetryHttpStatus(int statusCode) {
        return HttpConstant.BAD_GATEWAY_CODE == statusCode || HttpConstant.SERVICE_UNAVAILABLE_CODE == statusCode || HttpConstant.GATEWAY_TIMEOUT_CODE == statusCode;
    }


    /**
     * 获取ContentType
     *
     * @return contentType contentType
     */
    public static String getContentType(HttpClientResponse response) {
        return response != null ? response.responseHeaders().get(HttpConstant.CONTENT_TYPE_NAME) : null;
    }

    /**
     * 获取ContentType
     *
     * @return contentType contentType
     */
    public static String getContentType(HttpHeaders httpHeaders) {
        return httpHeaders != null ? httpHeaders.get(HttpConstant.CONTENT_TYPE_NAME) : null;
    }

    /**
     * 请求头设置{@link HttpConstant#CONTENT_TYPE_NAME}
     *
     * @param httpHeaders 请求头
     * @param value       值
     */
    public static void setContentType(HttpHeaders httpHeaders, String value) {
        httpHeaders.set(HttpConstant.CONTENT_TYPE_NAME, value);
    }
}
