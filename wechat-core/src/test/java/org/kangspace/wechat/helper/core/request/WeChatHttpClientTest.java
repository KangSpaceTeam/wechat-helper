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

/**
 * WeChatHttpClient Test
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/6
 */
@Slf4j
@RunWith(JUnit4.class)
public class WeChatHttpClientTest {

    private WeChatHttpClient weChatHttpClient;

    @Before
    public void initWeChatHttpClient() {
        weChatHttpClient = new DefaultWeChatHttpClient();
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
        log.info("url:{}", url);
        log.info("response:src:{}, string:{}", response.getContent(), ((WeChatNettyResponse<ByteBufMono>) response).getContentString());
    }

    /**
     * execute请求测试
     */
    @Test
    public void executeWithResponseDataTest() {
        WeChatHttpClient client = weChatHttpClient;
        String url = "http://ip.kangspace.org?type=json";
        HttpMethod method = HttpMethod.GET;
        WeChatResponse<IpResponseDataBean> response = client.execute(url, method, null, null, IpResponseDataBean.class);
        log.info("url:{}", url);
        log.info("response:src:{}, string:{}", response.getContent(), ((WeChatNettyResponse<ByteBufMono>) response).getContentString());

    }

    /**
     * executeAsync 请求测试
     */
    @Test
    public void executeAsyncTest() {
        WeChatHttpClient client = weChatHttpClient;
        String url = "http://ip.kangspace.org";
        HttpMethod method = HttpMethod.GET;
        Mono<WeChatResponse<String>> response = client.executeAsync(url, method, null, null);
        log.info("url:{}", url);
        log.info("response:src:{}, decode:{}", response.block());
    }

    /**
     * Get请求测试
     */
    public void getTest() {

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
