package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 企业微信"通讯录管理-部门管理-获取子部门ID列表" 响应对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/21
 */
@Setter
@Getter
public class DepartmentSimpleListResponse extends WeComResponseEntity {
    /**
     * 部门列表数据。
     */
    @JsonProperty("department_id")
    private List<Department> departmentId;

    @Data
    public static class Department {

        /**
         * 创建的部门id
         */
        private Long id;

        /**
         * 父部门id。根部门为1
         */
        @JsonProperty("parentid")
        private Long parentId;

        /**
         * 在父部门中的次序值。order值大的排序靠前。值范围是[0, 2^32)
         */
        private Integer order;
    }


    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "DepartmentSimpleListResponse{" +
                        "departmentId=" + departmentId +
                        "}"
        );
    }
}
