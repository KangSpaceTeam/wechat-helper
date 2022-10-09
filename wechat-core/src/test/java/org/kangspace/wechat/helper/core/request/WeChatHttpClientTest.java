package org.kangspace.wechat.helper.core.request;

import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpMethod;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClientResponse;

/**
 * WeChatHttpClient Test
 * @author kango2gler@gmail.com
 * @since 2022/10/6
 */
@Slf4j
@RunWith(JUnit4.class)
public class WeChatHttpClientTest {

    private WeChatHttpClient weChatHttpClient;
    @Before
    public void  initWeChatHttpClient(){
        weChatHttpClient = new DefaultWeChatHttpClient();
    }


    /**
     * Get请求测试
     */
    @Test
    public void executeTest(){
        WeChatHttpClient client = weChatHttpClient;
        String url = "http://proxy.kangspace.org";
//        String url = "https://baidu.com";
        HttpMethod method = HttpMethod.GET;
//        Mono<FullHttpResponse> response  = client.executeAsync(url, method, null, null);
        FullHttpResponse response  = client.execute(url, method, null, null);
        log.info("url:{}", url);
        log.info("response:{}", response);

    }
    /**
     * Get请求测试
     */
    public void getTest(){

    }
}
