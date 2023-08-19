package org.kangspace.wechat.helper.work;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.bean.agent.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用管理 相关测试类
 */
@Slf4j
@RunWith(JUnit4.class)
public class AgentServiceTest {
    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private AgentService agentService;

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        agentService = new DefaultAgentService(weComAccessTokenService);
    }


    @Test
    public void agentGet() {
        Integer agentId = 1000004;
        AgentGetResponse response = agentService.agentGet(agentId);
        log.info("response: {}", response);
    }

    @Test
    public void agentList() {
        AgentListResponse response = agentService.agentList();
        log.info("response: {}", response);
    }

    @Test
    public void agentSet() {
        Integer agentId = 1000004;
        AgentSetRequest request = AgentSetRequest.builder().agentId(agentId)
                .description("wechat-helper 项目测试应用_" + System.currentTimeMillis())
                .homeUrl("")
                .isReportEnter(1).name("wechat-helper app").build();
        WeComResponseEntity response = agentService.agentSet(request);
        log.info("response: {}", response);
    }

    @Test
    public void agentSetWorkbenchImageTemplate() {
        Integer agentId = 1000004;
        AgentSetWorkbenchImageTemplateRequest request = AgentSetWorkbenchImageTemplateRequest.builder().agentId(agentId)
                .image(Image.builder().url("https://wework.qpic.cn/wwpic/342427_jvJeLmm-TIar3Ss_1687428900/0").jumpUrl("https://kangspace.org")
                        .build()).build();
        WeComResponseEntity response = agentService.agentSetWorkbenchTemplate(request);
        log.info("response: {}", response);
    }

    @Test
    public void agentSetWorkbenchListTemplate() {
        Integer agentId = 1000004;
        List<ListItems.Item> list = new ArrayList<>();
        list.add(ListItems.Item.builder().title("主页").jumpUrl("https://kangspace.org").build());
        list.add(ListItems.Item.builder().title("进入应用").build());
        AgentSetWorkbenchListTemplateRequest request = AgentSetWorkbenchListTemplateRequest.builder().agentId(agentId).list(ListItems.builder().items(list).build()).build();
        WeComResponseEntity response = agentService.agentSetWorkbenchTemplate(request);
        log.info("response: {}", response);
    }

    @Test
    public void agentSetWorkbenchKeyDataTemplate() {
        Integer agentId = 1000004;
        List<KeyData.Item> list = new ArrayList<>();
        list.add(KeyData.Item.builder().key("主页").data("0").jumpUrl("https://kangspace.org").build());
        list.add(KeyData.Item.builder().key("进入应用").data("1").build());
        AgentSetWorkbenchKeyDataTemplateRequest request = AgentSetWorkbenchKeyDataTemplateRequest.builder()
                .agentId(agentId)
                .keyData(KeyData.builder().items(list).build())
                .build();
        WeComResponseEntity response = agentService.agentSetWorkbenchTemplate(request);
        log.info("response: {}", response);
    }

    @Test
    public void agentSetWorkbenchWebviewTemplate() {
        Integer agentId = 1000004;
        AgentSetWorkbenchWebviewTemplateRequest request = AgentSetWorkbenchWebviewTemplateRequest.builder()
                .agentId(agentId)
                .webview(Webview.builder().url("https://kangspace.org").build())
                .build();
        WeComResponseEntity response = agentService.agentSetWorkbenchTemplate(request);
        log.info("response: {}", response);
    }

    @Test
    public void agentGetWorkbenchTemplate() {
        Integer agentId = 1000004;
        AgentGetWorkbenchTemplateRequest request = AgentGetWorkbenchTemplateRequest.builder().agentId(agentId).build();
        AgentGetWorkbenchTemplateResponse response = agentService.agentGetWorkbenchTemplate(request);
        log.info("response: {}", response);
    }

    @Test
    public void agentSetWorkbenchImageData() {
        Integer agentId = 1000004;
        String userId = "Kang";
        AgentSetWorkbenchImageDataRequest request = AgentSetWorkbenchImageDataRequest.builder()
                .agentId(agentId).userId(userId)
                .image(Image.builder().url("https://wework.qpic.cn/wwpic/342427_jvJeLmm-TIar3Ss_1687428900/0")
                        .jumpUrl("https://kangspace.org").build())
                .build();
        WeComResponseEntity response = agentService.agentSetWorkbenchData(request);
        log.info("response: {}", response);
    }

    @Test
    public void agentSetWorkbenchListData() {
        Integer agentId = 1000004;
        String userId = "Kang";
        List<ListItems.Item> list = new ArrayList<>();
        list.add(ListItems.Item.builder().title("Kang的主页").jumpUrl("https://kangspace.org").build());
        list.add(ListItems.Item.builder().title("Kang的应用").build());
        AgentSetWorkbenchListDataRequest request = AgentSetWorkbenchListDataRequest.builder()
                .agentId(agentId).userId(userId)
                .list(ListItems.builder().items(list).build())
                .build();
        WeComResponseEntity response = agentService.agentSetWorkbenchData(request);
        log.info("response: {}", response);
    }

    @Test
    public void agentSetWorkbenchKeyDataData() {
        Integer agentId = 1000004;
        String userId = "Kang";
        List<KeyData.Item> list = new ArrayList<>();
        list.add(KeyData.Item.builder().key("主页").data("1+").jumpUrl("https://kangspace.org").build());
        list.add(KeyData.Item.builder().key("进入应用").data("9+").build());
        AgentSetWorkbenchKeyDataDataRequest request = AgentSetWorkbenchKeyDataDataRequest.builder()
                .agentId(agentId).userId(userId)
                .keyData(KeyData.builder().items(list).build())
                .build();
        WeComResponseEntity response = agentService.agentSetWorkbenchData(request);
        log.info("response: {}", response);
    }

    @Test
    public void agentSetWorkbenchWebviewData() {
        Integer agentId = 1000004;
        String userId = "Kang";
        AgentSetWorkbenchWebviewDataRequest request = AgentSetWorkbenchWebviewDataRequest.builder()
                .agentId(agentId).userId(userId)
                .webview(Webview.builder().url("https://kangspace.org").build())
                .build();
        WeComResponseEntity response = agentService.agentSetWorkbenchData(request);
        log.info("response: {}", response);
    }
}