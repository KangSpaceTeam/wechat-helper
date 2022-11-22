package org.kangspace.wechat.helper.core.request;

import io.netty.channel.ChannelOption;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.timeout.ReadTimeoutHandler;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.env.WeChatConfig;
import org.kangspace.wechat.helper.core.request.serialize.DataSerializer;
import org.kangspace.wechat.helper.core.request.serialize.DataSerializerFactory;
import org.kangspace.wechat.helper.core.request.serialize.DataSerializerScope;
import org.kangspace.wechat.helper.core.request.serialize.DataSerializers;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufMono;
import reactor.netty.http.client.HttpClient;
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
    private final WeChatConfig.RequestConfig requestConfig;
    /**
     * 数据序列化列表
     */
    private final DataSerializers<?> dataSerializers;


    public WechatNettyHttpClient() {
        this(null, DataSerializerFactory.defaultJsonSerializers());
    }

    public WechatNettyHttpClient(WeChatConfig weChatConfig, DataSerializers<?> dataSerializers) {
        this.requestConfig = weChatConfig != null ? weChatConfig.getRequest() : new WeChatConfig.RequestConfig();
        this.dataSerializers = dataSerializers != null ? dataSerializers : new DataSerializers<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <RequestBody, ResponseBody> Mono<WeChatResponse<ResponseBody>> executeAsync(String uri, HttpMethod httpMethod, HttpHeaders httpHeaders, RequestBody requestBody, Class<ResponseBody> responseClass) {
        HttpClient client = newClientWithConfig(httpHeaders);
        HttpClient.RequestSender requestSender = client.request(httpMethod).uri(uri);
        log.debug("WechatNettyHttpClient executeAsync: uri:{}, method:{}", uri, httpMethod);
        if (requestBody != null) {
            // 请求序列化类
            requestSender = (HttpClient.RequestSender) requestSender.send(requestDataSerialize(requestBody));
        }
        return requestSender.responseSingle((response, byteBufMono) ->
                byteBufMono.asString().map(resp -> new WeChatNettyResponse<>(response.status().code(),
                        responseDataSerialize(resp, responseClass),
                        WeChatNettyResponse.toHeaders(response.responseHeaders()),
                        WeChatNettyResponse.toCookies(response.cookies()))));
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
    private ByteBufMono requestDataSerialize(Object requestBody) {
        List<? extends DataSerializer<?>> serializers = this.dataSerializers.getDataSerializers(DataSerializerScope.REQUEST);
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
    private <ResponseBody> ResponseBody responseDataSerialize(String responseData, Class<ResponseBody> responseClass) {
        List<? extends DataSerializer<?>> serializers = this.dataSerializers.getDataSerializers(DataSerializerScope.RESPONSE);
        Iterator<DataSerializer<ResponseBody>> iterator = (Iterator<DataSerializer<ResponseBody>>) serializers.iterator();
        ResponseBody data;
        while (iterator.hasNext()) {
            DataSerializer<ResponseBody> dataSerializer = iterator.next();
            if ((data = dataSerializer.deserialize(responseData, responseClass)) != null) {
                return data;
            }
        }
        return responseClass.equals(String.class)? (ResponseBody) responseData : null;
    }
}
