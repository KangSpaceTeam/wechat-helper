package org.kangspace.wechat.helper.mp.token;

import org.kangspace.wechat.helper.core.constant.StringLiteral;
import org.kangspace.wechat.helper.core.request.WeChatHttpClient;
import org.kangspace.wechat.helper.mp.AbstractWeChatMpService;
import org.kangspace.wechat.helper.mp.bean.WeChatMpAccessTokenRequest;
import org.kangspace.wechat.helper.mp.bean.WeChatMpAccessTokenResponse;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

/**
 * 默认微信公众号Token处理Service
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public class DefaultWeChatMpAccessTokenService extends AbstractWeChatMpService implements WeChatMpAccessTokenService {

    public DefaultWeChatMpAccessTokenService(WeChatMpConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultWeChatMpAccessTokenService(WeChatMpConfig weChatConfig, WeChatHttpClient weChatHttpClient) {
        super(weChatConfig, weChatHttpClient);
    }

    /**
     * 获取当前token
     *
     * @return {@link WeChatMpAccessTokenResponse}
     */
    @Override
    public WeChatMpAccessTokenResponse token() {
        return tokenRefresh();
    }

    @Override
    public WeChatMpAccessTokenResponse token(boolean forceRefresh) {
        return forceRefresh ? tokenRefresh() : token();

    }

    /**
     * 刷新token
     * @return {@link WeChatMpAccessTokenResponse}
     */
    public WeChatMpAccessTokenResponse tokenRefresh() {
        WeChatMpConfig weChatMpConfig = getWeChatConfig();
        return token(weChatMpConfig.getAppId(), weChatMpConfig.getAppSecret());
    }

    @Override
    public WeChatMpAccessTokenResponse token(String appId, String secret) {
        String param = WeChatMpAccessTokenRequest.toQueryString(appId, secret);
        String url = WeChatMpApiPaths.TOKEN + StringLiteral.QUESTION_MARK + param;
        return get(url, WeChatMpAccessTokenResponse.class, false);
    }
}
