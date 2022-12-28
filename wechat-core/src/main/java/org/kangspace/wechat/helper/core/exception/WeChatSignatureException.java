package org.kangspace.wechat.helper.core.exception;

import lombok.Data;

/**
 * 签名异常
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/25
 */
@Data
public class WeChatSignatureException extends WeChatException {
    private String signature;
    public WeChatSignatureException() {
    }

    public WeChatSignatureException(String signature) {
        this.signature = signature;
    }

    public WeChatSignatureException(String signature, String message) {
        super(message);
        this.signature = signature;
    }

    public WeChatSignatureException(String signature, String message, Throwable cause) {
        super(message, cause);
        this.signature = signature;
    }

    public WeChatSignatureException(String signature, Throwable cause) {
        super(cause);
        this.signature = signature;
    }
}
