package org.kangspace.wechat.helper.work.token;

import org.kangspace.wechat.helper.core.token.AccessTokenResponse;
import org.kangspace.wechat.helper.core.token.WeChatCommonTokenService;
import org.kangspace.wechat.helper.work.config.WeComConfig;

/**
 * 企业微信AccessTokenService
 *
 * @author kango2gler@gmail.com
 * @since 2023/6/22
 */
public interface WeComAccessTokenService extends WeChatCommonTokenService {

    /**
     * 获取企业微信配置对象
     *
     * @return {@link WeComConfig}
     */
    @Override
    WeComConfig getWeChatConfig();


    /**
     * 企业微信微信获取Access token
     *
     * @param corpId  企业ID
     * @param corpSecret 应用的凭证密钥，注意应用需要是启用状态
     * @return {@link AccessTokenResponse}
     */
    @Override
    AccessTokenResponse token(String corpId, String corpSecret);
}
