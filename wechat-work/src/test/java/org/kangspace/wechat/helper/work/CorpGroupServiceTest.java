package org.kangspace.wechat.helper.work;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;

/**
 * 企业微信"企业互联"相关 Service测试
 */
@Slf4j
@RunWith(JUnit4.class)
public class CorpGroupServiceTest {

    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private CorpGroupService corpGroupService;

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        corpGroupService = new DefaultCorpGroupService(weComAccessTokenService);
    }

    @Test
    public void corpGroupCorpListAppShareInfo() {
        CorpGroupCorpListAppShareInfoRequest request = CorpGroupCorpListAppShareInfoRequest.builder().build();
        CorpGroupCorpListAppShareInfoResponse response = corpGroupService.corpGroupCorpListAppShareInfo(request);
        log.info("response: {}", response);
    }

    @Test
    public void corpGroupCorpGetToken() {
        CorpGroupCorpGetTokenRequest request = new CorpGroupCorpGetTokenRequest();
        CorpGroupCorpGetTokenResponse response = corpGroupService.corpGroupCorpGetToken(request);
        log.info("response: {}", response);
    }

    @Test
    public void miniProgramTransferSession() {
        MiniProgramTransferSessionRequest request = new MiniProgramTransferSessionRequest();
        MiniProgramTransferSessionResponse response = corpGroupService.miniProgramTransferSession(request);
        log.info("response: {}", response);
    }
}