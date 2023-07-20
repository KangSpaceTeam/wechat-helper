package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 获取部门成员响应对象
 * <pre>
 * 如:
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/20
 */
@Setter
@Getter
public class UserSimpleListResponse extends WeComResponseEntity {
    /**
     * 成员列表
     */
    @JsonProperty("userlist")
    private List<User> userList;

    @Data
    public static class User {
        /**
         * 成员UserID。对应管理端的帐号
         */
        @JsonProperty("userid")
        private String userId;

        /**
         * 成员名称，代开发自建应用需要管理员授权才返回；<br>
         * 此字段从2019年12月30日起，对新创建第三方应用不再返回真实name，使用userid代替name，2020年6月30日起，对所有历史第三方应用不再返回真实name，使用userid代替name，后续第三方仅通讯录应用可获取，未返回名称的情况需要通过通讯录展示组件来展示名字
         */
        private String name;

        /**
         * 成员所属部门列表。列表项为部门ID，32位整型
         */
        private List<Long> department;

        /**
         * 全局唯一。对于同一个服务商，不同应用获取到企业内同一个成员的open_userid是相同的，最多64个字节。仅第三方应用可获取
         */
        @JsonProperty("open_userid")
        private String openUserId;
    }

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "UserSimpleListResponse{" +
                        "userList=" + userList +
                        "}"
        );
    }
}
