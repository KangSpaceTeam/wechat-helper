package org.kangspace.wechat.helper.work;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.bean.appchat.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;

import java.util.Arrays;
import java.util.Collections;

@Slf4j
@RunWith(JUnit4.class)
public class AppChatServiceTest {

    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private AppChatService appChatService;

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        appChatService = new DefaultAppChatService(weComAccessTokenService);
    }

    @Test
    public void appChatCreate() {
        AppChatCreateRequest request = AppChatCreateRequest.builder()
                .chatId("CHAT1")
                .name("wechat-helper创建群聊")
                .owner("Kang")
                .userList(Arrays.asList("Kang","ran"))
                .build();
        AppChatCreateResponse response = appChatService.appChatCreate(request);
        log.info("response: {}", response);
    }

    @Test
    public void appChatUpdate() {
        AppChatUpdateRequest request = AppChatUpdateRequest.builder()
                .chatId("CHAT1")
                .name("wechat-helper创建群聊?")
                .owner("Kang")
                .delUserList(Collections.singletonList("ran"))
                .build();
        WeComResponseEntity response = appChatService.appChatUpdate(request);
        log.info("response: {}", response);
    }

    @Test
    public void appChatGet() {
        String chatId = "CHAT1";
        AppChatGetResponse response = appChatService.appChatGet(chatId);
        log.info("response: {}", response);
    }

    @Test
    public void appChatSend() {
        String chatId = "CHAT1";
        AppChatMessage message = TextMessage.builder()
                .chatId(chatId)
                .text(TextMessage.Text.builder().content("0123456789").build())
                .build();
        WeComResponseEntity response = appChatService.appChatSend(message);
        log.info("response: {}", response);
    }
}