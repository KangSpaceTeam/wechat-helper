package org.kangspace.wechat.helper.core.exception;

/**
 * 微信开发助手统一异常类
 *
 * @author kango2gler@gmail.com
 * @since 2022/9/29
 */
public class WeChatHelperException extends RuntimeException {
    public WeChatHelperException() {
    }

    public WeChatHelperException(String message) {
        super(message);
    }

    public WeChatHelperException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeChatHelperException(Throwable cause) {
        super(cause);
    }

    public WeChatHelperException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
