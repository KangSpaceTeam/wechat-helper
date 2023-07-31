package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

/**
 * <p>
 * 企业微信"安全管理"相关 Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/31
 */
public class DefaultSecurityService extends AbstractWeComService implements SecurityService {

    public DefaultSecurityService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultSecurityService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultSecurityService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }

    @Override
    public SecurityGetFileOperRecordResponse securityGetFileOperRecord(SecurityGetFileOperRecordRequest request) {
        String url = WeComApiPaths.SECURITY_GET_FILE_OPER_RECORD;
        return post(url, request, SecurityGetFileOperRecordResponse.class);
    }

    @Override
    public SecurityTrustDeviceImportResponse securityTrustDeviceImport(SecurityTrustDeviceImportRequest request) {
        String url = WeComApiPaths.SECURITY_TRUST_DEVICE_IMPORT;
        return post(url, request, SecurityTrustDeviceImportResponse.class);
    }

    @Override
    public SecurityTrustDeviceListResponse securityTrustDeviceList(SecurityTrustDeviceListRequest request) {
        String url = WeComApiPaths.SECURITY_TRUST_DEVICE_LIST;
        return post(url, request, SecurityTrustDeviceListResponse.class);
    }

    @Override
    public SecurityTrustDeviceGetByUserResponse securityTrustDeviceGetByUser(SecurityTrustDeviceGetByUserRequest request) {
        String url = WeComApiPaths.SECURITY_TRUST_DEVICE_GET_BY_USER;
        return post(url, request, SecurityTrustDeviceGetByUserResponse.class);
    }

    @Override
    public WeComResponseEntity securityTrustDeviceDelete(SecurityTrustDeviceDeleteRequest request) {
        String url = WeComApiPaths.SECURITY_TRUST_DEVICE_DELETE;
        return post(url, request, WeComResponseEntity.class);
    }

    @Override
    public SecurityTrustDeviceApproveResponse securityTrustDeviceApprove(SecurityTrustDeviceApproveRequest request) {
        String url = WeComApiPaths.SECURITY_TRUST_DEVICE_APPROVE;
        return post(url, request, SecurityTrustDeviceApproveResponse.class);
    }

    @Override
    public SecurityTrustDeviceRejectResponse securityTrustDeviceReject(SecurityTrustDeviceRejectRequest request) {
        String url = WeComApiPaths.SECURITY_TRUST_DEVICE_REJECT;
        return post(url, request, SecurityTrustDeviceRejectResponse.class);
    }
}
