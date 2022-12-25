package org.kangspace.wechat.helper.mp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.event.WeChatMpEventResolver;

/**
 * 微信公众号事件测试
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
@Slf4j
@RunWith(JUnit4.class)
public class WeChatMpEventTest {
    private final String appId = WeChatMpAppConstant.GLOBAL_APPID;
    private final String appSecret = WeChatMpAppConstant.GLOBAL_APPSECRET;
    private WeChatMpEventResolver resolver;

    @Before
    public void before() {
        WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
        WeChatMpService weChatMpService = new DefaultWeChatMpService(weChatMpConfig);
        resolver = new WeChatMpEventResolver(weChatMpService);
    }

    public void eventResolveTest() {
        // TODO xxx
        String message = "";
//        resolver.addWeChatHandler();
//        resolver.resolve();
    }

}
