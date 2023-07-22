package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;

/**
 * 企业微信"通讯录管理-标签管理"-创建标签 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/22
 */
@Data
@Builder
public class TagUpdateRequest {
    /**
     * 标签名称，长度限制为32个字以内（汉字或英文字母），标签名不可与其他标签重名。
     */
    @Nonnull
    @JsonProperty("tagname")
    private String tagName;

    /**
     * 标签id，非负整型，指定此参数时新增的标签会生成对应的标签id，不指定时则以目前最大的id自增。
     */
    @JsonProperty("tagid")
    private Long tagId;

    public TagUpdateRequest(@Nonnull String tagName) {
        this.tagName = tagName;
    }

    public TagUpdateRequest(@Nonnull String tagName, Long tagId) {
        this.tagName = tagName;
        this.tagId = tagId;
    }

    public TagUpdateRequest() {
    }
}
