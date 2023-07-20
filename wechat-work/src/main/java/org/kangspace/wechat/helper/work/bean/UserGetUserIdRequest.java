package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 手机号获取userid 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/20
 */
@Data
@Builder
public class UserGetUserIdRequest {
    /**
     * 用户在企业微信通讯录中的手机号码。长度为5~32个字节
     */
    @JsonProperty("mobile")
    private String mobile;

    public UserGetUserIdRequest(String mobile) {
        this.mobile = mobile;
    }

    public UserGetUserIdRequest() {
    }
}
