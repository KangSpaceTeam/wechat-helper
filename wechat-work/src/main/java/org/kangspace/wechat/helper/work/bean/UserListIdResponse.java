package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 获取成员ID列表 响应对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/20
 */
@Setter
@Getter
public class UserListIdResponse extends WeComResponseEntity {
    /**
     * 分页游标，下次请求时填写以获取之后分页的记录。如果该字段返回空则表示已没有更多数据
     */
    @JsonProperty("next_cursor")
    private String nextCursor;

    /**
     * 用户-部门关系列表
     */
    @JsonProperty("dept_user")
    private List<DeptUser> deptUser;

    @Data
    public static class DeptUser{
        /**
         * 用户userid，当用户在多个部门下时会有多条记录
         */
        @JsonProperty("userid")
        private String userId;

        /**
         * 用户所属部门
         */
        private Long department;
    }

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "UserListIdResponse{" +
                        "nextCursor='" + nextCursor + '\'' +
                        ", deptUser=" + deptUser +
                        "}"
        );
    }
}
