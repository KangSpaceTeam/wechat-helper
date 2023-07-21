package org.kangspace.wechat.helper.work.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * 企业微信"通讯录管理-部门管理-部门" 响应对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/21
 */
@Setter
@Getter
public class DepartmentCreateResponse extends WeComResponseEntity {
    /**
     * 创建的部门id
     */
    private Long id;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "DepartmentCreateResponse{" +
                        "id=" + id +
                        "}"
        );
    }
}
