package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 通讯录管理-互联企业-获取互联企业成员详细信息 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/27
 */
@Setter
@Getter
public class LinkedCorpUserGetResponse extends WeComResponseEntity {
    /**
     * 成员的详细信息，user包含的属性可在管理端配置
     */
    @JsonProperty("user_info")
    private UserInfo userInfo;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "LinkedCorpUserGetResponse{" +
                        "userInfo=" + userInfo +
                        "}"
        );
    }

    @Data
    public static class UserInfo {
        /**
         * 成员UserID。对应管理端的帐号，企业内必须唯一。不区分大小写，长度为1~64个字节
         */
        @JsonProperty("userid")
        private String userId;
        /**
         * 成员真实名称
         */
        @JsonProperty("name")
        private String name;
        /**
         * 手机号码
         */
        @JsonProperty("mobile")
        private String mobile;
        /**
         * 成员所属部门id列表，这个字段会返回在应用可见范围内，该用户所在的所有互联企业的部门
         */
        @JsonProperty("department")
        private List<String> department;
        /**
         * 职务信息
         */
        @JsonProperty("position")
        private String position;
        /**
         * 邮箱
         */
        @JsonProperty("email")
        private String email;
        /**
         * 座机
         */
        @JsonProperty("telephone")
        private String telephone;
        /**
         * 所属企业的corpid
         */
        @JsonProperty("corpid")
        private String corpId;
        /**
         * 扩展属性
         */
        @JsonProperty("extattr")
        private ExtAttr extattr;
    }
}
