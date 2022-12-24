package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;

/**
 * 测试个性化菜单匹配结果 请求参数
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/10
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuTryMatchRequest {
    /**
     * user_id可以是粉丝的OpenID，也可以是粉丝的微信号
     */
    @Nonnull
    @JsonProperty("user_id")
    private String userId;
}
