package org.kangspace.wechat.helper.mp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.core.constant.WeChatLang;
import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.WebAppConstant;
import org.kangspace.wechat.helper.mp.token.DefaultWeChatMpAccessTokenService;

import java.util.Date;

/**
 * 微信公众号"网页开发"相关Service测试类
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/11 17:18:54
 */
@Slf4j
@RunWith(JUnit4.class)
public class WebAppsServiceTest {
    private final String appId = WeChatMpAppConstant.GLOBAL_APPID;
    private final String appSecret = WeChatMpAppConstant.GLOBAL_APPSECRET;
    private WebAppsService webAppsService;
    private DefaultWeChatMpAccessTokenService weChatMpAccessTokenService;

    @Before
    public void before() {
        WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
        weChatMpAccessTokenService = new DefaultWeChatMpAccessTokenService(weChatMpConfig);
        webAppsService = new DefaultWebAppsService(weChatMpConfig, weChatMpAccessTokenService);
    }

    /**
     * 生成网页授权地址
     */
    @Test
    public void authorizeUrlTest() {
        String redirectUrl = "https://kangspace.org";
        String state = "0124";
        String url = webAppsService.authorizeUrl(appId, redirectUrl, WebAppConstant.Scope.SNS_API_USERINFO, state, false);
        log.info("url :{}", url);
    }


    /**
     * 获取AccessToken<br>
     * 如: https://kangspace.org/?code=031Nw80w3T7Z503S7t3w3GRVeu4Nw80I&state=0124
     */
    @Test
    public void accessTokenTest() {
        String code = "031Nw80w3T7Z503S7t3w3GRVeu4Nw80I";
        WebAppsAccessTokenResponse accessTokenResponse = webAppsService.accessToken(appId, appSecret, code);
        log.info("response: {}", accessTokenResponse);
    }

    /**
     * 刷新token <br>
     * accessToken='65__iCTSQNeKvo2zPq9EgIF6EnNq4o9kD6e0k1Ncc1oLxeAbWuffOmRTER7ZoISEncuNQhyuq3B8_niODGKo_BiXoVF329XlSxQ8BPkXdokPDs', expiresIn=7200, refreshToken='65_OAWQmsBDJ76OW3uyUtoGogKYxGEXmwSW1hNJsO3B3sEFf8wP8o85UTIo0bKH7tbO96di05rfwCTbj_siz_ywupUKC0secxQzc5s3YBjX9cM', openId='oOIaHt5IOo6rI8BH8IOiG3lA0yHU', scope=snsapi_userinfo, isSnapshotUser='null', unionId='null'}
     */
    @Test
    public void refreshTokenTest() {
        String refreshToken = "65_OAWQmsBDJ76OW3uyUtoGogKYxGEXmwSW1hNJsO3B3sEFf8wP8o85UTIo0bKH7tbO96di05rfwCTbj_siz_ywupUKC0secxQzc5s3YBjX9cM";
        WebAppsRefreshTokenResponse refreshTokenResponse = webAppsService.refreshToken(appId, refreshToken);
        log.info("response: {}", refreshTokenResponse);
    }

    /**
     * 检验授权凭证（access_token）是否有效<br>
     * accessToken='65__iCTSQNeKvo2zPq9EgIF6EnNq4o9kD6e0k1Ncc1oLxeAbWuffOmRTER7ZoISEncuNQhyuq3B8_niODGKo_BiXoVF329XlSxQ8BPkXdokPDs', expiresIn=7200, refreshToken='65_OAWQmsBDJ76OW3uyUtoGogKYxGEXmwSW1hNJsO3B3sEFf8wP8o85UTIo0bKH7tbO96di05rfwCTbj_siz_ywupUKC0secxQzc5s3YBjX9cM', openId='oOIaHt5IOo6rI8BH8IOiG3lA0yHU', scope=snsapi_userinfo
     */
    @Test
    public void authTest() {
        String accessToken = "65__iCTSQNeKvo2zPq9EgIF6EnNq4o9kD6e0k1Ncc1oLxeAbWuffOmRTER7ZoISEncuNQhyuq3B8_niODGKo_BiXoVF329XlSxQ8BPkXdokPDs";
        String openId = "oOIaHt5IOo6rI8BH8IOiG3lA0yHU";
        WeChatMpResponseEntity responseEntity = webAppsService.auth(accessToken, openId);
        log.info("response: {}", responseEntity);
    }

    @Test
    public void userInfoTest() {
        String accessToken = "65__iCTSQNeKvo2zPq9EgIF6EnNq4o9kD6e0k1Ncc1oLxeAbWuffOmRTER7ZoISEncuNQhyuq3B8_niODGKo_BiXoVF329XlSxQ8BPkXdokPDs";
        String openId = "oOIaHt5IOo6rI8BH8IOiG3lA0yHU";
        WebAppsUserInfoResponse userInfoResponse = webAppsService.userInfo(accessToken, openId, WeChatLang.ZH_CN);
        log.info("response: {}", userInfoResponse);
    }

    @Test
    public void jsApiTicketTest() {
        WebAppsJsApiTicketResponse apiTicketResponse = webAppsService.jsApiTicket();
        log.info("response: {}", apiTicketResponse);
    }

    @Test
    public void jsApiSignTest() {
        String jsApiTicket = "sM4AOVdWfPE4DxkXGEs8VA-FcsQji1pMr0wfXhvHm_-kjq7aTjsaZa-5vR8LKUGr9mVp4LJpqRI-kr1LtKXWcg",
                url = "https://kangspace.org",
                nonceStr = "1234";
        String timestamp = new Date().getTime() / 1000 + "";
        WebAppsJsApiSignResponse signResponse = webAppsService.jsApiSign(jsApiTicket, url, nonceStr, timestamp);
        log.info("response: {}", signResponse);
    }
}
