package org.kangspace.wechat.helper.mp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.core.constant.StringLiteral;
import org.kangspace.wechat.helper.mp.bean.WeChatMpAccessTokenRequest;
import org.kangspace.wechat.helper.mp.bean.WeChatMpAccessTokenResponse;
import org.kangspace.wechat.helper.mp.bean.WeChatMpServerIpListResponse;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;
import org.kangspace.wechat.helper.mp.token.DefaultWeChatMpAccessTokenService;

/**
 * 微信公众号相关Service测试类
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@Slf4j
@RunWith(JUnit4.class)
public class WeChatMpServiceTest {
    private final String appId = "";
    private final String appSecret = "";
    private WeChatMpServerService mpServerService;
    private DefaultWeChatMpAccessTokenService weChatMpAccessTokenService;

    @Before
    public void before() {
        WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
        weChatMpAccessTokenService = new DefaultWeChatMpAccessTokenService(weChatMpConfig);
        mpServerService = new DefaultWeChatMpServerService(weChatMpConfig, weChatMpAccessTokenService);
    }

    /**
     * 连接超时重试测试
     */
    @Test
    public void requestExecuteRetryConnectTimeoutTest() {
        String mustConnectTimeoutUrl = "https://google.com";
        String result = mpServerService.get(mustConnectTimeoutUrl, String.class);
        log.info("url: {}", mustConnectTimeoutUrl);
        log.info("result: {}", result);
    }

    /**
     * 502重试设置
     */
    @Test
    public void requestExecuteRetry502Test() {
        String must502Url = "https://kangspace.org/502";
        String result = mpServerService.get(must502Url, String.class, false);
        log.info("url: {}", must502Url);
        log.info("result: {}", result);

    }

    /**
     * 获取AccessToken测试
     */
    @Test
    public void getTokenTest() {
        log.info("weChatConfig: {}", weChatMpAccessTokenService.getWeChatConfig());
        WeChatMpAccessTokenResponse response = weChatMpAccessTokenService.token();
        log.info("response: {}", response);
    }

    /**
     * 业务接口token自动刷新
     */
    @Test
    public void tokenRefreshTest() {
        // 1. 获取token,并缓存
        WeChatMpAccessTokenResponse token = weChatMpAccessTokenService.token();
        log.info("获取token,并缓存: token: {}", token);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
        }
        // 2. http获取新token
        String param = WeChatMpAccessTokenRequest.toQueryString(appId, appSecret);
        String newTokenUrl = WeChatMpApiPaths.TOKEN + StringLiteral.QUESTION_MARK + param;
        String result = mpServerService.get(newTokenUrl, String.class, false);
        log.info("http获取新token: token: {}", result);
        // 3. 旧token失效, 请求业务接口,token自动刷新
        this.getApiDomainIpTest();
    }

    /**
     * 获取微信 API 接口 IP地址测试
     */
    @Test
    public void getApiDomainIpTest() {
        WeChatMpServerIpListResponse response = mpServerService.getApiDomainIp();
        Assert.assertTrue("获取失败!", response != null);
        log.info("response: {}", response);
    }

    /**
     * 获取微信callback IP地址
     */
    @Test
    public void getCallbackIp() {
        WeChatMpServerIpListResponse response = mpServerService.getCallbackIp();
        Assert.assertTrue("获取失败!", response != null);
        log.info("response: {}", response);
    }
}
