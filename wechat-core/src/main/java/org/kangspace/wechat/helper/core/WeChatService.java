package org.kangspace.wechat.helper.core;

import org.kangspace.wechat.helper.core.config.WeChatConfig;
import org.kangspace.wechat.helper.core.request.WeChatHttpClient;
import org.kangspace.wechat.helper.core.request.WeChatRequestFactory;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.core.token.WeChatTokenService;

/**
 * WeChat服务接口
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/3
 */
public interface WeChatService {
    /**
     * 获取HttpClient
     *
     * @return {@link WeChatHttpClient}
     */
    WeChatHttpClient getWeChatHttpClient();

    /**
     * 获取微信配置对象
     *
     * @return {@link WeChatConfig}
     */
    WeChatConfig getWeChatConfig();

    /**
     * 获取请求过滤器链
     *
     * @return {@link RequestFilterChain}
     * @see org.kangspace.wechat.helper.core.request.filter.RequestFilterChainFactory
     */
    RequestFilterChain getRequestFilterChain();

    /**
     * 获取Token相关Service
     *
     * @return {@link WeChatTokenService}
     */
    WeChatTokenService getWeChatTokenService();


    /**
     * Get请求
     *
     * @param url             url
     * @param responseClass   响应对象类型
     * @param needAccessToken 是否需要token
     * @param <Resp>
     * @return Resp
     */
    default <Resp> Resp get(String url, Class<Resp> responseClass, boolean needAccessToken) {
        return WeChatRequestFactory.get(url, responseClass, getWeChatConfig(), getWeChatTokenService(), getWeChatHttpClient(), getRequestFilterChain(), needAccessToken).execute();
    }

    /**
     * Get请求
     *
     * @param url           url
     * @param responseClass 响应对象类型
     * @return Resp
     */
    default <Resp> Resp get(String url, Class<Resp> responseClass) {
        return WeChatRequestFactory.get(url, responseClass, getWeChatConfig(), getWeChatTokenService(), getWeChatHttpClient(), getRequestFilterChain()).execute();
    }
}
