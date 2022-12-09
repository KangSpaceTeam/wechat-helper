package org.kangspace.wechat.helper.mp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.mp.bean.CallbackCheckRequest;
import org.kangspace.wechat.helper.mp.bean.CallbackCheckResponse;
import org.kangspace.wechat.helper.mp.bean.MpServerIpListResponse;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.token.DefaultWeChatMpAccessTokenService;

/**
 * 微信公众号Server相关Service测试类
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@Slf4j
@RunWith(JUnit4.class)
public class WeChatMpServerTest {
    private final String appId = WeChatMpAppConstant.GLOBAL_APPID;
    private final String appSecret = WeChatMpAppConstant.GLOBAL_APPSECRET;
    private WeChatMpServerService mpServerService;
    private DefaultWeChatMpAccessTokenService weChatMpAccessTokenService;

    @Before
    public void before() {
        WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
        weChatMpAccessTokenService = new DefaultWeChatMpAccessTokenService(weChatMpConfig);
        mpServerService = new DefaultWeChatMpServerService(weChatMpConfig, weChatMpAccessTokenService);
    }

    /**
     * 获取微信 API 接口 IP地址测试
     */
    @Test
    public void getApiDomainIpTest() {
        log.info("获取微信 API 接口 IP地址: mpServerService.getApiDomainIp()");
        MpServerIpListResponse response = mpServerService.getApiDomainIp();
        Assert.assertTrue("获取失败!", response != null);
        log.info("response: {}", response);
    }

    /**
     * 获取微信callback IP地址
     */
    @Test
    public void getCallbackIpTest() {
        log.info("获取微信callback IP地址: mpServerService.getCallbackIp()");
        MpServerIpListResponse response = mpServerService.getCallbackIp();
        Assert.assertTrue("获取失败!", response != null);
        log.info("response: {}", response);
    }


    /**
     * 网络检测
     */
    @Test
    public void callbackCheckTest() {
        log.info("网络检测: mpServerService.callbackCheck()");
        CallbackCheckRequest param = new CallbackCheckRequest(CallbackCheckRequest.Action.ALL, CallbackCheckRequest.CheckOperator.DEFAULT);
        CallbackCheckResponse response = mpServerService.callbackCheck(param);
        Assert.assertTrue("获取失败!", response != null);
        log.info("response: {}", response);
    }
}
