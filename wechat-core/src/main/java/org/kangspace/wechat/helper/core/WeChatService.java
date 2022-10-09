package org.kangspace.wechat.helper.core;

import org.kangspace.wechat.helper.core.request.WeChatHttpClient;

/**
 * WeChat服务接口
 * @author kango2gler@gmail.com
 * @since 2022/10/3
 */
public interface WeChatService {
    WeChatHttpClient getWeChatHttpClient();
}
