package org.kangspace.wechat.helper.core.request;

import io.netty.handler.codec.http.HttpHeaderValues;
import org.kangspace.wechat.helper.core.constant.StringLiteral;

/**
 * @author kango2gler@gmail.com
 * @since 2022/12/3
 */
public interface HttpConstant {

    /**
     * OK 200状态码
     */
    int OK_CODE = 200;
    /**
     * CREATED 201状态码
     */
    int CREATED_CODE = 201;
    /**
     * BAD_GATEWAY 502状态码
     */
    int BAD_GATEWAY_CODE = 502;
    /**
     * SERVICE_UNAVAILABLE 503状态码
     */
    int SERVICE_UNAVAILABLE_CODE = 503;
    /**
     * GATEWAY_TIMEOUT 504状态码
     */
    int GATEWAY_TIMEOUT_CODE = 504;
    /**
     * Content-Type名称
     */
    String CONTENT_TYPE_NAME = "Content-type";
    /**
     * charset=utf-8
     */
    String CHARSET_UTF8 = "charset=utf-8";


    /**
     * application/json;charset=utf-8
     */
    String APPLICATION_JSON_UTF8 = HttpHeaderValues.APPLICATION_JSON + StringLiteral.SEMICOLON + CHARSET_UTF8;

}
