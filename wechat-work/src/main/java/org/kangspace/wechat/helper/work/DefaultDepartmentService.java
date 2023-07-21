package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * <p>
 * 企业微信"通讯录管理-部门管理"相关 Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/21
 */
public class DefaultDepartmentService extends AbstractWeComService implements DepartmentService {

    public DefaultDepartmentService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultDepartmentService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultDepartmentService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }

    @Override
    public DepartmentCreateResponse departmentCreate(@Nonnull DepartmentRequest request) {
        String url = WeComApiPaths.DEPARTMENT_CREATE;
        return post(url, request, DepartmentCreateResponse.class);
    }

    @Override
    public WeComResponseEntity departmentUpdate(@Nonnull DepartmentRequest request) {
        String url = WeComApiPaths.DEPARTMENT_UPDATE;
        return post(url, request, WeComResponseEntity.class);
    }

    @Override
    public WeComResponseEntity departmentDelete(@Nonnull Long departmentId) {
        String url = urlTransfer(WeComApiPaths.DEPARTMENT_DELETE, departmentId.toString());
        return get(url, WeComResponseEntity.class);
    }

    @Override
    public DepartmentListResponse departmentList(@Nullable Long departmentId) {
        String url = urlTransfer(WeComApiPaths.DEPARTMENT_LIST, departmentId != null ? departmentId.toString() : null);
        return get(url, DepartmentListResponse.class);
    }

    @Override
    public DepartmentSimpleListResponse departmentSimpleList(@Nullable Long departmentId) {
        String url = urlTransfer(WeComApiPaths.DEPARTMENT_SIMPLE_LIST, departmentId != null ? departmentId.toString() : null);
        return get(url, DepartmentSimpleListResponse.class);
    }

    @Override
    public DepartmentResponse departmentGet(@Nonnull Long departmentId) {
        String url = urlTransfer(WeComApiPaths.DEPARTMENT_GET, departmentId.toString());
        return get(url, DepartmentResponse.class);
    }
}
