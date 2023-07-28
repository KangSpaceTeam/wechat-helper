package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

/**
 * <p>
 * 企业微信"通讯录管理-互联企业"相关 Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/27
 */
public class DefaultLinkedCorpService extends AbstractWeComService implements LinkedCorpService {

    public DefaultLinkedCorpService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultLinkedCorpService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultLinkedCorpService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }

    @Override
    public LinkedCorpAgentGetPermListResponse linkedCorpAgentGetPermList() {
        String url = WeComApiPaths.LINKED_CORP_AGENT_GET_PERM_LIST;
        return post(url, null, LinkedCorpAgentGetPermListResponse.class);
    }

    @Override
    public LinkedCorpUserGetResponse linkedCorpUserGet(LinkedCorpUserGetRequest request) {
        String url = WeComApiPaths.LINKED_CORP_USER_GET;
        return post(url, request, LinkedCorpUserGetResponse.class);
    }

    @Override
    public LinkedCorpUserSimpleListResponse linkedCorpUserSimpleList(LinkedCorpUserSimpleListRequest request) {
        String url = WeComApiPaths.LINKED_CORP_USER_SIMPLE_LIST;
        return post(url, request, LinkedCorpUserSimpleListResponse.class);
    }

    @Override
    public LinkedCorpUserListResponse linkedCorpUserList(LinkedCorpUserListRequest request) {
        String url = WeComApiPaths.LINKED_CORP_USER_LIST;
        return post(url, request, LinkedCorpUserListResponse.class);
    }

    @Override
    public LinkedCorpDepartmentListResponse linkedCorpDepartmentList(LinkedCorpDepartmentListRequest request) {
        String url = WeComApiPaths.LINKED_CORP_DEPARTMENT_LIST;
        return post(url, request, LinkedCorpDepartmentListResponse.class);
    }
}
