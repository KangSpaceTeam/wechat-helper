package org.kangspace.wechat.helper.mp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.mp.bean.OpenApiQuotaGetResponse;
import org.kangspace.wechat.helper.mp.bean.OpenApiRidGetResponse;
import org.kangspace.wechat.helper.mp.bean.WeChatMpResponseEntity;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.token.DefaultWeChatMpAccessTokenService;

/**
 * 微信公众号openApi管理相关Service测试类
 *
 * @author kango2gler@gmail.com
 * @see OpenApiService
 * @since 2022/11/24
 */
@Slf4j
@RunWith(JUnit4.class)
public class OpenApiServiceTest {
    private final String appId = WeChatMpAppConstant.GLOBAL_APPID;
    private final String appSecret = WeChatMpAppConstant.GLOBAL_APPSECRET;
    private OpenApiService mpOpenApiService;

    private String mpAccessToken;

    @Before
    public void before() {
        WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
        DefaultWeChatMpAccessTokenService weChatMpAccessTokenService = new DefaultWeChatMpAccessTokenService(weChatMpConfig);
        mpOpenApiService = new DefaultOpenApiService(weChatMpAccessTokenService);
        mpAccessToken = mpOpenApiService.getToken();
    }

    /**
     * 查询 openAPI 调用quota测试
     */
    @Test
    public void quotaGetTest() {
        log.info("查询 openAPI 调用quota: mpOpenApiService.quotaGet(accessToken, cgiPath)");
        String accessToken = mpAccessToken;
        String cgiPath = "/cgi-bin/token";
        OpenApiQuotaGetResponse response = mpOpenApiService.quotaGet(accessToken, cgiPath);
        Assert.assertNotNull("获取失败!", response);
        log.info("response: {}", response);
    }

    /**
     * 查询 openAPI 调用quota测试
     */
    @Test
    public void clearQuotaTest() {
        log.info("查询 openAPI 调用quota: mpOpenApiService.clearQuota(accessToken, appId)");
        String accessToken = mpAccessToken;
        WeChatMpResponseEntity response = mpOpenApiService.clearQuota(accessToken, appId);
        Assert.assertNotNull("获取失败!", response);
        log.info("response: {}", response);
    }

    /**
     * 查询rid信息
     */
    @Test
    public void ridGetTest() {
        log.info("查询rid信息: mpOpenApiService.ridGet(accessToken, rid)");
        String accessToken = mpAccessToken;
        String rid = "63c24769-6dbc4593-0b1155b6";
        OpenApiRidGetResponse response = mpOpenApiService.ridGet(accessToken, rid);
        Assert.assertNotNull("获取失败!", response);
        log.info("response: {}", response);
    }
}
