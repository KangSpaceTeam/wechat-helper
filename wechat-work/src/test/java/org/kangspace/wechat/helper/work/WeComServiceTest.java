package org.kangspace.wechat.helper.work;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.core.token.AccessTokenResponse;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;

/**
 * 企业微信相关Service测试类
 *
 * @author kango2gler@gmail.com
 * @since 2023/6/22
 */
@Slf4j
@RunWith(JUnit4.class)
public class WeComServiceTest {
    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private DefaultWeComAccessTokenService weComAccessTokenService;

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
    }
    /**
     * 获取AccessToken测试
     */
    @Test
    public void getTokenTest() {
        log.info("weComConfig: {}", weComAccessTokenService.getWeChatConfig());
        AccessTokenResponse response = weComAccessTokenService.token();
        log.info("response: {}", response);
    }
}
