package org.kangspace.wechat.helper.core.token;

import org.kangspace.wechat.helper.core.storage.WeChatTokenStorage;

/**
 * 微信Token相关处理抽象类
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public abstract class AbstractWeChatTokenService<TokenStorageVal> implements WeChatTokenService {
    private final WeChatTokenStorage<TokenStorageVal> weChatTokenStorage;

    public AbstractWeChatTokenService(WeChatTokenStorage<TokenStorageVal> weChatTokenStorage) {
        this.weChatTokenStorage = weChatTokenStorage;
    }

    @SuppressWarnings("unchecked")
    @Override
    public WeChatTokenStorage<TokenStorageVal> getWeChatTokenStorage() {
        return weChatTokenStorage;
    }
}
