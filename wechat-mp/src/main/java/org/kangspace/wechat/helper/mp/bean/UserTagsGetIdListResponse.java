package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 获取标签下粉丝列表 响应
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/7
 */
@Setter
@Getter
public class UserTagsGetIdListResponse extends WeChatMpResponseEntity {
    /**
     * 被置上的标签列表
     */
    @JsonProperty("tagid_list")
    private List<Long> tagIdList;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "UserTagsGetIdListResponse{" +
                        "tagIdList=" + tagIdList +
                        "}"
        );
    }
}
