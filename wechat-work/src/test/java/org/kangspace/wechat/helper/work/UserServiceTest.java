package org.kangspace.wechat.helper.work;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.work.bean.*;
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


    @Test
    public void userSimpleList() {
        Long departmentId = 1L;
        UserSimpleListResponse response = userService.userSimpleList(departmentId);
        log.info("response: {}", response);
    }

    @Test
    public void userList() {
        Long departmentId = 1L;
        UserListResponse response = userService.userList(departmentId);
        log.info("response: {}", response);
    }

    @Test
    public void userConvertToOpenId() {
        UserConvertToOpenIdResponse response = userService.userConvertToOpenId(new UserConvertToOpenIdRequest("Kang"));
        log.info("response: {}", response);
    }

    @Test
    public void userConvertToUserId() {
        UserConvertToUserIdResponse response = userService.userConvertToUserId(new UserConvertToUserIdRequest("oooxrs5fNoSwDHPAGSq1soo8BHdg"));
        log.info("response: {}", response);
    }

    @Test
    public void userAuthSucc() {
        String userId = "Kang";
        WeComResponseEntity response = userService.userAuthSucc(userId);
        log.info("response: {}", response);
    }

    @Test
    public void batchInvite() {
        BatchInviteRequest batchInviteRequest = BatchInviteRequest.builder()
                .user(Collections.singletonList("Kang"))
                .build();
        BatchInviteResponse response = userService.batchInvite(batchInviteRequest);
        log.info("response: {}", response);
    }

    @Test
    public void corpGetJoinQrCode() {
        Integer sizeType = null;
        CorpGetJoinQrCodeResponse response = userService.corpGetJoinQrCode(sizeType);
        log.info("response: {}", response);
    }

    @Test
    public void userGetUserId() {
        String mobile = "";
        UserGetUserIdResponse response = userService.userGetUserId(new UserGetUserIdRequest(mobile));
        log.info("response: {}", response);
    }

    @Test
    public void userGetUserIdByEmail() {
        String email = "";
        UserGetUserIdByEmailResponse response = userService.userGetUserIdByEmail(new UserGetUserIdByEmailRequest(email));
        log.info("response: {}", response);
    }

    @Test
    public void userListId() {
        UserListIdResponse response = userService.userListId(new UserListIdRequest());
        log.info("response: {}", response);
    }
}