package org.kangspace.wechat.helper.core.request;

import io.netty.handler.codec.http.HttpHeaders;
import org.kangspace.wechat.helper.core.bean.MultipartRequest;
import org.kangspace.wechat.helper.core.constant.StringLiteral;
import org.kangspace.wechat.helper.core.util.MimeContentTypes;
import reactor.netty.http.client.HttpClientResponse;

import java.util.Arrays;

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

    /**
     * 清除请求头
     *
     * @param httpHeaders 请求头
     */
    public static void cleanContentType(HttpHeaders httpHeaders) {
        httpHeaders.remove(HttpConstant.CONTENT_TYPE_NAME);
    }


    /**
     * ContentType自动设置
     *
     * @param httpHeaders 请求头
     * @param requestBody 请求体
     */
    public static <RequestBody> void contentTypeRequestHeaderAutoSet(HttpHeaders httpHeaders, RequestBody requestBody) {
        if (requestBody == null || HttpUtil.getContentType(httpHeaders) != null) {
            return;
        }
        String contentType = MimeContentTypes.TEXT_PLAIN_UTF8;
        if (!(requestBody instanceof String)) {
            if (requestBody instanceof MultipartRequest) {
                contentType = MimeContentTypes.MULTIPART_FORM_DATA;
                httpHeaders.set(HttpConstant.CONTENT_LENGTH_NAME, 0);
            } else {
                contentType = MimeContentTypes.APPLICATION_JSON_UTF8;
            }
        }
        httpHeaders.set(HttpConstant.CONTENT_TYPE_NAME, contentType);
    }

    /**
     * 是否为文件响应
     *
     * @param response {@link HttpClientResponse}
     * @return boolean
     */
    public static boolean isAttachmentResponse(HttpClientResponse response) {
        String value = response.responseHeaders().get(HttpConstant.CONTENT_DISPOSITION_NAME);
        return value != null && value.contains(HttpConstant.ATTACHMENT);
    }

    /**
     * 获取相应头中ContentDisposition的fileName字段
     *
     * @param response {@link HttpClientResponse}
     * @return fileName字段值
     */
    public static String getContentDispositionFileName(HttpClientResponse response) {
        String contentDisposition = response.responseHeaders().get(HttpConstant.CONTENT_DISPOSITION_NAME);
        if (contentDisposition != null) {
            return Arrays.stream(contentDisposition.split(StringLiteral.SEMICOLON)).filter(t->t.contains(HttpConstant.FILE_NAME))
                    .map(t->{
                        String[] fileNameBlocks = t.split(StringLiteral.EQUALS);
                        if (fileNameBlocks.length == HttpConstant.CONTENT_DISPOSITION_VALUE_SIZE) {
                            String fileName = fileNameBlocks[1].trim();
                            return fileName.substring(1,fileName.length()-1);
                        }
                        return t;
                    }).findFirst().orElse(null);
        }
        return null;
    }
}
