package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
public class TagUserResponse extends WeComResponseEntity {
    /**
     * 标签名
     */
    @JsonProperty("tagname")
    private String tagName;

    /**
     * 标签中包含的成员列表
     */
    @JsonProperty("userlist")
    private List<User> userList;

    /**
     * 标签中包含的部门id列表
     */
    @JsonProperty("partylist")
    private List<Long> partyList;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "TagUserResponse{" +
                        "tagName='" + tagName + '\'' +
                        ", userList=" + userList +
                        ", partyList=" + partyList +
                        "}"
        );
    }

    @Data
    public static class User {
        /**
         * 成员帐号
         */
        private String userid;

        /**
         * 成员名称，代开发自建应用需要管理员授权才返回该字段；<br>
         * 此字段从2019年12月30日起，对新创建第三方应用不再返回，2020年6月30日起，对所有历史第三方应用不再返回，后续第三方仅通讯录应用可获取，未返回名称的情况需要通过通讯录展示组件来展示名字
         */
        private String name;
    }
}
