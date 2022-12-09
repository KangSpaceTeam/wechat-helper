package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.mp.bean.CallbackCheckRequest;
import org.kangspace.wechat.helper.mp.bean.CallbackCheckResponse;
import org.kangspace.wechat.helper.mp.bean.MpServerIpListResponse;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;
import org.kangspace.wechat.helper.mp.request.filter.WeChatMpRequestFilterChainFactory;
import org.kangspace.wechat.helper.mp.token.WeChatMpAccessTokenService;

import java.util.Objects;

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
    public MpServerIpListResponse getApiDomainIp() {
        String url = WeChatMpApiPaths.GET_API_DOMAIN_IP;
        return get(url, MpServerIpListResponse.class);
    }

    @Override
    public MpServerIpListResponse getCallbackIp() {
        String url = WeChatMpApiPaths.GET_CALLBACK_IP;
        return get(url, MpServerIpListResponse.class);
    }

    @Override
    public CallbackCheckResponse callbackCheck(CallbackCheckRequest param) {
        Objects.requireNonNull(param, "MpCallbackCheckParam must be not null");
        String url = WeChatMpApiPaths.CALLBACK_CHECK;
        return post(url, param, CallbackCheckResponse.class);
    }
}
