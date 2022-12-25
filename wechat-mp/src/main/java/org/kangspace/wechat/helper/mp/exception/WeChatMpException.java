package org.kangspace.wechat.helper.mp.exception;

import org.kangspace.wechat.helper.core.exception.WeChatException;

/**
 * 微信公众号异常
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public class WeChatMpException extends WeChatException {
    public WeChatMpException() {
    }

    public WeChatMpException(String message) {
        super(message);
    }

    public WeChatMpException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeChatMpException(Throwable cause) {
        super(cause);
    }
}
