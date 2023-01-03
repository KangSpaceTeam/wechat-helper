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
import org.kangspace.wechat.helper.mp.event.MenuClickEvent;
import org.kangspace.wechat.helper.mp.message.response.TextEchoMessage;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoXmlMessage;

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
    private final String encodingAesKey = WeChatMpAppConstant.GLOBAL_ENCODING_AES_KEY;
    private WeChatMpMessageResolver resolver;

    @Before
    public void before() {
        WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
        weChatMpConfig.setToken(token);
        weChatMpConfig.setEncodingAESKey(encodingAesKey);
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
        boolean checkSignature = resolver.checkSignature(messageSignature);
        log.info("checkSignature: {}", checkSignature);
        Assert.assertTrue(checkSignature);
    }

    /**
     * 事件测试<br>
     * /wechat-platform/message?signature=812895b1f140e1397f4576452383be3b3271b1f2&timestamp=1672033292&nonce=1313676274&openid=oOIaHt5IOo6rI8BH8IOiG3lA0yHU
     */
    @Test
    public void messageResolveEventTest() {
        addEventResolvers();
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
        MessageSignature messageSignature = new MessageSignature(signature, timestamp, nonce);
        WeChatEchoMessage echoMessage = resolver.resolve(messageSignature, rawMessage);
        String echo = resolver.resolveEcho(messageSignature, rawMessage);
        log.info("echoMessage: {}", echoMessage);
        log.info("echo: {}", echo);
    }

    /**
     * 消息测试(明文)<br>
     * <pre>
     * POST /wechat-platform/message?signature=f0b32354a7dbb3a81d6b581ce8630c890c639dc4&timestamp=1672369434&nonce=868403012&openid=oMIE-6T2iTOgEdERSg26CU0KL8Og
     * </pre>
     */
    @Test
    public void messageResolveMessageTest() {
        addMessageResolvers();
        String rawMessage = "<xml><ToUserName><![CDATA[gh_84671c4da479]]></ToUserName>\n" +
                "<FromUserName><![CDATA[oMIE-6T2iTOgEdERSg26CU0KL8Og]]></FromUserName>\n" +
                "<CreateTime>1672369434</CreateTime>\n" +
                "<MsgType><![CDATA[text]]></MsgType>\n" +
                "<Content><![CDATA[1]]></Content>\n" +
                "<MsgId>23942570635195977</MsgId>\n" +
                "</xml>";
        log.info("rawMessage: {}", rawMessage);
        String timestamp = "1672369434";
        String nonce = "868403012";
        String signature = "f0b32354a7dbb3a81d6b581ce8630c890c639dc4";
        MessageSignature messageSignature = new MessageSignature(signature, timestamp, nonce);
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
        resolver.addWeChatHandler(new WeChatMpMessageHandler<TextMessage>() {
            @Override
            public WeChatMpEchoMessage handle(WeChatMpService service, TextMessage message, MessageResolverContext context) {
                log.info("同步处理1, 有返回值: message: {}, context: {}", message, context);
                return new TextEchoMessage(message.getToUser(), message.getFromUser(), message.getCreateTime(), message.getMsgId(), message.getContent() + "_同步处理1");
            }

            @Override
            public Class<TextMessage> supportType() {
                return TextMessage.class;
            }
        });
        // 同步消息2
        resolver.addWeChatHandler(new WeChatMpMessageHandler<TextMessage>() {
            @Override
            public void execute(WeChatMpService service, TextMessage message, MessageResolverContext context) {
                log.info("同步处理2, 无返回值: message: {}, context: {}", message, context);
            }

            @Override
            public Class<TextMessage> supportType() {
                return TextMessage.class;
            }
        });

        // 异步消息
        resolver.addWeChatHandler(new WeChatMpMessageHandler<WeChatMpXmlMessage>() {
            @Override
            public WeChatMpEchoMessage handle(WeChatMpService service, WeChatMpXmlMessage message, MessageResolverContext context) {
                log.info("异步处理1, 有返回值: message: {}, context: {}", message, context);
                return new WeChatMpEchoXmlMessage(message.getToUser(), message.getFromUser(), message.getCreateTime(), message.getMsgId());
            }

            @Override
            public Class<WeChatMpXmlMessage> supportType() {
                return WeChatMpXmlMessage.class;
            }

            @Override
            public boolean isAsync() {
                return true;
            }
        });
        // 异步消息2
        resolver.addWeChatHandler(new WeChatMpMessageHandler<TextMessage>() {
            @Override
            public void execute(WeChatMpService service, TextMessage message, MessageResolverContext context) {
                log.info("异步处理2, 无返回值 message: {}, context: {}", message, context);
            }

            @Override
            public Class<TextMessage> supportType() {
                return TextMessage.class;
            }

            @Override
            public boolean isAsync() {
                return true;
            }
        });
    }

    /**
     * 添加事件消息解析器
     */
    private void addEventResolvers() {
        // 同步消息
        resolver.addWeChatHandler(new WeChatMpMessageHandler<MenuClickEvent>() {
            @Override
            public WeChatMpEchoMessage handle(WeChatMpService service, MenuClickEvent event, MessageResolverContext context) {
                log.info("同步处理1, 有返回值: message: {}, context: {}", event, context);
                return new TextEchoMessage(event.getToUser(), event.getFromUser(), event.getCreateTime(), event.getMsgId(), event.getRaw());
            }

            @Override
            public Class<MenuClickEvent> supportType() {
                return MenuClickEvent.class;
            }
        });
        // 同步消息2
        resolver.addWeChatHandler(new WeChatMpMessageHandler<TextMessage>() {
            @Override
            public void execute(WeChatMpService service, TextMessage message, MessageResolverContext context) {
                log.info("同步处理2, 无返回值: message: {}, context: {}", message, context);
            }

            @Override
            public Class<TextMessage> supportType() {
                return TextMessage.class;
            }
        });

        // 异步消息
        resolver.addWeChatHandler(new WeChatMpMessageHandler<WeChatMpMessage>() {
            @Override
            public WeChatMpEchoMessage handle(WeChatMpService service, WeChatMpMessage message, MessageResolverContext context) {
                log.info("异步处理1, 有返回值: message: {}, context: {}", message, context);
                return new WeChatMpEchoXmlMessage();
            }

            @Override
            public Class<WeChatMpMessage> supportType() {
                return WeChatMpMessage.class;
            }

            @Override
            public boolean isAsync() {
                return true;
            }
        });
        // 异步消息2
        resolver.addWeChatHandler(new WeChatMpMessageHandler<TextMessage>() {
            @Override
            public void execute(WeChatMpService service, TextMessage message, MessageResolverContext context) {
                log.info("异步处理2, 无返回值 message: {}, context: {}", message, context);
            }

            @Override
            public Class<TextMessage> supportType() {
                return TextMessage.class;
            }

            @Override
            public boolean isAsync() {
                return true;
            }
        });
    }
}
