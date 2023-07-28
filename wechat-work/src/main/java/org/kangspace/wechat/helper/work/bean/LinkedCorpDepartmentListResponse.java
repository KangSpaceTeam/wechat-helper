package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 通讯录管理-互联企业-获取互联企业部门列表 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/27
 */
@Setter
@Getter
public class LinkedCorpDepartmentListResponse extends WeComResponseEntity {
    /**
     * 成员列表
     */
    @JsonProperty("department_list")
    private List<Department> departmentList;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "LinkedCorpDepartmentListResponse{" +
                        "departmentList=" + departmentList +
                        "}"
        );
    }

    @Data
    public static class Department {
        /**
         * 部门id
         */
        @JsonProperty("department_id")
        private String departmentId;

        /**
         * 部门名称
         */
        @JsonProperty("department_name")
        private String departmentName;

        /**
         * 上级部门的id
         */
        @JsonProperty("parentid")
        private Long parentId;

        /**
         * 排序值
         */
        private Integer order;
    }

}
