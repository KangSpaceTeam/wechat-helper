package org.kangspace.wechat.helper.core.token;

import org.kangspace.wechat.helper.core.storage.WeChatTokenStorage;

/**
 * 微信Token相关处理
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public interface WeChatTokenService {

    /**
     * 获取Token存储器
     * @return {@link WeChatTokenStorage}
     */
    <T> WeChatTokenStorage<T> getWeChatTokenStorage();
}
