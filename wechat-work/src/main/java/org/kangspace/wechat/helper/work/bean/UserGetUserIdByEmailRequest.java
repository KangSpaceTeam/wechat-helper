package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 邮箱获取userid 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/20
 */
@Data
@Builder
public class UserGetUserIdByEmailRequest {
    /**
     * 邮箱
     */
    @JsonProperty("email")
    private String email;
    /**
     * 	邮箱类型：1-企业邮箱（默认）；2-个人邮箱
     */
    @JsonProperty("email_type")
    private String emailType;

    public UserGetUserIdByEmailRequest(String email, String emailType) {
        this.email = email;
        this.emailType = emailType;
    }

    public UserGetUserIdByEmailRequest(String email) {
        this.email = email;
    }

    public UserGetUserIdByEmailRequest() {
    }
}
