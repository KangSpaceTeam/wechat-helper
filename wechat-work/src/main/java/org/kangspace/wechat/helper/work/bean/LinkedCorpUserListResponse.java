package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 通讯录管理-互联企业-获取互联企业部门成员详情 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/27
 */
@Setter
@Getter
public class LinkedCorpUserListResponse extends WeComResponseEntity {
    /**
     * 成员列表
     */
    @JsonProperty("userlist")
    private List<LinkedCorpUser> userList;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "LinkedCorpUserListResponse{" +
                        "userList=" + userList +
                        "}"
        );
    }
}
