package org.kangspace.wechat.helper.core.exception;

/**
 * 签名异常
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/25
 */
public class WeChatSignatureException extends WeChatException {
    public WeChatSignatureException() {
    }

    public WeChatSignatureException(String message) {
        super(message);
    }

    public WeChatSignatureException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeChatSignatureException(Throwable cause) {
        super(cause);
    }
}
