package org.kangspace.wechat.helper.core.exception;

import lombok.Getter;
import org.kangspace.wechat.helper.core.request.WeChatResponse;

/**
 * 微信Http响应异常,非200/201的请求会触发该异常
 *
 * @author kango2gler@gmail.com
 * @see org.kangspace.wechat.helper.core.request.HttpUtil#isSuccess(int)
 * @since 2022/11/26
 */
@Getter
public class WeChatHttpFaultException extends WeChatRequestException {
    private WeChatResponse<?> weChatResponse;

    public <Resp> WeChatHttpFaultException(WeChatResponse<Resp> weChatResponse) {
        super(weChatResponse != null ? weChatResponse.toString() : "");
        this.weChatResponse = weChatResponse;
    }

    public <Resp> WeChatHttpFaultException(Integer errorCode, String rawErrorMessage, WeChatResponse<Resp> weChatResponse) {
        super(errorCode, rawErrorMessage);
        this.weChatResponse = weChatResponse;
    }

    @Override
    public String toString() {
        return "(WeChatHttpFaultException) errorCode: " + super.getErrorCode() +
                ", errorMessage: " + super.getErrorMessage() +
                ", weChatResponse: " + weChatResponse;
    }
}
