package org.kangspace.wechat.helper.core.exception;

import lombok.Data;
import lombok.ToString;

/**
 * 微信请求相关异常类,含请求错误码和原始响应数据
 * @author kango2gler@gmail.com
 * @since 2022/11/26
 */
@Data
@ToString(callSuper = true)
public class WeChatServerErrorException extends WeChatRequestException{
    public WeChatServerErrorException() {
    }

    public WeChatServerErrorException(Integer errorCode, String rawErrorMessage) {
        super(errorCode, rawErrorMessage);
    }
}
