package org.kangspace.wechat.helper.core.request;

/**
 * 微信公众号公共请求API父类
 * @author kango2gler@gmail.com
 * @since 2022/10/1
 */
public interface WeChatRequest<Req,Resp> {
    /**
     * request的URL
     * @return URL
     */
    String url();

    /**
     * 获取请求客户端
     * @return {@link WeChatHttpClient}
     */
    WeChatHttpClient getWeChatHttpClient();

    /**
     * 是否需要AccessToken
     * @return
     */
    default boolean isNeedAccessToken(){
        return true;
    }
}
