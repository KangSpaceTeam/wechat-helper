package org.kangspace.wechat.helper.mp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.token.DefaultWeChatMpAccessTokenService;

/**
 * 微信公众号素材管理相关Service测试类
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/17
 */
@Slf4j
@RunWith(JUnit4.class)
public class WeChatMpAssertServiceTest {
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
    // TODO 待测试
}
