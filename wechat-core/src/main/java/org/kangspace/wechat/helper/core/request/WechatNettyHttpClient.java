package org.kangspace.wechat.helper.core.request;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelOption;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.timeout.ReadTimeoutHandler;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.kangspace.devhelper.CollectionUtil;
import org.kangspace.wechat.helper.core.bean.AttachmentResponse;
import org.kangspace.wechat.helper.core.bean.MultipartRequest;
import org.kangspace.wechat.helper.core.config.WeChatConfig;
import org.kangspace.wechat.helper.core.request.serialize.DataSerializer;
import org.kangspace.wechat.helper.core.request.serialize.DataSerializerFactory;
import org.kangspace.wechat.helper.core.request.serialize.DataSerializerScope;
import org.kangspace.wechat.helper.core.request.serialize.DataSerializers;
import org.kangspace.wechat.helper.core.util.ProjectCore;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufMono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.client.HttpClientResponse;
import reactor.netty.resources.ConnectionProvider;

import javax.annotation.Nonnull;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * 微信HttpClient
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/4
 */
@Slf4j
@Getter
public class WechatNettyHttpClient implements WeChatHttpClient {
    private static final ConnectionProvider DEFAULT_CONNECTION_PROVIDER = ConnectionProvider.builder("WechatNettyHttpClientPool").build();
    /**
     * 请求配置
     */
    private final WeChatConfig.RequestConfig requestConfig;
    /**
     * 数据序列化列表
     */
    private final DataSerializers dataSerializers;


    public WechatNettyHttpClient() {
        this(null, DataSerializerFactory.defaultSerializers());
    }

    public WechatNettyHttpClient(WeChatConfig WeChatConfig, DataSerializers dataSerializers) {
        this.requestConfig = WeChatConfig != null ? WeChatConfig.requestConfig() : new WeChatConfig.RequestConfig();
        this.dataSerializers = dataSerializers != null ? dataSerializers : new DataSerializers();
    }

    /**
     * 获取AttachmentResponse文件对象
     *
     * @param response      {@link HttpClientResponse}
     * @param body          文件流
     * @param responseClass 响应对象类型
     * @return {@link AttachmentResponse}
     */
    private <ResponseBody> ResponseBody fetchAttachmentResponse(HttpClientResponse response, ByteBuf body, Class<ResponseBody> responseClass) {
        // 文件保存路径
        String savePath = requestConfig.getDownloadPath();
        // 文件解析器解析文件内容到指定目录
        return this.getDataSerializers().getAttachmentResponseSerializer().deserialize(response, savePath, body, responseClass);
    }

    /**
     * Http响应处理
     *
     * @param response         {@link HttpClientResponse}
     * @param attachmentHandle 文件响应处理
     * @param normalHandle     正常请求响应处理
     * @return Mono&lt;WeChatResponse&gt;
     */
    private static <ResponseBody> Mono<WeChatResponse<ResponseBody>> responseHandler(HttpClientResponse response,
                                                                                     Supplier<Mono<WeChatResponse<ResponseBody>>> attachmentHandle,
                                                                                     Supplier<Mono<WeChatResponse<ResponseBody>>> normalHandle) {
        if (HttpUtil.isAttachmentResponse(response)) {
            return attachmentHandle.get();
        }
        return normalHandle.get();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <RequestBody, ResponseBody> Mono<WeChatResponse<ResponseBody>> executeAsync(String uri, HttpMethod httpMethod, HttpHeaders httpHeaders, RequestBody requestBody, Class<ResponseBody> responseClass) {
        HttpUtil.contentTypeRequestHeaderAutoSet(httpHeaders, requestBody);
        HttpClient client = newClientWithConfig(httpHeaders);
        HttpClient.RequestSender requestSender = client.followRedirect(true).request(httpMethod).uri(uri);
        log.debug("httpClient executeAsync: uri:{}", uri);
        if (requestBody != null) {
            if (requestBody instanceof MultipartRequest) {
                MultipartRequest request = ((MultipartRequest) requestBody);
                // 文件上传
                requestSender = (HttpClient.RequestSender) requestSender.sendForm((req, form) -> {
                    form.multipart(true);
                    List<MultipartRequest.Multipart> multipartList;
                    if (CollectionUtil.isNotEmpty((multipartList = request.getMultipartList()))) {
                        multipartList.forEach(part -> form.file(part.getName(), part.getFileName(), part.getStream(), part.getContentType()));
                    }
                    List<MultipartRequest.FormData> formDataList;
                    if (CollectionUtil.isNotEmpty((formDataList = request.getFormDataList()))) {
                        formDataList.forEach(formData -> form.attr(formData.getName(), formData.getValue()));
                    }
                });
            } else {
                // 请求序列化类
                requestSender = (HttpClient.RequestSender) requestSender.send(requestDataSerialize(HttpUtil.getContentType(httpHeaders), requestBody));
            }
        }
        return requestSender.responseSingle((response, byteBufMono) -> {
                    Map<String, String> responseHeaders = WeChatNettyResponse.toHeaders(response.responseHeaders());
                    Map<String, Set<String>> cookies = WeChatNettyResponse.toCookies(response.cookies());
                    return responseHandler(response,
                            // 文件响应, 解析文件 Content-disposition: attachment; filename=""
                            () -> byteBufMono.map(byteBuf -> {
                                ResponseBody responseBody = fetchAttachmentResponse(response, byteBuf, responseClass);
                                return new WeChatNettyResponse<>(response.status().code(), responseBody, responseHeaders, cookies);
                            }),
                            // 普通请求响应
                            () -> byteBufMono.asString()
                                    .map(resp -> (WeChatResponse<ResponseBody>) (
                                            new WeChatNettyResponse<>(response.status().code(), responseDataSerialize(response, resp, responseClass), responseHeaders, cookies)))
                                    .switchIfEmpty(Mono.defer(() ->
                                            Mono.just((WeChatResponse<ResponseBody>) (new WeChatNettyResponse<>(response.status().code(), null, responseHeaders, cookies)))))
                    );
                }
        );
    }

    /**
     * 获取基于配置的HttpClient
     *
     * @param httpHeaders 请求头
     * @return {@link HttpClient}
     */
    private HttpClient newClientWithConfig(HttpHeaders httpHeaders) {
        HttpHeaders newHeaders = buildDefaultHttpHeaders(httpHeaders);
        return HttpClient.create(DEFAULT_CONNECTION_PROVIDER)
                // socket timeout
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, requestConfig.getConnectionTimeout())
                // read timeout
                .doOnConnected(t -> t.addHandlerFirst(new ReadTimeoutHandler(requestConfig.getReadTimeout(), TimeUnit.SECONDS)))
                .compress(this.requestConfig.isCompress()).followRedirect(this.requestConfig.isFollowRedirect())
                .keepAlive(this.requestConfig.isKeepAlive())
                .headers(headers -> headers.add(newHeaders));
    }

