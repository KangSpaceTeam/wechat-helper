package org.kangspace.wechat.helper.core.exception;

/**
 * 微信无效Token异常
 *
 * @author kango2gler@gmail.com
 * @since 2022/9/29
 */
public class WeChatInvalidTokenException extends WeChatRequestException {
    public WeChatInvalidTokenException() {
    }

    public WeChatInvalidTokenException(Integer errorCode, String message) {
        super(errorCode, message);
    }

    @Override
    public String toString() {
        return "(WeChatInvalidTokenException) errorCode: " + super.getErrorCode() + ", errorMessage: " + super.getErrorMessage();
    }
}
