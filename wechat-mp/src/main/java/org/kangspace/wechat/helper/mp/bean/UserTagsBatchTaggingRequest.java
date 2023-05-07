package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 批量为用户打标签 请求参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/7
 */
@NoArgsConstructor
@Data
public class UserTagsBatchTaggingRequest {
    /**
     * 标签ID
     */
    @Nonnull
    @JsonProperty("tagid")
    private Long tagId;

    /**
     * 粉丝列表
     */
    @Nonnull
    @JsonProperty("openid_list")
    private List<String> openIdList;

    public UserTagsBatchTaggingRequest(@Nonnull Long tagId, @Nonnull String openId) {
        this.tagId = tagId;
        this.openIdList = Collections.singletonList(openId);
    }

    public UserTagsBatchTaggingRequest(@Nonnull Long tagId, @Nonnull String... openIdList) {
        this.tagId = tagId;
        this.openIdList = Arrays.asList(openIdList);
    }

    public UserTagsBatchTaggingRequest(@Nonnull Long tagId, @Nonnull List<String> openIdList) {
        this.tagId = tagId;
        this.openIdList = openIdList;
    }
}
