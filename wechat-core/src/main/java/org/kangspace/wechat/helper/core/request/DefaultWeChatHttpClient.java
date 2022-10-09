package org.kangspace.wechat.helper.core.request;

import org.kangspace.wechat.helper.core.env.WeChatConfig;

/**
 * 默认HttpClient
 * @author kango2gler@gmail.com
 * @since 2022/10/4
 */
public class DefaultWeChatHttpClient<RequestBody,ResponseBody> extends WechatNettyHttpClient{
    public DefaultWeChatHttpClient() {
    }

    public DefaultWeChatHttpClient(WeChatConfig weChatConfig) {
        super(weChatConfig);
    }
}
