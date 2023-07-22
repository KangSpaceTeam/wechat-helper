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
 * 企业微信"通讯录管理-标签管理"相关 Service测试
 */
@Slf4j
@RunWith(JUnit4.class)
public class TagServiceTest {

    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private TagService tagService;

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        tagService = new DefaultTagService(weComAccessTokenService);
    }

    @Test
    public void tagCreate() {
        Long tagId = 100L;
        TagRequest request = TagRequest.builder()
                .tagId(tagId)
                .tagName("tag" + tagId)
                .build();
        TagCreateResponse response = tagService.tagCreate(request);
        log.info("response: {}", response);
    }

    @Test
    public void tagUpdate() {
        Long tagId = 101L;
        TagUpdateRequest request = TagUpdateRequest.builder()
                .tagId(tagId)
                .tagName("tag" + tagId + "_update")
                .build();
        WeComResponseEntity response = tagService.tagUpdate(request);
        log.info("response: {}", response);
    }

    @Test
    public void tagDelete() {
        Long tagId = 100L;
        WeComResponseEntity response = tagService.tagDelete(tagId);
        log.info("response: {}", response);
    }

    @Test
    public void tagGet() {
        Long tagId = 101L;
        TagUserResponse response = tagService.tagGet(tagId);
        log.info("response: {}", response);
    }

    @Test
    public void tagAddTagUsers() {
        Long tagId = 101L;
        Long departmentId = 1L;
        String userId = "Kang";
        TagUpdateTagUsersRequest request = TagUpdateTagUsersRequest.builder()
                .tagTd(tagId)
                .partyList(Collections.singletonList(departmentId))
                .userList(Collections.singletonList(userId))
                .build();
        TagUpdateTagUsersResponse response = tagService.tagAddTagUsers(request);
        log.info("response: {}", response);
    }

    @Test
    public void tagDelTagUsers() {
        Long tagId = 101L;
        Long departmentId = 1L;
        TagUpdateTagUsersRequest request = TagUpdateTagUsersRequest.builder()
                .tagTd(tagId)
                .partyList(Collections.singletonList(departmentId))
                .build();
        TagUpdateTagUsersResponse response = tagService.tagDelTagUsers(request);
        log.info("response: {}", response);
    }

    @Test
    public void tagList() {
        TagListResponse response = tagService.tagList();
        log.info("response: {}", response);
    }
}