    /**
     * 设置默认请求头(如UserAgent等)
     *
     * @param httpHeaders {@link HttpHeaders}
     * @return {@link HttpHeaders}
     */
    private HttpHeaders buildDefaultHttpHeaders(HttpHeaders httpHeaders) {
        if (httpHeaders == null) {
            httpHeaders = new DefaultHttpHeaders();
        }
        // UserAgent设置 wechat-helper/x.x.x
        if (!httpHeaders.contains(HttpConstant.USER_AGENT_NAME)) {
            httpHeaders.set(HttpConstant.USER_AGENT_NAME, ProjectCore.USER_AGENT);
        }
        return httpHeaders;
    }

    /**
     * request 请求数据处理
     *
     * @param requestBody 请求体
     * @return {@link ByteBufMono}
     */
    @Nonnull
    @SuppressWarnings("unchecked")
    private ByteBufMono requestDataSerialize(String contentType, Object requestBody) {
        List<? extends DataSerializer<?>> serializers = this.dataSerializers.getDataSerializers(contentType, DataSerializerScope.REQUEST);
        log.debug("request dataSerializes:  contentType: {}, serializers: {}", contentType, serializers);
        Iterator<DataSerializer<Object>> iterator = (Iterator<DataSerializer<Object>>) serializers.iterator();
        String buf;
        while (iterator.hasNext()) {
            DataSerializer<Object> dataSerializer = iterator.next();
            if ((buf = dataSerializer.serialize(requestBody)) != null) {
                log.debug("request serializes result: {}", buf);
                return ByteBufMono.fromString(Mono.just(buf));
            }
        }
        buf = requestBody instanceof String ? (String) requestBody : requestBody.toString();
        log.debug("request serializes result: {}", buf);
        return ByteBufMono.fromString(Mono.just(buf));
    }

    /**
     * response 请求数据处理
     *
     * @param responseData 请求体
     * @return {@link Object}
     */
    @SuppressWarnings("unchecked")
    private <ResponseBody> ResponseBody responseDataSerialize(HttpClientResponse response, String responseData, Class<ResponseBody> responseClass) {
        String contentType = HttpUtil.getContentType(response);
        List<? extends DataSerializer<?>> serializers = this.dataSerializers.getDataSerializers(contentType, DataSerializerScope.RESPONSE, responseData);
        log.debug("response dataSerializes: contentType: {}, serializers: {}, responseData: {}", contentType, serializers, responseData);
        Iterator<DataSerializer<ResponseBody>> iterator = (Iterator<DataSerializer<ResponseBody>>) serializers.iterator();
        ResponseBody data;
        while (iterator.hasNext()) {
            DataSerializer<ResponseBody> dataSerializer = iterator.next();
            if ((data = dataSerializer.deserialize(responseData, responseClass)) != null) {
                return data;
            }
        }
        return responseClass.equals(String.class) ? (ResponseBody) responseData : null;
    }
}
