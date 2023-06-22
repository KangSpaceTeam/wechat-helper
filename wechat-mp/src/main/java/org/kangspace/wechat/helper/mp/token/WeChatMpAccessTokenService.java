package org.kangspace.wechat.helper.mp.token;

import org.kangspace.wechat.helper.core.token.WeChatCommonTokenService;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;

/**
 * 微信公众号AccessTokenService
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public interface WeChatMpAccessTokenService extends WeChatCommonTokenService {

    /**
     * 获取微信公众号配置对象
     *
     * @return {@link WeChatMpConfig}
     */
    @Override
    WeChatMpConfig getWeChatConfig();
}
