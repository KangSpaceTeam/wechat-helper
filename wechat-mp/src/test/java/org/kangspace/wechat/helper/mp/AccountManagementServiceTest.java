package org.kangspace.wechat.helper.mp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.QrcodeActionName;
import org.kangspace.wechat.helper.mp.token.DefaultWeChatMpAccessTokenService;

/**
 * 微信公众号"账号管理"相关Service
 */
@Slf4j
@RunWith(JUnit4.class)
public class AccountManagementServiceTest {
    private final String appId = WeChatMpAppConstant.GLOBAL_APPID;
    private final String appSecret = WeChatMpAppConstant.GLOBAL_APPSECRET;
    private AccountManagementService accountManagementService;

    @Before
    public void before() {
        WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
        DefaultWeChatMpAccessTokenService weChatMpAccessTokenService = new DefaultWeChatMpAccessTokenService(weChatMpConfig);
        accountManagementService = new DefaultAccountManagementService(weChatMpAccessTokenService);
    }

    @Test
    public void qrcodeCreate() {
        QrcodeCreateRequest request = new QrcodeCreateRequest(6000L, QrcodeActionName.QR_SCENE,
                new QrcodeCreateRequest.ActionInfo(new QrcodeCreateRequest.Scene(123)));
        QrcodeCreateResponse response = accountManagementService.qrcodeCreate(request);
        log.info("{}", response);
    }

    @Test
    public void showQrcode() {
        String ticket = "gQH57zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyczBEQXgyVTZhN1QxdGpKTmhBMVIAAgTj1XFkAwRwFwAA";
        MediaGetResponse response = accountManagementService.showQrcode(ticket);
        log.info("{}", response);
    }

    @Test
    public void shortenGen() {
        ShortenGenRequest request = new ShortenGenRequest("1234567890abcdefghigklmnopqrstuvwxyz", 1000L);
        ShortenGenResponse response = accountManagementService.shortenGen(request);
        log.info("{}", response);
    }

    @Test
    public void shortenFetch() {
        String shortKey = "VVdfNKM41m221tG";
        ShortenFetchRequest request = new ShortenFetchRequest(shortKey);
        ShortenFetchResponse response = accountManagementService.shortenFetch(request);
        log.info("{}", response);
    }
}