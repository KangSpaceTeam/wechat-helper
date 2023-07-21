package org.kangspace.wechat.helper.work.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 企业微信"通讯录管理-部门管理-获取部门列表" 响应对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/21
 */
@Setter
@Getter
public class DepartmentListResponse extends WeComResponseEntity {
    /**
     * 部门列表数据。
     */
    private List<Department> department;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "DepartmentListResponse{" +
                        "department=" + department +
                        "}"
        );
    }
}
