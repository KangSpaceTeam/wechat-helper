package org.kangspace.wechat.helper.core.request;

import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import org.kangspace.wechat.helper.core.config.WeChatConfig;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.core.token.WeChatTokenService;

/**
 * 微信请求对象工厂类
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public class WeChatRequestFactory {


    /**
     * Get请求
     *
     * @param url           url
     * @param responseClass 响应对象类型
     * @param wechatConfig  微信配置
     * @param filterChain   过滤器链
     * @return {@link WeChatRequest}
     */
    public static <Req, Resp> WeChatRequest<Req, Resp> get(String url, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, RequestFilterChain filterChain) {
        return new DefaultWeChatRequest<>(url, null, responseClass, wechatConfig, weChatTokenService, filterChain);
    }

    /**
     * Get请求
     *
     * @param url             url
     * @param responseClass   响应对象类型
     * @param wechatConfig    微信配置
     * @param filterChain     过滤器链
     * @param needAccessToken 是否需要token
     * @return {@link WeChatRequest}
     */
    public static <Req, Resp> WeChatRequest<Req, Resp> get(String url, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, RequestFilterChain filterChain, boolean needAccessToken) {
        return new DefaultWeChatRequest<>(url, null, responseClass, wechatConfig, weChatTokenService, filterChain, needAccessToken);
    }

    /**
     * Get请求
     *
     * @param url           url
     * @param responseClass 响应对象类型
     * @param wechatConfig  微信配置
     * @param filterChain   过滤器链
     * @return {@link WeChatRequest}
     */
    public static <Req, Resp> WeChatRequest<Req, Resp> get(String url, HttpHeaders httpHeaders, Class<Resp> responseClass, WeChatTokenService weChatTokenService, WeChatConfig wechatConfig, RequestFilterChain filterChain) {
        return new DefaultWeChatRequest<>(url, httpHeaders, responseClass, wechatConfig, weChatTokenService, filterChain);
    }

    /**
     * Post或Put请求
     *
     * @param url           url
     * @param responseClass 响应对象类型
     * @param wechatConfig  微信配置
     * @param filterChain   过滤器链
     * @return {@link WeChatRequest}
     */
    public static <Req, Resp> WeChatRequest<Req, Resp> postOrPut(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, Req requestBody, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, RequestFilterChain filterChain) {
        return postOrPut(url, httpMethod, httpHeaders, requestBody, responseClass, wechatConfig, weChatTokenService, filterChain, true);
    }

    public static <Req, Resp> WeChatRequest<Req, Resp> postOrPut(String url, HttpMethod httpMethod, HttpHeaders httpHeaders, Req requestBody, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, RequestFilterChain filterChain, boolean needAccessToken) {
        if (httpHeaders == null) {
            httpHeaders = new DefaultHttpHeaders();
        }
        if (HttpUtil.getContentType(httpHeaders) == null) {
            HttpUtil.setContentType(httpHeaders, HttpConstant.APPLICATION_JSON_UTF8);
        }
        return new DefaultWeChatRequest<>(url, httpMethod, httpHeaders, requestBody, responseClass, wechatConfig, weChatTokenService, filterChain, needAccessToken);
    }

    /**
     * Post请求
     *
     * @param url             url
     * @param requestBody     请求体
     * @param responseClass   响应对象类型
     * @param wechatConfig    微信配置
     * @param filterChain     过滤器链
     * @param needAccessToken 是否需要AccessToken
     * @return {@link WeChatRequest}
     */
    public static <Req, Resp> WeChatRequest<Req, Resp> post(String url, HttpHeaders httpHeaders, Req requestBody, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, RequestFilterChain filterChain, boolean needAccessToken) {
        return postOrPut(url, HttpMethod.POST, httpHeaders, requestBody, responseClass, wechatConfig, weChatTokenService, filterChain, needAccessToken);
    }

    /**
     * Post请求<br>
     * 支持Form文件上传(requestBody 实现{@link org.kangspace.wechat.helper.core.bean.MultipartRequest.Multipart})<br>
     * 如:
     * <pre>
     *   public class MediaUploadRequest implements MultipartRequest {
     *     private MediaConstant.MediaType type;
     *     private File media;
     *     private String contentType;
     *     public List&lt;Multipart&gt; getMultipartList() {
     *         File file = this.getMedia();
     *         if (!file.isFile()) {
     *             throw new IllegalArgumentException("media must be a file!");
     *         }
     *         return Arrays.asList(new Multipart(FILE_FORM_NAME, file.getName(), IOStreamUtil.toInputStream(file), this.getContentType()));
     *     }
     *     public List&lt;FormData&gt; getFormDataList() {
     *         return MultipartRequest.super.getFormDataList();
     *     }
     *   }
     * </pre>
     *
     * @param url             url
     * @param requestBody     请求体
     * @param responseClass   响应对象类型
     * @param wechatConfig    微信配置
     * @param filterChain     过滤器链
     * @param needAccessToken 是否需要AccessToken
     * @return {@link WeChatRequest}
     */
    public static <Req, Resp> WeChatRequest<Req, Resp> post(String url, Req requestBody, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, RequestFilterChain filterChain, boolean needAccessToken) {
        return post(url, null, requestBody, responseClass, wechatConfig, weChatTokenService, filterChain, needAccessToken);
    }

    /**
     * Post请求
     *
     * @param url           url
     * @param responseClass 响应对象类型
     * @param wechatConfig  微信配置
     * @param filterChain   过滤器链
     * @return {@link WeChatRequest}
     */
    public static <Req, Resp> WeChatRequest<Req, Resp> post(String url, Req requestBody, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, RequestFilterChain filterChain) {
        return post(url, null, requestBody, responseClass, wechatConfig, weChatTokenService, filterChain, true);
    }

    /**
     * Post请求
     *
     * @param url           url
     * @param responseClass 响应对象类型
     * @param wechatConfig  微信配置
     * @param filterChain   过滤器链
     * @return {@link WeChatRequest}
     */
    public static <Req, Resp> WeChatRequest<Req, Resp> put(String url, HttpHeaders httpHeaders, Req requestBody, Class<Resp> responseClass, WeChatConfig wechatConfig, WeChatTokenService weChatTokenService, RequestFilterChain filterChain) {
        return postOrPut(url, HttpMethod.PUT, httpHeaders, requestBody, responseClass, wechatConfig, weChatTokenService, filterChain);
    }
}
