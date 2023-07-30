package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

/**
 * <p>
 * 企业微信"企业互联"相关 Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
public class DefaultCorpGroupService extends AbstractWeComService implements CorpGroupService {

    public DefaultCorpGroupService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultCorpGroupService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultCorpGroupService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }

    @Override
    public CorpGroupCorpListAppShareInfoResponse corpGroupCorpListAppShareInfo(CorpGroupCorpListAppShareInfoRequest request) {
        String url = WeComApiPaths.CORP_GROUP_CORP_LIST_APP_SHARE_INFO;
        return post(url, request, CorpGroupCorpListAppShareInfoResponse.class);
    }

    @Override
    public CorpGroupCorpGetTokenResponse corpGroupCorpGetToken(CorpGroupCorpGetTokenRequest request) {
        String url = WeComApiPaths.CORP_GROUP_CORP_GET_TOKEN;
        return post(url, request, CorpGroupCorpGetTokenResponse.class);
    }

    @Override
    public MiniProgramTransferSessionResponse miniProgramTransferSession(MiniProgramTransferSessionRequest request) {
        String url = WeComApiPaths.MINI_PROGRAM_TRANSFER_SESSION;
        return post(url, request, MiniProgramTransferSessionResponse.class);
    }
}
