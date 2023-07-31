package org.kangspace.wechat.helper.work;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;

/**
 * 企业微信"安全管理"相关 Service测试
 */
@Slf4j
@RunWith(JUnit4.class)
public class SecurityServiceTest {

    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private SecurityService securityService;

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        securityService = new DefaultSecurityService(weComAccessTokenService);
    }

    @Test
    public void securityGetFileOperRecord() {
        SecurityGetFileOperRecordRequest request = SecurityGetFileOperRecordRequest.builder().build();
        WeComResponseEntity response = securityService.securityGetFileOperRecord(request);
        log.info("response: {}", response);
    }

    @Test
    public void securityTrustDeviceImport() {
        SecurityTrustDeviceImportRequest request = SecurityTrustDeviceImportRequest.builder().build();
        SecurityTrustDeviceImportResponse response = securityService.securityTrustDeviceImport(request);
        log.info("response: {}", response);
    }

    @Test
    public void securityTrustDeviceList() {
        SecurityTrustDeviceListRequest request = SecurityTrustDeviceListRequest.builder().build();
        SecurityTrustDeviceListResponse response = securityService.securityTrustDeviceList(request);
        log.info("response: {}", response);
    }

    @Test
    public void securityTrustDeviceGetByUser() {
        SecurityTrustDeviceGetByUserRequest request = SecurityTrustDeviceGetByUserRequest.builder().build();
        SecurityTrustDeviceGetByUserResponse response = securityService.securityTrustDeviceGetByUser(request);
        log.info("response: {}", response);
    }

    @Test
    public void securityTrustDeviceDelete() {
        SecurityTrustDeviceDeleteRequest request = SecurityTrustDeviceDeleteRequest.builder().build();
        WeComResponseEntity response = securityService.securityTrustDeviceDelete(request);
        log.info("response: {}", response);
    }

    @Test
    public void securityTrustDeviceApprove() {
        SecurityTrustDeviceApproveRequest request = SecurityTrustDeviceApproveRequest.builder().build();
        SecurityTrustDeviceApproveResponse response = securityService.securityTrustDeviceApprove(request);
        log.info("response: {}", response);
    }

    @Test
    public void securityTrustDeviceReject() {
        SecurityTrustDeviceRejectRequest request = SecurityTrustDeviceRejectRequest.builder().build();
        SecurityTrustDeviceRejectResponse response = securityService.securityTrustDeviceReject(request);
        log.info("response: {}", response);
    }
}