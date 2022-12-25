package org.kangspace.wechat.helper.mp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.core.message.MessageSignature;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessageResolver;

/**
 * 微信公众号事件测试
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
@Slf4j
@RunWith(JUnit4.class)
public class WeChatMpMessageTest {
    private final String appId = WeChatMpAppConstant.GLOBAL_APPID;
    private final String appSecret = WeChatMpAppConstant.GLOBAL_APPSECRET;
    private final String token = WeChatMpAppConstant.GLOBAL_TOKEN;
    private WeChatMpMessageResolver resolver;

    @Before
    public void before() {
        WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
        weChatMpConfig.setToken(token);
        WeChatMpService weChatMpService = new DefaultWeChatMpService(weChatMpConfig);
        resolver = new WeChatMpMessageResolver(weChatMpService);
    }

    /**
     * 签名验证测试<br>
     * 如: signature=8cba18b0eed872066919a8744b0f279b0fd8abfd&echostr=4011207248104127935&timestamp=1671953598&nonce=747722185 <br>
     */
    @Test
    public void checkSignatureTest() {
        String signatureStr = "8cba18b0eed872066919a8744b0f279b0fd8abfd";
        String echoStr = "4011207248104127935";
        String nonce = "747722185";
        String timestamp = "1671953598";
        MessageSignature messageSignature = new MessageSignature(signatureStr, timestamp, nonce, echoStr);
        String resultEchoStr = resolver.checkSignature(messageSignature);
        log.info("echoStr: {}", resultEchoStr);
        Assert.assertTrue(resultEchoStr != null);
    }

    @Test
    public void messageResolveTest() {
        // TODO xxx
        String message = "";
//        resolver.addWeChatHandler();
//        resolver.resolve();
    }

}
