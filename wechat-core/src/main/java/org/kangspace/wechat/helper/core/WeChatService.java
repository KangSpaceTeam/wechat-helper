package org.kangspace.wechat.helper.core;

import org.kangspace.wechat.helper.core.config.WeChatConfig;
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
     * 获取token
     * @return token
     */
    default String getToken() {
        return getWeChatTokenService().token().getToken();
    }

    /**
     * 是否需要AccessToken
     *
     * @return boolean
     */
    default boolean isNeedAccessToken() {
        return true;
    }


    /**
     * Get请求
     *
     * @param url             url
     * @param responseClass   响应对象类型
     * @param needAccessToken 是否需要token
     * @return Resp
     */
    default <Resp> Resp get(String url, Class<Resp> responseClass, boolean needAccessToken) {
        return WeChatRequestFactory.get(url, responseClass, getWeChatConfig(), getWeChatTokenService(), getRequestFilterChain(), needAccessToken).execute();
    }

    /**
     * Get请求
     *
     * @param url           url
     * @param responseClass 响应对象类型
     * @return Resp
     */
    default <Resp> Resp get(String url, Class<Resp> responseClass) {
        return get(url, responseClass, true);
    }

    /**
     * Post请求
     *
     * @param url             url
     * @param requestBody     请求体
     * @param responseClass   响应对象类型
     * @param needAccessToken 是否需要AccessToken
     * @return Resp
     */
    default <Req, Resp> Resp post(String url, Req requestBody, Class<Resp> responseClass, boolean needAccessToken) {
        return WeChatRequestFactory.post(url, requestBody, responseClass, getWeChatConfig(), getWeChatTokenService(), getRequestFilterChain(), needAccessToken).execute();
    }

    /**
     * Post请求
     *
     * @param url           url
     * @param requestBody   请求体
     * @param responseClass 响应对象类型
     * @return Resp
     */
    default <Req, Resp> Resp post(String url, Req requestBody, Class<Resp> responseClass) {
        return post(url, requestBody, responseClass, true);
    }
}
