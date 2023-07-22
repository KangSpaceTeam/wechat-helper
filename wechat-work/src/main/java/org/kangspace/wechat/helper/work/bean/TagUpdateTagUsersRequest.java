package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 企业微信"通讯录管理-标签管理"-增加/删除标签成员 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/22
 */
@Data
@Builder
public class TagUpdateTagUsersRequest {
    /**
     * 标签ID
     */
    @Nonnull
    @JsonProperty("tagid")
    private Long tagTd;

    /**
     * 企业成员ID列表，注意：userlist、partylist不能同时为空，单次请求个数不超过1000
     */
    @JsonProperty("userlist")
    private List<String> userList;

    /**
     * 企业部门ID列表，注意：userlist、partylist不能同时为空，单次请求个数不超过100
     */
    @JsonProperty("partylist")
    private List<Long> partyList;

    public TagUpdateTagUsersRequest(@Nonnull Long tagTd, List<String> userList, List<Long> partyList) {
        this.tagTd = tagTd;
        this.userList = userList;
        this.partyList = partyList;
    }

    public TagUpdateTagUsersRequest(@Nonnull Long tagTd, List<String> userList) {
        this.tagTd = tagTd;
        this.userList = userList;
    }

    public TagUpdateTagUsersRequest() {
    }
}
