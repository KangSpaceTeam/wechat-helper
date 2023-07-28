package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 通讯录管理-互联企业-获取互联企业部门成员详情 用户
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/28
 */
@Data
public class LinkedCorpUser {
    /**
     * 成员UserID。对应管理端的帐号
     */
    @JsonProperty("userid")
    private String userId;
    /**
     * 成员真实名称
     */
    @JsonProperty("name")
    private String name;
    /**
     * 成员所属部门id列表，这个字段只会返回传入的department_id所属的互联企业里的部门id
     */
    @JsonProperty("department")
    private String department;
    /**
     * 所属企业的corpid
     */
    @JsonProperty("corpid")
    private String corpId;

}
