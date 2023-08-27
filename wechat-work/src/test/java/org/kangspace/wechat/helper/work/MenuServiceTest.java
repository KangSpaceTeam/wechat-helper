package org.kangspace.wechat.helper.work;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.bean.menu.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 业微信"应用管理-自定义菜单"相关 Service测试
 */
@Slf4j
@RunWith(JUnit4.class)
public class MenuServiceTest {

    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private MenuService menuService;

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        menuService = new DefaultMenuService(weComAccessTokenService);
    }


    @Test
    public void menuCreate() {
        Integer agentId = 1000004;
        List<MenuButton> buttonList = new ArrayList<>();
        buttonList.add(MenuButton.builder()
                .name("KangSpace")
                .subButton(Arrays.asList(ViewMenuButton.builder()
                                .name("主页")
                                .key("MAIN_HOME")
                                .url("https://kangspace.org").build(),
                        ClickMenuButton.builder()
                                .name("Click按钮")
                                .key("MAIN_HOME").build()))
                .build());
        buttonList.add(MenuButton.builder()
                .name("扫码")
                .subButton(Arrays.asList(ScanCodePushButton.builder()
                                .name("扫码推事件scancode_push")
                                .key("scancode_push").build(),
                        ScanCodeWaitMsgButton.builder()
                                .name("扫码推事件弹出消息接收中")
                                .key("scancode_waitmsg").build()))
                .build());
        MenuCreateRequest request = MenuCreateRequest.builder()
                .button(buttonList)
                .build();
        WeComResponseEntity response = menuService.menuCreate(agentId, request);
        log.info("response: {}", response);
    }

    @Test
    public void menuGet() {
        Integer agentId = 1000004;
        WeComResponseEntity response = menuService.menuGet(agentId);
        log.info("response: {}", response);
    }

    @Test
    public void menuDelete() {
        Integer agentId = 1000004;
        WeComResponseEntity response = menuService.menuDelete(agentId);
        log.info("response: {}", response);
    }
}