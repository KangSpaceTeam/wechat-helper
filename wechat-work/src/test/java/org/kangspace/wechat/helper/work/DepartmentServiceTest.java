package org.kangspace.wechat.helper.work;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;


@Slf4j
@RunWith(JUnit4.class)
public class DepartmentServiceTest {

    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private DepartmentService departmentService;

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        departmentService = new DefaultDepartmentService(weComAccessTokenService);
    }

    @Test
    public void departmentCreate() {
        DepartmentRequest request = DepartmentRequest.builder().id(100L).name("Dept100").parentId(1L).build();
        DepartmentCreateResponse response = departmentService.departmentCreate(request);
        log.info("response: {}", response);
    }

    @Test
    public void departmentUpdate() {
        DepartmentRequest request = DepartmentRequest.builder().id(100L).name("Dept1001").build();
        WeComResponseEntity response = departmentService.departmentUpdate(request);
        log.info("response: {}", response);
    }

    @Test
    public void departmentDelete() {
        Long departmentId = 100L;
        WeComResponseEntity response = departmentService.departmentDelete(departmentId);
        log.info("response: {}", response);
    }

    @Test
    public void departmentList() {
        Long departmentId = 1L;
        DepartmentListResponse response = departmentService.departmentList(departmentId);
        log.info("response: {}", response);
    }

    @Test
    public void departmentSimpleList() {
//        Long departmentId = 1L;
        Long departmentId = null;
        DepartmentSimpleListResponse response = departmentService.departmentSimpleList(departmentId);
        log.info("response: {}", response);
    }

    @Test
    public void departmentGet() {
        Long departmentId = 1L;
        DepartmentResponse response = departmentService.departmentGet(departmentId);
        log.info("response: {}", response);
    }
}