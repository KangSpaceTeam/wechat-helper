package org.kangspace.wechat.helper.work;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.work.bean.UserBatchDeleteRequest;
import org.kangspace.wechat.helper.work.bean.UserRequest;
import org.kangspace.wechat.helper.work.bean.UserResponse;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;

import java.util.Collections;

/**
 * 企业微信"通讯录管理-成员管理"相关 Service测试
 */
@Slf4j
@RunWith(JUnit4.class)
public class UserServiceTest {

    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private UserService userService;

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        userService = new DefaultUserService(weComAccessTokenService);
    }

    /**
     * 从2022年8月15日10点开始，“企业管理后台 - 管理工具 - 通讯录同步”的新增IP将不能再调用此接口
     */
    @Test
    public void userGet() {
        String userId = "Kang";
        UserResponse response = userService.userGet(userId);
        log.info("response: {}", response);
    }

    @Test
    public void userCreate() {
        UserRequest request = UserRequest.builder()
                .userId("kangsapce1")
                .name("KangSpace1")
                .mobile("15400000002")
                .department(Collections.singletonList(1L))
                .build();
        WeComResponseEntity response = userService.userCreate(request);
        log.info("response: {}", response);
    }

    @Test
    public void userUpdate() {
        UserRequest request = UserRequest.builder()
                .userId("kangsapce")
                .name("kangSpace_update")
//                .mobile("15400000001")
//                .department(Arrays.asList(1L))
                .build();
        WeComResponseEntity response = userService.userUpdate(request);
        log.info("response: {}", response);
    }

    @Test
    public void userDelete() {
        String userId = "kangsapce";
        WeComResponseEntity response = userService.userDelete(userId);
        log.info("response: {}", response);
    }

    @Test
    public void userBatchDelete() {
        UserBatchDeleteRequest request = new UserBatchDeleteRequest("kangsapce1");
        WeComResponseEntity response = userService.userBatchDelete(request);
        log.info("response: {}", response);
    }
}