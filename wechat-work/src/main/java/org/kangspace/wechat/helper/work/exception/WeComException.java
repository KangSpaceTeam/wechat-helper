package org.kangspace.wechat.helper.work.exception;

import org.kangspace.wechat.helper.core.exception.WeChatException;

/**
 * 企业微信异常
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public class WeComException extends WeChatException {
    public WeComException() {
    }

    public WeComException(String message) {
        super(message);
    }

    public WeComException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeComException(Throwable cause) {
        super(cause);
    }
}
