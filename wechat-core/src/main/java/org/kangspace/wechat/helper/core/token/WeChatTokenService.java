package org.kangspace.wechat.helper.core.token;

import org.kangspace.wechat.helper.core.config.WeChatConfig;
import org.kangspace.wechat.helper.core.storage.WeChatTokenStorage;

/**
 * 微信Token相关处理
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public interface WeChatTokenService {

    /**
     * 获取微信配置对象
     *
     * @return {@link WeChatConfig}
     */
    WeChatConfig getWeChatConfig();

    /**
     * 获取Token
     *
     * @return {@link WeChatToken}
     */
    WeChatToken token();

    /**
     * 刷新token
     *
     * @return {@link WeChatToken}
     */
    WeChatToken tokenRefresh();

    /**
     * 获取Token存储器
     *
     * @return {@link WeChatTokenStorage}
     */
    <T extends WeChatToken> WeChatTokenStorage<T> getWeChatTokenStorage();
}
