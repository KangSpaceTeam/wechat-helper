package org.kangspace.wechat.helper.work;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;

/**
 * 企业微信"通讯录管理-互联企业"相关 Service测试
 */
@Slf4j
@RunWith(JUnit4.class)
public class LinkedCorpServiceTest {

    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private LinkedCorpService linkedCorpService;

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        linkedCorpService = new DefaultLinkedCorpService(weComAccessTokenService);
    }


    @Test
    public void linkedCorpAgentGetPermList() {
        LinkedCorpAgentGetPermListResponse response = linkedCorpService.linkedCorpAgentGetPermList();
        log.info("response: {}", response);
    }

    @Test
    public void linkedCorpUserGet() {
        LinkedCorpUserGetRequest request = new LinkedCorpUserGetRequest();
        LinkedCorpUserGetResponse response = linkedCorpService.linkedCorpUserGet(request);
        log.info("response: {}", response);

    }

    @Test
    public void linkedCorpUserSimpleList() {
        LinkedCorpUserSimpleListRequest request = new LinkedCorpUserSimpleListRequest();
        LinkedCorpUserSimpleListResponse response = linkedCorpService.linkedCorpUserSimpleList(request);
        log.info("response: {}", response);
    }

    @Test
    public void linkedCorpUserList() {
        LinkedCorpUserListRequest request = new LinkedCorpUserListRequest();
        LinkedCorpUserListResponse response = linkedCorpService.linkedCorpUserList(request);
        log.info("response: {}", response);
    }

    @Test
    public void linkedCorpDepartmentList() {
        LinkedCorpDepartmentListRequest request = new LinkedCorpDepartmentListRequest();
        LinkedCorpDepartmentListResponse response = linkedCorpService.linkedCorpDepartmentList(request);
        log.info("response: {}", response);
    }
}