package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.bean.agent.*;

import javax.annotation.Nonnull;

/**
 * 企业微信"应用管理"相关 Service <br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/91022">https://developer.work.weixin.qq.com/document/path/91022</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/07/30
 */
public interface AgentService extends WeComService {

    /**
     * 应用管理-获取指定的应用详情
     *
     * @param agentId 应用id
     * @return {@link AgentGetResponse}
     */
    AgentGetResponse agentGet(@Nonnull Integer agentId);

    /**
     * 应用管理-获取access_token对应的应用列表
     *
     * @return {@link AgentListResponse}
     */
    AgentListResponse agentList();

    /**
     * 应用管理-设置应用
     *
     * @param request {@link AgentSetRequest}
     * @return {@link AgentListResponse}
     */
    WeComResponseEntity agentSet(@Nonnull AgentSetRequest request);

    /**
     * 应用管理-设置应用在工作台展示的模版
     *
     * @param request {@link AgentSetWorkbenchTemplateRequest}
     * @return {@link WeComResponseEntity}
     * @see AgentSetWorkbenchKeyDataTemplateRequest
     * @see AgentSetWorkbenchImageTemplateRequest
     * @see AgentSetWorkbenchListTemplateRequest
     * @see AgentSetWorkbenchWebviewTemplateRequest
     * @see AgentSetWorkbenchNormalTemplateRequest
     */
    WeComResponseEntity agentSetWorkbenchTemplate(@Nonnull AgentSetWorkbenchTemplateRequest request);

    /**
     * 应用管理-获取应用在工作台展示的模版
     *
     * @param request {@link AgentGetWorkbenchTemplateRequest}
     * @return {@link AgentGetWorkbenchTemplateResponse}
     */
    AgentGetWorkbenchTemplateResponse agentGetWorkbenchTemplate(@Nonnull AgentGetWorkbenchTemplateRequest request);

    /**
     * 应用管理-设置应用在用户工作台展示的数据 <br>
     * 注意: 调用该接口时,需保证修改数据的类型为 当前应用展示模版类型 <br>
     *
     * @param request {@link AgentSetWorkbenchDataRequest}
     * @return {@link WeComResponseEntity}
     * @see AgentSetWorkbenchKeyDataDataRequest
     * @see AgentSetWorkbenchImageDataRequest
     * @see AgentSetWorkbenchListDataRequest
     * @see AgentSetWorkbenchWebviewDataRequest
     */
    WeComResponseEntity agentSetWorkbenchData(@Nonnull AgentSetWorkbenchDataRequest request);
}
