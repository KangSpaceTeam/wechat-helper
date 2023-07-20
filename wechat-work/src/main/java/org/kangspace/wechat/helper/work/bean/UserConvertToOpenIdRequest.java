package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * userid与openid互换-userid转openid 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/20
 */
@Data
@Builder
public class UserConvertToOpenIdRequest {
    /**
     * 企业内的成员id
     */
    @JsonProperty("userid")
    private String userId;

    public UserConvertToOpenIdRequest(String userId) {
        this.userId = userId;
    }

    public UserConvertToOpenIdRequest() {
    }
}
