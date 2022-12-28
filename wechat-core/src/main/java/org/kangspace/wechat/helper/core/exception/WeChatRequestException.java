package org.kangspace.wechat.helper.core.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 微信请求相关异常类,含请求错误码和原始响应数据
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/26
 */
@Getter
@Setter
public class WeChatRequestException extends WeChatException {
    /**
     * 微信错误码
     */
    private Integer errorCode;
    /**
     * 微信原始返回的错误信息
     */
    private String errorMessage;

    public WeChatRequestException() {
    }

    public WeChatRequestException(String message) {
        this(null, message);
    }

    public WeChatRequestException(Integer errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "WeChatRequestException(errorCode: " + errorCode + ", errorMessage: " + errorMessage + ")";
    }
}
