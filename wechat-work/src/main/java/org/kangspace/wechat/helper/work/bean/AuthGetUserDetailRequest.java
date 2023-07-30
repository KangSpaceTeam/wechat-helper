package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;

/**
 * 身份验证-获取访问用户敏感信息 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
@Data
@Builder
public class AuthGetUserDetailRequest {
    /**
     * 成员票据
     */
    @Nonnull
    @JsonProperty("user_ticket")
    private String userTicket;

    public AuthGetUserDetailRequest() {
    }

    public AuthGetUserDetailRequest(@Nonnull String userTicket) {
        this.userTicket = userTicket;
    }
}
