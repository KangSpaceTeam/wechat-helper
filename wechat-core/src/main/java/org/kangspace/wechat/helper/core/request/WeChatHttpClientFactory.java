package org.kangspace.wechat.helper.core.request;

/**
 * HttpClient工厂类
 * @author kango2gler@gmail.com
 * @since 2022/10/4
 */
public class WeChatHttpClientFactory {

    /**
     * 获取默认httpClient(Netty)
     * @return {@link WeChatHttpClient}
     */
    public static WeChatHttpClient defaultHttpClient() {
        return new DefaultWeChatHttpClient();
    }

}
