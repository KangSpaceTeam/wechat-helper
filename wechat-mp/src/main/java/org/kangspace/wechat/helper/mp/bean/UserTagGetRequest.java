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
public class UserTagGetRequest {
    /**
     * 标签ID
     */
    @Nonnull
    @JsonProperty("tagid")
    private Long tagId;

    /**
     * 第一个拉取的OPENID，不填默认从头开始拉取
     */
    @JsonProperty("next_openid")
    private String nextOpenId;

    public UserTagGetRequest(@Nonnull Long tagId) {
        this.tagId = tagId;
    }

    public UserTagGetRequest(@Nonnull Long tagId, String nextOpenId) {
        this.tagId = tagId;
        this.nextOpenId = nextOpenId;
    }
}
