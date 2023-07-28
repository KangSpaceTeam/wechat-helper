package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 通讯录管理-互联企业-获取互联企业部门成员 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/27
 */
@Setter
@Getter
public class LinkedCorpUserSimpleListResponse extends WeComResponseEntity {
    /**
     * 成员列表
     */
    @JsonProperty("userlist")
    private UserInfo userList;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "LinkedCorpUserSimpleListResponse{" +
                        "userList=" + userList +
                        "}"
        );
    }

    @Data
    public static class UserInfo {
        /**
         * 	成员UserID。对应管理端的帐号
         */
        @JsonProperty("userid")
        private String userId;
        /**
         * 	成员真实名称
         */
        @JsonProperty("name")
        private String name;
        /**
         * 	成员所属部门id列表，这个字段只会返回传入的department_id所属的互联企业里的部门id
         */
        @JsonProperty("department")
        private String department;
        /**
         * 	所属企业的corpid
         */
        @JsonProperty("corpid")
        private String corpId;

    }
}
