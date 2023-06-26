package org.kangspace.wechat.helper.work;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.work.bean.ServerIpListResponse;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;

/**
 * 企业微信Server相关Service测试类
 *
 * @author kango2gler@gmail.com
 * @since 2023/6/6
 */
@Slf4j
@RunWith(JUnit4.class)
public class WeComServerServiceTest {
    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private WeComServerService mpServerService;

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        mpServerService = new DefaultWeComServerService(weComAccessTokenService);
    }

    /**
     * 获取企业微信 API 接口 IP地址测试
     */
    @Test
    public void getApiDomainIpTest() {
        log.info("获取企业微信 API 接口 IP地址: mpServerService.getApiDomainIp()");
        ServerIpListResponse response = mpServerService.getApiDomainIp();
        Assert.assertNotNull("获取失败!", response);
        log.info("response: {}", response);
    }

    /**
     * 获取企业微信callback IP地址
     */
    @Test
    public void getCallbackIpTest() {
        log.info("获取企业微信callback IP地址: mpServerService.getCallbackIp()");
        ServerIpListResponse response = mpServerService.getCallbackIp();
        Assert.assertNotNull("获取失败!", response);
        log.info("response: {}", response);
    }
    
}
