package org.kangspace.wechat.helper.mp.message;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.core.message.GetMessageSignature;
import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.core.message.MessageSignature;
import org.kangspace.wechat.helper.core.message.response.WeChatEchoMessage;
import org.kangspace.wechat.helper.mp.DefaultWeChatMpService;
import org.kangspace.wechat.helper.mp.WeChatMpAppConstant;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;

/**
 * 微信公众号事件测试
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
@Slf4j
@RunWith(JUnit4.class)
public class WeChatMpMessageResolverTest {
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
        GetMessageSignature messageSignature = new GetMessageSignature(signatureStr, timestamp, nonce, echoStr);
        String resultEchoStr = resolver.checkSignature(messageSignature);
        log.info("echoStr: {}", resultEchoStr);
        Assert.assertNotNull(resultEchoStr);
    }

    /**
     * 事件测试<br>
     * /wechat-platform/message?signature=812895b1f140e1397f4576452383be3b3271b1f2&timestamp=1672033292&nonce=1313676274&openid=oOIaHt5IOo6rI8BH8IOiG3lA0yHU
     */
    @Test
    public void messageResolveEventTest() {
        resolver.addWeChatHandler(new WeChatMpMessageHandler() {
            @Override
            public WeChatMpEchoMessage handle(WeChatMpService service, WeChatMpMessage message, MessageResolverContext context) {
                return null;
            }

            @Override
            public Class<WeChatMpMessage> supportType() {
                return null;
            }
        });
        String rawMessage = "<xml>\n" +
                "    <ToUserName><![CDATA[gh_84671c4da479]]></ToUserName>\n" +
                "    <FromUserName><![CDATA[oMIE-6T2iTOgEdERSg26CU0KL8Og]]></FromUserName>\n" +
                "    <CreateTime>1672062036</CreateTime>\n" +
                "    <MsgType><![CDATA[text]]></MsgType>\n" +
                "    <Content><![CDATA[1]]></Content>\n" +
                "    <MsgId>23938173794149768</MsgId>\n" +
                "</xml>";
        log.info("rawMessage: {}", rawMessage);
        String timestamp = "1672062037";
        String nonce = "924856700";
        String encryptType = "aes";
        MessageSignature messageSignature = new MessageSignature(timestamp, nonce, encryptType);
        WeChatEchoMessage echoMessage = resolver.resolve(messageSignature, rawMessage);

        // TODO xxx
        String message = "";
//        resolver.addWeChatHandler();
//        resolver.resolve();
    }

    /**
     * 消息测试(明文)<br>
     * /wechat-platform/message?signature=812895b1f140e1397f4576452383be3b3271b1f2&timestamp=1672033292&nonce=1313676274&openid=oOIaHt5IOo6rI8BH8IOiG3lA0yHU
     */
    @Test
    public void messageResolveMessageTest() {
        addMessageResolvers();
        String rawMessage = "<xml>\n" +
                "    <ToUserName><![CDATA[gh_84671c4da479]]></ToUserName>\n" +
                "    <FromUserName><![CDATA[oMIE-6T2iTOgEdERSg26CU0KL8Og]]></FromUserName>\n" +
                "    <CreateTime>1672062036</CreateTime>\n" +
                "    <MsgType><![CDATA[text]]></MsgType>\n" +
                "    <Content><![CDATA[1]]></Content>\n" +
                "    <MsgId>23938173794149768</MsgId>\n" +
                "</xml>";
        log.info("rawMessage: {}", rawMessage);
        String timestamp = "1672033292";
        String nonce = "1313676274";
        String signature = "812895b1f140e1397f4576452383be3b3271b1f2";
        MessageSignature messageSignature = new MessageSignature(timestamp, nonce, signature);
        WeChatEchoMessage echoMessage = resolver.resolve(messageSignature, rawMessage);
        String echo = resolver.resolveEcho(messageSignature, rawMessage);
        log.info("echoMessage: {}", echoMessage);
        log.info("echo: {}", echo);
    }

    /**
     * 添加消息解析器
     */
    private void addMessageResolvers() {
        // 同步消息
        resolver.addWeChatHandler(new WeChatMpMessageHandler() {
            @Override
            public WeChatMpEchoMessage handle(WeChatMpService service, WeChatMpMessage message, MessageResolverContext context) {
                log.info("同步处理: message: {}", message);
                // TODO
                return null;
            }

            @Override
            public Class<? extends WeChatMpMessage> supportType() {
                return WeChatMpMessages.TEXT.getMappingClass();
            }
        });
        // 异步消息
        resolver.addWeChatHandler(new WeChatMpMessageHandler() {
            @Override
            public WeChatMpEchoMessage handle(WeChatMpService service, WeChatMpMessage message, MessageResolverContext context) {
                log.info("");
                return null;
            }

            @Override
            public Class<WeChatMpMessage> supportType() {
                return null;
            }

            @Override
            public boolean isAsync() {
                return true;
            }
        });
        // 异步消息2
        resolver.addWeChatHandler(new WeChatMpMessageHandler() {
            @Override
            public WeChatMpEchoMessage handle(WeChatMpService service, WeChatMpMessage message, MessageResolverContext context) {
                log.info("");
                return null;
            }

            @Override
            public Class<WeChatMpMessage> supportType() {
                return null;
            }

            @Override
            public boolean isAsync() {
                return true;
            }
        });
    }
}
