package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;

/**
 * 获取标签下粉丝列表 请求参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/7
 */
@NoArgsConstructor
@Data
public class UserTagsGetIdListRequest {
    /**
     * 用户OpenId
     */
    @Nonnull
    @JsonProperty("openid")
    private String openId;

    public UserTagsGetIdListRequest(@Nonnull String openId) {
        this.openId = openId;
    }
}
