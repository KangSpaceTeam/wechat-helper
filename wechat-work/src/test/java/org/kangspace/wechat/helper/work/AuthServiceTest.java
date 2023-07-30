package org.kangspace.wechat.helper.work;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.work.bean.AuthGetUserDetailRequest;
import org.kangspace.wechat.helper.work.bean.AuthGetUserDetailResponse;
import org.kangspace.wechat.helper.work.bean.AuthGetUserInfoResponse;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.Scope;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;


/**
 * 企业微信"身份验证"相关 Service测试
 */
@Slf4j
@RunWith(JUnit4.class)
public class AuthServiceTest {

    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private AuthService authService;

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        authService = new DefaultAuthService(weComAccessTokenService);
    }


    @Test
    public void connectOAuth2Authorize() {
        String appId = corpId;
        String redirectUri = "https://kangspace.org";
//        String scope = Scope.SNSAPI_BASE.getScope();
        String scope = Scope.SNSAPI_PRIVATE_INFO.getScope();
        String state = "a1234";
        String agentId = "1000004";
        String response = authService.connectOAuth2Authorize(appId, redirectUri, scope, state, agentId);
        log.info("response: {}", response);
    }

    @Test
    public void authGetUserInfo() {
        String code = "edpqUqlAafALg50YWEtDNfSiHy4ieuMFO3Vl-z1m6po";
        AuthGetUserInfoResponse response = authService.authGetUserInfo(code);
        log.info("response: {}", response);
    }

    @Test
    public void authGetUserDetail() {
        String userTicket = "XNCAPCUdHamELF0ZVz5RYZDuUFORdC2Kio7Mk22v8sTCWrO2UpnTjTioIA_MPH5sO5kNokVSrpGLXzQcudVCSMTGC_ch1N2cfFiP-xXjI9g";
        AuthGetUserDetailRequest request = new AuthGetUserDetailRequest(userTicket);
        AuthGetUserDetailResponse response = authService.authGetUserDetail(request);
        log.info("response: {}", response);
    }
}