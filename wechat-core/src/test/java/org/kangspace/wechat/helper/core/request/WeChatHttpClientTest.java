package org.kangspace.wechat.helper.core.request;

import com.google.gson.annotations.SerializedName;
import io.netty.handler.codec.http.HttpMethod;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufMono;

import java.util.Optional;

/**
 * WeChatHttpClient Test
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/6
 */
@Slf4j
@RunWith(JUnit4.class)
public class WeChatHttpClientTest {

    /**
     * Json请求响应HttpClient
     */
    private WeChatHttpClient weChatHttpClient;
    /**
     * 字符串请求响应HttpClient
     */
    private WeChatHttpClient stringWeChatHttpClient;

    @Before
    public void initWeChatHttpClient() {
        weChatHttpClient = new DefaultWeChatHttpClient();
        stringWeChatHttpClient = new StringWeChatHttpClient();
    }

    /**
     * execute请求测试
     */
    @Test
    public void executeTest() {
        WeChatHttpClient client = weChatHttpClient;
        String url = "http://ip.kangspace.org";
        HttpMethod method = HttpMethod.GET;
        WeChatResponse<String> response = client.execute(url, method, null, null);
        log.info("url: {}", url);
        log.info("response:src: {}, string: {}", response.getContent(), ((WeChatNettyResponse<ByteBufMono>) response).getContentString());
    }

    /**
     * execute请求测试
     */
    @Test
    public void executeWithResponseDataTest() {
        WeChatHttpClient client = weChatHttpClient;
        String url = "https://ip.kangspace.org?type=json";
        HttpMethod method = HttpMethod.GET;
        WeChatResponse<IpResponseDataBean> response = client.execute(url, method, null, null, IpResponseDataBean.class);
        log.info("url: {}", url);
        log.info("response:src: {}, string:{}", response.getContent(), ((WeChatNettyResponse<ByteBufMono>) response).getContentString());

    }

    /**
     * executeAsync 请求测试
     */
    @Test
    public void executeAsyncTest() {
        WeChatHttpClient client = stringWeChatHttpClient;
        String url = "http://ip.kangspace.org?type=json";
        HttpMethod method = HttpMethod.GET;
        Mono<WeChatResponse<String>> response = client.executeAsync(url, method, null, null);
        WeChatResponse<String> responseStr = response.block();
        log.info("url: {}", url);
        log.info("response:src: {}", Optional.ofNullable(responseStr).get().getContent());
    }

    /**
     * 响应数据Bean
     */
    @Data
    public static class IpResponseDataBean {
        @SerializedName("Host")
        private String host;
        @SerializedName("YourIp")
        private String yourIp;
    }
}
