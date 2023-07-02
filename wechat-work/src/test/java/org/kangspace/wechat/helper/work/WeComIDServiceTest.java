package org.kangspace.wechat.helper.work;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;

/**
 * 企业微信"帐号ID"相关Service测试类
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/2
 */
@Slf4j
@RunWith(JUnit4.class)
public class WeComIDServiceTest {
    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private WeComIDService weComIDService;

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        weComIDService = new DefaultWeComIDService(weComAccessTokenService);
    }

    /**
     * 帐号ID 接口-自建应用与第三方应用的对接-userid转换 测试
     */
    @Test
    public void batchOpenUserIdToUserIdTest() {
        BatchOpenUserIdToUserIdRequest request = new BatchOpenUserIdToUserIdRequest();
        BatchOpenUserIdToUserIdResponse response = weComIDService.batchOpenUserIdToUserId(request);
        Assert.assertNotNull("获取失败!", response);
        log.info("response: {}", response);
    }

    /**
     * 帐号ID 接口-自建应用与第三方应用的对接-userid转换测试
     */
    @Test
    public void externalContactFromServiceExternalUserIdTest() {
        FromServiceExternalUserIdRequest request = new FromServiceExternalUserIdRequest();
        FromServiceExternalUserIdResponse response = weComIDService.externalContactFromServiceExternalUserId(request);
        Assert.assertNotNull("获取失败!", response);
        log.info("response: {}", response);
    }

    /**
     * 帐号ID 接口-tmp_external_userid的转换测试
     */
    @Test
    public void idConvertConvertTmpExternalUserIdTest() {
        ConvertTmpExternalUserIdRequest request = new ConvertTmpExternalUserIdRequest();
        ConvertTmpExternalUserIdResponse response = weComIDService.idConvertConvertTmpExternalUserId(request);
        Assert.assertNotNull("获取失败!", response);
        log.info("response: {}", response);
    }


}
