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
import java.util.Collections;
import java.util.List;

/**
 * 微信公众号"自定义菜单"相关Service测试
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/10
 */
@Slf4j
@RunWith(JUnit4.class)
public class CustomMenusServiceTest {

    private final String appId = WeChatMpAppConstant.GLOBAL_APPID;
    private final String appSecret = WeChatMpAppConstant.GLOBAL_APPSECRET;

    private CustomMenusService customMenusService;

    @Before
    public void before() {
        WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
        customMenusService = new DefaultCustomMenusService(weChatMpConfig);
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
        MenuCreateRequest.Button button = MenuCreateRequest.Button.builder().name("API菜单").type(CustomMenuConstant.ButtonType.TEXT).key("API_MENU_P_1").subButton(
                Collections.singletonList(MenuCreateRequest.Button.builder().name("KangSpace").type(CustomMenuConstant.ButtonType.VIEW).url("https://kangspace.org").key("API_MENU_P_1_C_1").build())
        ).build();
        MenuCreateRequest.Button button2 = MenuCreateRequest.Button.builder().type(CustomMenuConstant.ButtonType.CLICK).name("赞👍🏻").key("API_MENU_P_2").build();
        buttonList.add(button);
        buttonList.add(button2);
        request.setButton(buttonList);
        WeChatMpResponseEntity response = customMenusService.menuCreate(request);
        log.info("response: {}", response);
    }

    /**
     * 事件相关菜单测试
     */
    @Test
    public void menuCreateWithEventTest() {
        MenuCreateRequest request = new MenuCreateRequest();
        List<MenuCreateRequest.Button> buttonList = new ArrayList<>();
        MenuCreateRequest.Button normalBtn = MenuCreateRequest.Button.builder()
                .type(CustomMenuConstant.ButtonType.VIEW).key("API_MENU:KANG_SPACE_LINK_BTN").url("https://kangsapce.org").name("KangSpace").build();
        MenuCreateRequest.Button eventBtn = MenuCreateRequest.Button.builder()
                .type(CustomMenuConstant.ButtonType.TEXT).key("API_MENU:EVENT_BTN_GROUP").name("\uD83C\uDF87事件组1").subButton(Arrays.asList(
                        // CLICK (点击拉取消息)
                        MenuCreateRequest.Button.builder().name("\uD83C\uDFB2拉取消息").type(CustomMenuConstant.ButtonType.CLICK).key("API_MENU:CLICK_BTN").build(),
                        // 链接
                        MenuCreateRequest.Button.builder().name("\uD83D\uDD17链接(view)").type(CustomMenuConstant.ButtonType.VIEW).url("https://kangspace.org").key("API_MENU:LINK_BTN").build(),
                        // 扫码推事件
                        MenuCreateRequest.Button.builder().name("\uD83C\uDF88扫码推事件").type(CustomMenuConstant.ButtonType.SCANCODE_PUSH).key("API_MENU:SCANCODE_PUSH_BTN").build(),
                        // 扫码推事件且弹出“消息接收中”
                        MenuCreateRequest.Button.builder().name("\uD83D\uDCE8扫码带提示").type(CustomMenuConstant.ButtonType.SCANCODE_WAITMSG).key("API_MENU:SCANCODE_WAITMSG_BTN").build(),
                        // 弹出地理位置选择器
                        MenuCreateRequest.Button.builder().name("\uD83D\uDDFA发送位置").type(CustomMenuConstant.ButtonType.LOCATION_SELECT).key("API_MENU:LOCATION_SELECT_BTN").build()


                )).build();
        MenuCreateRequest.Button eventBtn2 = MenuCreateRequest.Button.builder()
                .type(CustomMenuConstant.ButtonType.TEXT).key("API_MENU:EVENT_BTN_GROUP").name("\uD83C\uDF87事件组2").subButton(Arrays.asList(
                        // 系统拍照发图
                        MenuCreateRequest.Button.builder().name("\uD83C\uDF05系统拍照发图").type(CustomMenuConstant.ButtonType.PIC_SYSPHOTO).key("API_MENU:PIC_SYSPHOTO_BTN").build(),
                        // 弹出拍照或者相册发图
                        MenuCreateRequest.Button.builder().name("\uD83C\uDF05拍照或者相册发图").type(CustomMenuConstant.ButtonType.PIC_PHOTO_OR_ALBUM).key("API_MENU:PIC_SYSPHOTO_BTN").build(),
                        // 弹出微信相册发图器
                        MenuCreateRequest.Button.builder().name("\uD83C\uDF05微信相册发图").type(CustomMenuConstant.ButtonType.PIC_WEIXIN).key("API_MENU:PIC_WEIXIN_BTN").build()
                        // 下发消息（除文本消息）
//                        ,MenuCreateRequest.Button.builder().name("\uD83D\uDD17图片").type(CustomMenuConstant.ButtonType.MEDIA_ID).key("API_MENU:MEDIA_ID_BTN").mediaId("").build()
                )).build();
//        MenuCreateRequest.Button eventBtn2 = MenuCreateRequest.Button.builder()
//                .type(CustomMenuConstant.ButtonType.TEXT).key("API_MENU:EVENT_BTN_GROUP").name("\uD83C\uDF87事件组3").subButton(Arrays.asList(
        // 点击 article_id 类型按钮
//                        MenuCreateRequest.Button.builder().name("\uD83D\uDD17发布后的图文消息").type(CustomMenuConstant.ButtonType.ARTICLE_ID).articleId("").key("API_MENU:MEDIA_ID_BTN").build(),
        // 点击 article_view_limited 类型按钮
//                        MenuCreateRequest.Button.builder().name("\uD83D\uDD17发布后的图文消息").type(CustomMenuConstant.ButtonType.ARTICLE_VIEW_LIMITED).articleId("").key("API_MENU:ARTICLE_VIEW_LIMITED_BTN").build()
//        )).build();
        buttonList.add(normalBtn);
        buttonList.add(eventBtn);
        buttonList.add(eventBtn2);
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
                Collections.singletonList(MenuCreateRequest.Button.builder().name("KangSpace").type(CustomMenuConstant.ButtonType.VIEW).url("https://kangspace.org").key("TAG_API_MENU_P_1_C_1").build())
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
