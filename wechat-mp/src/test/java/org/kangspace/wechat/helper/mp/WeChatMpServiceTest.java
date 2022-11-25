package org.kangspace.wechat.helper.mp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.mp.bean.WeChatMpAccessTokenResponse;
import org.kangspace.wechat.helper.mp.bean.WeChatMpServerIpListResponse;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
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
    private WeChatMpServerService mpServerService;
    private DefaultWeChatMpAccessTokenService weChatMpAccessTokenService;

    @Before
    public void before() {
        String appId = "xxx";
        String appSecret = "xx";
        WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret, null);
        weChatMpAccessTokenService = new DefaultWeChatMpAccessTokenService(weChatMpConfig);
        mpServerService = new DefaultWeChatMpServerService(weChatMpConfig, weChatMpAccessTokenService);
    }

    @Test
    public void getTokenTest() {
        log.info("weChatConfig: {}", weChatMpAccessTokenService.getWeChatConfig());
        WeChatMpAccessTokenResponse response = weChatMpAccessTokenService.token();
        log.info("response: {}", response);
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
