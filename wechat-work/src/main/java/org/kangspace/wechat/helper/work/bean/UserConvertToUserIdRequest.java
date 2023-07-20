package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * userid与openid互换-openid转userid 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/20
 */
@Data
@Builder
public class UserConvertToUserIdRequest {
    /**
     * 在使用企业支付之后，返回结果的openid
     */
    @JsonProperty("openid")
    private String openId;

    public UserConvertToUserIdRequest(String openId) {
        this.openId = openId;
    }

    public UserConvertToUserIdRequest() {
    }
}
