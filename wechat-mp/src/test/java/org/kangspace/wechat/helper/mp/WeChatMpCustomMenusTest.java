package org.kangspace.wechat.helper.mp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.CustomMenuConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 微信公众号"自定义菜单"相关Service测试
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/10
 */
@Slf4j
@RunWith(JUnit4.class)
public class WeChatMpCustomMenusTest {

    private final String appId = WeChatMpAppConstant.GLOBAL_APPID;
    private final String appSecret = WeChatMpAppConstant.GLOBAL_APPSECRET;

    private WeChatMpCustomMenusService customMenusService;

    @Before
    public void before() {
        WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
        customMenusService = new DefaultWeChatCustomMenusService(weChatMpConfig);
    }

    /**
     * 创建菜单测试<br>
     * 如:
     * <pre>
     * - API菜单
     *   - KangSpace (https://kangspace.org)
     * - 赞👍🏻
     * </pre>
     * JSON:
     * <pre>
     * {"is_menu_open":1,"selfmenu_info":{"button":[{"name":"API菜单","sub_button":{"list":[{"type":"view","name":"KangSpace","url":"https:\/\/kangspace.org"}]}},{"type":"click","name":"赞👍🏻","key":"API_MENU_P_2"}]}}
     * </pre>
     */
    @Test
    public void menuCreateTest() {
        MenuCreateRequest request = new MenuCreateRequest();
        List<MenuCreateRequest.Button> buttonList = new ArrayList<>();
        MenuCreateRequest.Button button = MenuCreateRequest.Button.builder().name("API菜单").key("API_MENU_P_1").subButton(
                Arrays.asList(MenuCreateRequest.Button.builder().name("KangSpace").type(CustomMenuConstant.ButtonType.VIEW).url("https://kangspace.org").key("API_MENU_P_1_C_1").build())
        ).build();
        MenuCreateRequest.Button button2 = MenuCreateRequest.Button.builder().type(CustomMenuConstant.ButtonType.CLICK).name("赞👍🏻").key("API_MENU_P_2").build();
        buttonList.add(button);
        buttonList.add(button2);
        request.setButton(buttonList);
        WeChatMpResponseEntity response = customMenusService.menuCreate(request);
        log.info("response: {}", response);
    }

    /**
     * 获取自定义菜单配置测试
     */
    @Test
    public void menuGetTest() {
        MenuGetResponse response = customMenusService.menuGet();
        log.info("response: {}", response);
    }

    /**
     * 删除自定义菜单配置测试
     */
    @Test
    public void menuDeleteTest() {
        WeChatMpResponseEntity response = customMenusService.menuDelete();
        log.info("response: {}", response);
    }

    /**
     * 查询自定义菜单的配置接口测试
     */
    @Test
    public void getCurrentSelfMenuInfoTest() {
        CurrentSelfMenuInfoResponse response = customMenusService.getCurrentSelfMenuInfo();
        log.info("response: {}", response);
    }

    /**
     * 创建个性化菜单测试<br>
     * 如:
     * <pre>
     * - 标签菜单
     *  - KangSpace (https://kangspace.org)
     * </pre>
     * JSON:
     * <pre>
     *    {"button":[{"type":"text","name":"标签菜单","key":"TAG_API_MENU_P_1","sub_button":[{"type":"view","name":"KangSpace","key":"TAG_API_MENU_P_1_C_1","url":"https://kangspace.org"}]}],"matchrule":{"tag_id":"100"}}
     * </pre>
     */
    @Test
    public void menuAddConditionalTest() {
        MenuAddConditionalRequest request = new MenuAddConditionalRequest();
        List<MenuCreateRequest.Button> buttonList = new ArrayList<>();
        MenuCreateRequest.Button button = MenuCreateRequest.Button.builder().name("标签菜单").type(CustomMenuConstant.ButtonType.TEXT).key("TAG_API_MENU_P_1").subButton(
                Arrays.asList(MenuCreateRequest.Button.builder().name("KangSpace").type(CustomMenuConstant.ButtonType.VIEW).url("https://kangspace.org").key("TAG_API_MENU_P_1_C_1").build())
        ).build();
        buttonList.add(button);
        request.setButton(buttonList);
        request.setMatchRule(new MenuMatchRule("100"));
        MenuAddConditionalResponse response = customMenusService.menuAddConditional(request);
        log.info("response: {}", response);
    }

    /**
     * 删除个性化菜单测试
     * menuId: 434408580
     */
    @Test
    public void menuDelConditionalTest() {
        MenuDelConditionalRequest request = new MenuDelConditionalRequest("434408580");
        WeChatMpResponseEntity response = customMenusService.menuDelConditional(request);
        log.info("response: {}", response);
    }

    /**
     * 测试个性化菜单匹配结果测试
     */
    @Test
    public void menuTryMatchTest() {
        MenuTryMatchRequest request = new MenuTryMatchRequest("oOIaHt5IOo6rI8BH8IOiG3lA0yHU");
        MenuTryMatchResponse response = customMenusService.menuTryMatch(request);
        log.info("response: {}", response);
    }
}
