package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 企业微信"通讯录管理-标签管理"-创建标签 响应对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/22
 */
@Setter
@Getter
public class TagCreateResponse extends WeComResponseEntity {
    /**
     * 标签id
     */
    @JsonProperty("tagid")
    private Long tagId;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "TagCreateResponse{" +
                        "tagId=" + tagId +
                        "}"
        );
    }
}
