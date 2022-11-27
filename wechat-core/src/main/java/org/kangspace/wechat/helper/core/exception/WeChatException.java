package org.kangspace.wechat.helper.core.exception;

import lombok.Data;

/**
 * 微信开发助手统一异常类
 *
 * @author kango2gler@gmail.com
 * @since 2022/9/29
 */
@Data
public class WeChatException extends RuntimeException {

    public WeChatException() {
    }

    public WeChatException(String message) {
        super(message);
    }

    public WeChatException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeChatException(Throwable cause) {
        super(cause);
    }
}
