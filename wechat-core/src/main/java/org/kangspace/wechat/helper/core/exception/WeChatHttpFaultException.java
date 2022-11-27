package org.kangspace.wechat.helper.core.exception;

import lombok.Getter;
import org.kangspace.wechat.helper.core.request.WeChatResponse;

/**
 * 微信Http响应异常,非200/201的请求会触发该异常
 * @author kango2gler@gmail.com
 * @since 2022/11/26
 * @see org.kangspace.wechat.helper.core.request.HttpUtil#isSuccess(int)
 */
@Getter
public class WeChatHttpFaultException extends WeChatRequestException{
    private final WeChatResponse<?> weChatResponse;

    public <Resp> WeChatHttpFaultException(WeChatResponse<Resp> weChatResponse) {
        this.weChatResponse = weChatResponse;
    }

    public <Resp> WeChatHttpFaultException(Integer errorCode, String rawErrorMessage, WeChatResponse<Resp> weChatResponse) {
        super(errorCode, rawErrorMessage);
        this.weChatResponse = weChatResponse;
    }
}
