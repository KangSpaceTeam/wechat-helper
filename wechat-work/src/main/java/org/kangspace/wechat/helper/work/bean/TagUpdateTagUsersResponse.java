package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 企业微信"通讯录管理-标签管理"-增加/删除标签成员 响应对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/22
 */
@Setter
@Getter
public class TagUpdateTagUsersResponse extends WeComResponseEntity {

    /**
     * 非法的成员帐号列表
     */
    @JsonProperty("invalidlist")
    private List<String> invalidList;

    /**
     * 非法的部门id列表
     */
    @JsonProperty("invalidparty")
    private List<Long> invalidParty;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "TagUpdateTagUsersResponse{" +
                        "invalidList=" + invalidList +
                        ", invalidParty=" + invalidParty +
                        "}"
        );
    }
}
