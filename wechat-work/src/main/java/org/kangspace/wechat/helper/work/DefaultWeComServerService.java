package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.bean.ServerIpListResponse;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

/**
 * <p>
 * 企业微信"服务器"相关Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/6/26
 */
public class DefaultWeComServerService extends AbstractWeComService implements WeComServerService {

    public DefaultWeComServerService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultWeComServerService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultWeComServerService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }

    @Override
    public ServerIpListResponse getApiDomainIp() {
        String url = WeComApiPaths.GET_API_DOMAIN_IP;
        return get(url, ServerIpListResponse.class);
    }

    @Override
    public ServerIpListResponse getCallbackIp() {
        String url = WeComApiPaths.GET_CALLBACK_IP;
        return get(url, ServerIpListResponse.class);
    }
}
