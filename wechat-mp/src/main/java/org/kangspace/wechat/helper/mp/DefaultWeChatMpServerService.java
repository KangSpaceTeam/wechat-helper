package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.mp.bean.WeChatMpServerIpListResponse;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;
import org.kangspace.wechat.helper.mp.request.filter.WeChatMpRequestFilterChainFactory;
import org.kangspace.wechat.helper.mp.token.WeChatMpAccessTokenService;

/**
 * <p>
 * 微信公众号服务器相关Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public class DefaultWeChatMpServerService extends AbstractWeChatMpService implements WeChatMpServerService {

    public DefaultWeChatMpServerService(WeChatMpConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultWeChatMpServerService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService) {
        this(weChatConfig, weChatMpAccessTokenService, WeChatMpRequestFilterChainFactory.defaultRequestFilterChain());
    }

    public DefaultWeChatMpServerService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weChatConfig, weChatMpAccessTokenService, requestFilterChain);
    }

    @Override
    public WeChatMpServerIpListResponse getApiDomainIp() {
        String url = WeChatMpApiPaths.GET_API_DOMAIN_IP;
        return get(url, WeChatMpServerIpListResponse.class);
    }

    @Override
    public WeChatMpServerIpListResponse getCallbackIp() {
        String url = WeChatMpApiPaths.GET_CALLBACK_IP;
        return get(url, WeChatMpServerIpListResponse.class);
    }

}
