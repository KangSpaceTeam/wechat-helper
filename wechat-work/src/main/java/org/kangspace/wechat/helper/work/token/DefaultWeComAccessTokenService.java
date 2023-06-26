package org.kangspace.wechat.helper.work.token;

import org.kangspace.wechat.helper.core.storage.WeChatTokenStorage;
import org.kangspace.wechat.helper.core.token.AccessTokenResponse;
import org.kangspace.wechat.helper.work.AbstractWeComService;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;

/**
 * 默认微信公众号Token处理Service
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public class DefaultWeComAccessTokenService extends AbstractWeComService implements WeComAccessTokenService {
    /**
     * AccessToken 存储器
     */
    private final WeChatTokenStorage<AccessTokenResponse> weChatTokenStorage;

    public DefaultWeComAccessTokenService(WeComConfig weChatConfig) {
        super();
        this.setWeChatConfig(weChatConfig);
        this.weChatTokenStorage = weChatConfig.getWeChatTokenStorage();
    }

    @Override
    public AccessTokenResponse tokenRefresh() {
        WeComConfig weComConfig = getWeChatConfig();
        return token(weComConfig.getAppId(), weComConfig.getCorpSecret());
    }

    @Override
    public AccessTokenResponse token(String corpId, String corpSecret) {
        String url = urlTransfer(WeComApiPaths.GET_TOKEN, corpId, corpSecret);
        return get(url, AccessTokenResponse.class, false);
    }

    @Override
    public WeChatTokenStorage<AccessTokenResponse> getWeChatTokenStorage() {
        return this.weChatTokenStorage;
    }
}
