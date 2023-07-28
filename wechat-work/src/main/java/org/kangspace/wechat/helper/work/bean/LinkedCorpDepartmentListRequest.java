package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;

/**
 * 通讯录管理-互联企业-获取互联企业部门列表 请求对象<br>
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/27
 */
@Data
@Builder
public class LinkedCorpDepartmentListRequest {
    /**
     * 该字段用的是互联应用可见范围接口返回的department_ids参数，用的是 linkedid + ’/‘ + department_id 拼成的字符串
     */
    @Nonnull
    @JsonProperty("department_id")
    private String departmentId;

    public LinkedCorpDepartmentListRequest(@Nonnull String departmentId) {
        this.departmentId = departmentId;
    }

    public LinkedCorpDepartmentListRequest() {
    }
}
