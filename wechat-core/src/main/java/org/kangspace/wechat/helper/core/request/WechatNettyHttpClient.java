package org.kangspace.wechat.helper.core.request;

import io.netty.channel.ChannelOption;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.timeout.ReadTimeoutHandler;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.config.WeChatRequestConfig;
import org.kangspace.wechat.helper.core.request.serialize.DataSerializer;
import org.kangspace.wechat.helper.core.request.serialize.DataSerializerFactory;
import org.kangspace.wechat.helper.core.request.serialize.DataSerializerScope;
import org.kangspace.wechat.helper.core.request.serialize.DataSerializers;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufMono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.client.HttpClientResponse;
import reactor.netty.resources.ConnectionProvider;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 微信HttpClient
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/4
 */
@Slf4j
@Getter
public class WechatNettyHttpClient implements WeChatHttpClient {
    /**
     * 请求配置
     */
    private final WeChatRequestConfig.RequestConfig requestConfig;
    /**
     * 数据序列化列表
     */
    private final DataSerializers dataSerializers;


    public WechatNettyHttpClient() {
        this(null, DataSerializerFactory.defaultSerializers());
    }

    public WechatNettyHttpClient(WeChatRequestConfig weChatRequestConfig, DataSerializers dataSerializers) {
        this.requestConfig = weChatRequestConfig != null ? weChatRequestConfig.getRequest() : new WeChatRequestConfig.RequestConfig();
        this.dataSerializers = dataSerializers != null ? dataSerializers : new DataSerializers();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <RequestBody, ResponseBody> Mono<WeChatResponse<ResponseBody>> executeAsync(String uri, HttpMethod httpMethod, HttpHeaders httpHeaders, RequestBody requestBody, Class<ResponseBody> responseClass) {
        contentTypeRequestHeaderAutoSet(httpHeaders, requestBody);
        HttpClient client = newClientWithConfig(httpHeaders);
        HttpClient.RequestSender requestSender = client.request(httpMethod).uri(uri);
        log.debug("WechatNettyHttpClient executeAsync: uri:{}, method:{}", uri, httpMethod);
        if (requestBody != null) {
            // 请求序列化类
            requestSender = (HttpClient.RequestSender) requestSender.send(requestDataSerialize(HttpUtil.getContentType(httpHeaders), requestBody));
        }
        return requestSender.responseSingle((response, byteBufMono) ->
                byteBufMono.asString().map(resp -> new WeChatNettyResponse<>(response.status().code(),
                        responseDataSerialize(response, resp, responseClass),
                        WeChatNettyResponse.toHeaders(response.responseHeaders()),
                        WeChatNettyResponse.toCookies(response.cookies()))));
    }

    /**
     * ContentType自动设置
     *
     * @param httpHeaders 请求头
     * @param requestBody 请求体
     */
    public <RequestBody> void contentTypeRequestHeaderAutoSet(HttpHeaders httpHeaders, RequestBody requestBody) {
        if (requestBody == null || HttpUtil.getContentType(httpHeaders) == null) {
            return;
        }
        String contentType = HttpHeaderValues.TEXT_PLAIN.toString();
        if (!(requestBody instanceof String)) {
            contentType = HttpHeaderValues.APPLICATION_JSON.toString();
        }
        httpHeaders.add(HttpHeaderNames.CONTENT_TYPE, contentType);
    }

    /**
     * 获取基于配置的HttpClient
     *
     * @param httpHeaders 请求头
     * @return {@link HttpClient}
     */
    private HttpClient newClientWithConfig(HttpHeaders httpHeaders) {
        ConnectionProvider connectionProvider = ConnectionProvider.builder("WechatNettyHttpClientPool").build();
        HttpClient client = HttpClient.create(connectionProvider)
                // socket timeout
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, requestConfig.getConnectionTimeout())
                // read timeout
                .doOnConnected(t -> t.addHandlerFirst(new ReadTimeoutHandler(requestConfig.getReadTimeout(), TimeUnit.SECONDS))).compress(this.requestConfig.isCompress()).followRedirect(this.requestConfig.isFollowRedirect()).keepAlive(this.requestConfig.isKeepAlive());
        if (httpHeaders != null) {
            client.headers(headers -> headers.add(httpHeaders));
        }
        return client;
    }

    /**
     * request 请求数据处理
     *
     * @param requestBody 请求体
     * @return {@link ByteBufMono}
     */
    @SuppressWarnings("unchecked")
    private ByteBufMono requestDataSerialize(String contentType, Object requestBody) {
        List<? extends DataSerializer<?>> serializers = this.dataSerializers.getDataSerializers(contentType, DataSerializerScope.REQUEST);
        Iterator<DataSerializer<Object>> iterator = (Iterator<DataSerializer<Object>>) serializers.iterator();
        String buf;
        while (iterator.hasNext()) {
            DataSerializer<Object> dataSerializer = iterator.next();
            if ((buf = dataSerializer.serialize(requestBody)) != null) {
                return ByteBufMono.fromString(Mono.just(buf));
            }
        }
        buf = requestBody instanceof String ? (String) requestBody : requestBody.toString();
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
        List<? extends DataSerializer<?>> serializers = this.dataSerializers.getDataSerializers(HttpUtil.getContentType(response), DataSerializerScope.RESPONSE);
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
