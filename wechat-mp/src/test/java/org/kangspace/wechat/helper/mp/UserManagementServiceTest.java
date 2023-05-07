package org.kangspace.wechat.helper.mp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.token.DefaultWeChatMpAccessTokenService;

/**
 * 微信公众号"用户管理"相关Service测试类
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/7
 */
@Slf4j
@RunWith(JUnit4.class)
public class UserManagementServiceTest {
    private final String appId = WeChatMpAppConstant.GLOBAL_APPID;
    private final String appSecret = WeChatMpAppConstant.GLOBAL_APPSECRET;
    private UserManagementService userManagementService;

    @Before
    public void before() {
        WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
        DefaultWeChatMpAccessTokenService weChatMpAccessTokenService = new DefaultWeChatMpAccessTokenService(weChatMpConfig);
        userManagementService = new DefaultUserManagementService(weChatMpConfig, weChatMpAccessTokenService);
    }

    /**
     * Method: tagsCreate(UserTagsUpdateRequest request)
     */
    @Test
    public void testTagsCreate() {
        UserTagsUpdateRequest request = new UserTagsUpdateRequest(new UserTagsUpdateRequest.Tag("local_tag_test2"));
        UserTagsCreateResponse response = userManagementService.tagsCreate(request);
        log.info("{}", response);
    }

    /**
     * Method: tagsGet()
     */
    @Test
    public void testTagsGet() {
        UserTagsGetResponse response = userManagementService.tagsGet();
        log.info("{}", response);
    }

    /**
     * Method: tagsUpdate(UserTagsUpdateRequest request)
     */
    @Test
    public void testTagsUpdate() {
        UserTagsUpdateRequest request = new UserTagsUpdateRequest(new UserTagsUpdateRequest.Tag(100L, "local_tag_test1_update"));
        WeChatMpResponseEntity response = userManagementService.tagsUpdate(request);
        log.info("{}", response);
    }

    /**
     * Method: tagsDelete(UserTagsUpdateRequest request)
     */
    @Test
    public void testTagsDelete() {
        UserTagsUpdateRequest request = new UserTagsUpdateRequest(new UserTagsUpdateRequest.Tag(101L));
        WeChatMpResponseEntity response = userManagementService.tagsDelete(request);
        log.info("{}", response);
    }

    /**
     * Method: userTagGet(UserTagGetRequest request)
     */
    @Test
    public void testUserTagGet() {
        UserTagGetRequest request = new UserTagGetRequest(100L);
        UserTagGetResponse response = userManagementService.userTagGet(request);
        log.info("{}", response);
    }

    /**
     * Method: tagsMembersBatchTagging(UserTagsBatchTaggingRequest request)
     */
    @Test
    public void testTagsMembersBatchTagging() {
        UserTagsBatchTaggingRequest request = new UserTagsBatchTaggingRequest(100L, "oOIaHt5IOo6rI8BH8IOiG3lA0yHU", "oOIaHt1S047ULfY9sJD1apJATS2o");
        WeChatMpResponseEntity response = userManagementService.tagsMembersBatchTagging(request);
        log.info("{}", response);
    }

    /**
     * Method: tagsMembersBatchUntagging(UserTagsBatchTaggingRequest request)
     */
    @Test
    public void testTagsMembersBatchUntagging() {
        UserTagsBatchTaggingRequest request = new UserTagsBatchTaggingRequest(100L, "oOIaHt1S047ULfY9sJD1apJATS2o");
        WeChatMpResponseEntity response = userManagementService.tagsMembersBatchUntagging(request);
        log.info("{}", response);
    }

    /**
     * Method: tagsGetIdList(UserTagsGetIdListRequest request)
     */
    @Test
    public void testTagsGetIdList() {
        UserTagsGetIdListRequest request = new UserTagsGetIdListRequest("oOIaHt5IOo6rI8BH8IOiG3lA0yHU");
        UserTagsGetIdListResponse response = userManagementService.tagsGetIdList(request);
        log.info("{}", response);
    }

}
