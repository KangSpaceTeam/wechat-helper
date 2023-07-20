package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 获取部门成员响应对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/20
 */
@Setter
@Getter
public class UserListResponse extends WeComResponseEntity {
    /**
     * 成员列表
     */
    @JsonProperty("userlist")
    private List<User> userList;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "UserListResponse{" +
                        "userList=" + userList +
                        "}"
        );
    }
}
