package org.kangspace.wechat.helper.core.exception;

/**
 * 消息解析异常
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public class WeChatMessageResolverException extends WeChatException {
    public WeChatMessageResolverException() {
    }

    public WeChatMessageResolverException(String message) {
        super(message);
    }

    public WeChatMessageResolverException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeChatMessageResolverException(Throwable cause) {
        super(cause);
    }
}
