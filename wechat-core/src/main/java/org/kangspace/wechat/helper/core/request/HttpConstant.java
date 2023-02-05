package org.kangspace.wechat.helper.core.request;

import io.netty.handler.codec.http.HttpHeaderNames;
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
    String CONTENT_TYPE_NAME = HttpHeaderNames.CONTENT_TYPE.toString();

    /**
     * Content-Length
     */
    String CONTENT_LENGTH_NAME = HttpHeaderNames.CONTENT_LENGTH.toString();

    /**
     * Content-disposition
     */
    String CONTENT_DISPOSITION_NAME = HttpHeaderNames.CONTENT_DISPOSITION.toString();

    /**
     * user-agent
     */
    String USER_AGENT_NAME = HttpHeaderNames.USER_AGENT.toString();

    /**
     * ContentType中的text
     */
    String TEXT = "text";
    /**
     * ContentType中的attachment
     */
    String ATTACHMENT = HttpHeaderValues.ATTACHMENT.toString();

    /**
     * filename字段
     */
    String FILE_NAME = "filename";
    /**
     * Content-disposition中按;分割的数量
     */
    int CONTENT_DISPOSITION_VALUE_SIZE = 2;

    /**
     * charset=utf-8
     */
    String CHARSET_UTF8 = "charset=utf-8";


    /**
     * application/json;charset=utf-8
     */
    String APPLICATION_JSON_UTF8 = HttpHeaderValues.APPLICATION_JSON + StringLiteral.SEMICOLON + CHARSET_UTF8;

}
