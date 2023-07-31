package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.work.bean.*;

/**
 * 企业微信"安全管理"相关 Service <br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/98079">https://developer.work.weixin.qq.com/document/path/98079</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/07/31
 */
public interface SecurityService extends WeComService {
    /**
     * 安全管理-文件防泄漏
     *
     * @param request {@link SecurityGetFileOperRecordRequest}
     * @return {@link SecurityGetFileOperRecordResponse}
     */
    SecurityGetFileOperRecordResponse securityGetFileOperRecord(SecurityGetFileOperRecordRequest request);

    /**
     * 安全管理-设备管理-导入可信企业设备
     *
     * @param request {@link SecurityTrustDeviceImportRequest}
     * @return {@link SecurityTrustDeviceImportResponse}
     */
    SecurityTrustDeviceImportResponse securityTrustDeviceImport(SecurityTrustDeviceImportRequest request);

    /**
     * 安全管理-设备管理-获取设备信息
     *
     * @param request {@link SecurityTrustDeviceListRequest}
     * @return {@link SecurityTrustDeviceListResponse}
     */
    SecurityTrustDeviceListResponse securityTrustDeviceList(SecurityTrustDeviceListRequest request);

    /**
     * 安全管理-设备管理-获取成员使用设备
     *
     * @param request {@link SecurityTrustDeviceGetByUserRequest}
     * @return {@link SecurityTrustDeviceGetByUserResponse}
     */
    SecurityTrustDeviceGetByUserResponse securityTrustDeviceGetByUser(SecurityTrustDeviceGetByUserRequest request);

    /**
     * 安全管理-设备管理-删除设备信息
     *
     * @param request {@link SecurityTrustDeviceDeleteRequest}
     * @return {@link WeComResponseEntity}
     */
    WeComResponseEntity securityTrustDeviceDelete(SecurityTrustDeviceDeleteRequest request);

    /**
     * 安全管理-设备管理-确认为可信设备
     *
     * @param request {@link SecurityTrustDeviceApproveRequest}
     * @return {@link SecurityTrustDeviceApproveResponse}
     */
    SecurityTrustDeviceApproveResponse securityTrustDeviceApprove(SecurityTrustDeviceApproveRequest request);

    /**
     * 安全管理-设备管理-驳回可信设备申请
     *
     * @param request {@link SecurityTrustDeviceRejectRequest}
     * @return {@link SecurityTrustDeviceRejectResponse}
     */
    SecurityTrustDeviceRejectResponse securityTrustDeviceReject(SecurityTrustDeviceRejectRequest request);
}
