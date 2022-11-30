package org.kangspace.wechat.helper.core.exception;

import lombok.Data;
import lombok.ToString;

/**
 * 微信请求相关异常类,含请求错误码和原始响应数据
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/26
 */
@Data
@ToString(callSuper = true)
public class WeChatRequestException extends WeChatException {
    /**
     * 微信错误码
     */
    private Integer errorCode;
    /**
     * 微信原始返回的错误信息
     */
    private String rawErrorMessage;

    public WeChatRequestException() {
    }

    public WeChatRequestException(String message) {
        super(message);
    }

    public WeChatRequestException(Integer errorCode, String rawErrorMessage) {
        super(rawErrorMessage);
        this.errorCode = errorCode;
        this.rawErrorMessage = rawErrorMessage;
    }
}
