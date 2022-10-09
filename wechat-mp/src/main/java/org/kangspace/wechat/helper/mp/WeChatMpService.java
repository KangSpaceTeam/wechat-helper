package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.core.WeChatService;
import org.kangspace.wechat.helper.core.request.WeChatHttpClient;

/**
 * 微信公众号Service
 * @author kango2gler@gmail.com
 * @since 2022/10/3
 */
public class WeChatMpService implements WeChatService {
    WeChatHttpClient weChatHttpClient;

    public WeChatMpService(WeChatHttpClient weChatHttpClient) {
        this.weChatHttpClient = weChatHttpClient;
    }

    @Override
    public WeChatHttpClient getWeChatHttpClient() {
        return weChatHttpClient;
    }
}
