package org.kangspace.wechat.helper.core.exception;

/**
 * 微信请求相关异常类,含请求错误码和原始响应数据
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/26
 */
public class WeChatServerErrorException extends WeChatRequestException {
    public WeChatServerErrorException() {
    }

    public WeChatServerErrorException(Integer errorCode, String rawErrorMessage) {
        super(errorCode, rawErrorMessage);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
