package org.kangspace.wechat.helper.core.request;

import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import io.netty.buffer.*;
import io.netty.channel.ChannelOption;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.timeout.ReadTimeoutHandler;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.env.WeChatConfig;
import org.kangspace.wechat.helper.core.util.JSONUtil;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufMono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.client.HttpClientResponse;
import reactor.netty.resources.ConnectionProvider;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 微信HttpClient
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/4
 */
@Slf4j
@Getter
public class WechatNettyHttpClient implements WeChatHttpClient {
    private WeChatConfig.RequestConfig requestConfig;

    public WechatNettyHttpClient() {
        this(null);
    }

    public WechatNettyHttpClient(WeChatConfig weChatConfig) {
        this.requestConfig = weChatConfig != null ? weChatConfig.getRequest() : new WeChatConfig.RequestConfig();
    }

    @Override
    public WeChatResponse<ByteBufMono> execute(String uri, HttpMethod httpMethod, HttpHeaders httpHeaders, Object requestBody) {
        return executeAsync(uri, httpMethod, httpHeaders, requestBody).block();
    }

    @Override
    public Mono<WeChatResponse<ByteBufMono>> executeAsync(String uri, HttpMethod httpMethod, HttpHeaders httpHeaders, Object requestBody) {
        HttpClient client = newClientWithConfig(httpHeaders);
        HttpClient.RequestSender requestSender = client.request(httpMethod).uri(uri);
        if (requestBody != null) {
            String body = JSONUtil.toJsonString(requestBody);
            requestSender = (HttpClient.RequestSender) requestSender.send(ByteBufMono.fromString(Mono.just(body)));
        }
        return requestSender.responseSingle((response, byteBufMono) ->
                Mono.just(new WeChatNettyResponse<>(response.status().code(), byteBufMono,
                        WeChatNettyResponse.toHeaders(response.responseHeaders()),
                        WeChatNettyResponse.toCookies(response.cookies())
                )));
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
                .doOnConnected(t -> t.addHandlerFirst(new ReadTimeoutHandler(requestConfig.getReadTimeout(), TimeUnit.SECONDS)))
                .compress(this.requestConfig.isCompress())
                .followRedirect(this.requestConfig.isFollowRedirect())
                .keepAlive(this.requestConfig.isKeepAlive());
        if (httpHeaders != null) {
            client.headers(headers -> headers.add(httpHeaders));
        }
        return client;
    }

}
