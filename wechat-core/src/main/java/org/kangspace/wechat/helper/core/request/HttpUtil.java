package org.kangspace.wechat.helper.core.request;

/**
 * Http工具类
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/26
 */
public class HttpUtil {
    /**
     * OK 200状态码
     */
    public static int OK_CODE = 200;
    /**
     * CREATED 201状态码
     */
    public static int CREATED_CODE = 201;
    /**
     * BAD_GATEWAY 502状态码
     */
    public static int BAD_GATEWAY_CODE = 502;
    /**
     * SERVICE_UNAVAILABLE 503状态码
     */
    public static int SERVICE_UNAVAILABLE_CODE = 503;
    /**
     * GATEWAY_TIMEOUT 504状态码
     */
    public static int GATEWAY_TIMEOUT_CODE = 504;

    /**
     * 是否成功请求(200/201)
     *
     * @param statusCode Http状态码
     * @return boolean
     */
    public static boolean isSuccess(int statusCode) {
        return OK_CODE == statusCode || CREATED_CODE == statusCode;
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
        return BAD_GATEWAY_CODE == statusCode || SERVICE_UNAVAILABLE_CODE == statusCode || GATEWAY_TIMEOUT_CODE == statusCode;
    }
}
