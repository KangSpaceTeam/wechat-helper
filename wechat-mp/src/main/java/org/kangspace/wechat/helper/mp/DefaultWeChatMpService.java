package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.token.WeChatMpAccessTokenService;

/**
 * 微信公众号默认Service
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public class DefaultWeChatMpService extends AbstractWeChatMpService {

    public DefaultWeChatMpService(WeChatMpConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultWeChatMpService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService) {
        super(weChatConfig, weChatMpAccessTokenService);
    }

    public DefaultWeChatMpService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weChatConfig, weChatMpAccessTokenService, requestFilterChain);
    }
}
