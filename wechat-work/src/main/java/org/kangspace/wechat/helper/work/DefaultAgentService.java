package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.bean.agent.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

import javax.annotation.Nonnull;

/**
 * <p>
 * 企业微信"身份验证"相关 Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
public class DefaultAgentService extends AbstractWeComService implements AgentService {

    public DefaultAgentService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultAgentService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultAgentService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }

    @Override
    public AgentGetResponse agentGet(@Nonnull Integer agentId) {
        String url = urlTransfer(WeComApiPaths.AGENT_GET, agentId.toString());
        return get(url, AgentGetResponse.class);
    }

    @Override
    public AgentListResponse agentList() {
        String url = WeComApiPaths.AGENT_LIST;
        return get(url, AgentListResponse.class);
    }

    @Override
    public WeComResponseEntity agentSet(@Nonnull AgentSetRequest request) {
        String url = WeComApiPaths.AGENT_SET;
        return post(url, request, WeComResponseEntity.class);
    }

    @Override
    public WeComResponseEntity agentSetWorkbenchTemplate(@Nonnull AgentSetWorkbenchTemplateRequest request) {
        String url = WeComApiPaths.AGENT_SET_WORKBENCH_TEMPLATE;
        return post(url, request, WeComResponseEntity.class);
    }

    @Override
    public AgentGetWorkbenchTemplateResponse agentGetWorkbenchTemplate(@Nonnull AgentGetWorkbenchTemplateRequest request) {
        String url = WeComApiPaths.AGENT_GET_WORKBENCH_TEMPLATE;
        return post(url, request, AgentGetWorkbenchTemplateResponse.class);
    }

    @Override
    public WeComResponseEntity agentSetWorkbenchData(@Nonnull AgentSetWorkbenchDataRequest request) {
        String url = WeComApiPaths.AGENT_SET_WORKBENCH_DATA + "?debug=1";
        return post(url, request, WeComResponseEntity.class);
    }
}
