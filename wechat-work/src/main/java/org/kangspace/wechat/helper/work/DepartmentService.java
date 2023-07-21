package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.work.bean.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * 企业微信"通讯录管理-部门管理"相关 Service
 *
 * @author kango2gler@gmail.com
 * @since 2023/07/21
 */
public interface DepartmentService extends WeComService {
    /**
     * 创建部门
     *
     * @param request {@link DepartmentRequest}
     * @return {@link DepartmentCreateResponse}
     */
    DepartmentCreateResponse departmentCreate(@Nonnull DepartmentRequest request);

    /**
     * 更新部门
     *
     * @param request {@link DepartmentRequest}
     * @return {@link WeComResponseEntity}
     */
    WeComResponseEntity departmentUpdate(@Nonnull DepartmentRequest request);

    /**
     * 删除部门
     *
     * @param departmentId 部门id。（注：不能删除根部门；不能删除含有子部门、成员的部门）
     * @return {@link WeComResponseEntity}
     */
    WeComResponseEntity departmentDelete(@Nonnull Long departmentId);

    /**
     * 获取部门列表 <br>
     * 【重要】从2022年8月15日10点开始，“企业管理后台 - 管理工具 - 通讯录同步”的新增IP将不能再调用此接口，企业可通过「获取部门ID列表」接口获取部门ID列表。查看调整详情。<br>
     *
     * @param departmentId 部门id。获取指定部门及其下的子部门（以及子部门的子部门等等，递归）。 如果不填，默认获取全量组织架构
     * @return {@link DepartmentListResponse}
     */
    DepartmentListResponse departmentList(@Nullable Long departmentId);

    /**
     * 获取子部门ID列表 <br>
     *
     * @param departmentId 部门id。获取指定部门及其下的子部门（以及子部门的子部门等等，递归）。 如果不填，默认获取全量组织架构
     * @return {@link DepartmentSimpleListResponse}
     */
    DepartmentSimpleListResponse departmentSimpleList(@Nullable Long departmentId);

    /**
     * 获取单个部门详情 <br>
     *
     * @param departmentId 部门id。
     * @return {@link DepartmentResponse}
     */
    DepartmentResponse departmentGet(@Nonnull Long departmentId);
}
