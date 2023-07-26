package org.kangspace.wechat.helper.work.message;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.core.message.MessageSignature;
import org.kangspace.wechat.helper.core.message.response.WeChatEchoMessage;
import org.kangspace.wechat.helper.work.DefaultWeComService;
import org.kangspace.wechat.helper.work.WeComAppConstant;
import org.kangspace.wechat.helper.work.WeComService;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;

/**
 * 企业微信事件测试
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
@Slf4j
@RunWith(JUnit4.class)
public class WeComMessageResolverTest {
    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private final String token = WeComAppConstant.GLOBAL_TOKEN;
    private final String encodingAesKey = WeComAppConstant.GLOBAL_ENCODING_AES_KEY;
    private WeComMessageResolver resolver;

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        WeComService weComService = new DefaultWeComService(weComAccessTokenService);
        resolver = new WeComMessageResolver(weComService);
    }


    /**
     * 事件测试<br>
     * /wechat-platform/message?signature=812895b1f140e1397f4576452383be3b3271b1f2&timestamp=1672033292&nonce=1313676274&openid=oOIaHt5IOo6rI8BH8IOiG3lA0yHU
     */
    @Test
    public void messageResolveEventTest() {
//        TODO xxx
//        addEventResolvers();
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
     * 添加事件消息解析器
     */
    // TODO xx
    /*
    private void addEventResolvers() {
        // 同步消息
        resolver.addWeChatHandler(new WeComMessageHandler<WeComEvent>() {
            @Override
            public WeComEchoMessage handle(WeComService service, WeComEvent event, MessageResolverContext context) {
                log.info("同步处理1, 有返回值: message: {}, context: {}", event, context);
                return new WeComEchoXmlMessage(event.getToUser(), event.getFromUser(), event.getCreateTime(), event.getMsgId(), event.getRaw());
            }

            @Override
            public Class<WeComEvent> supportType() {
                return WeComEvent.class;
            }
        });
        // 同步消息2
        resolver.addWeChatHandler(new WeComMessageHandler<TextMessage>() {
            @Override
            public void execute(WeComService service, TextMessage message, MessageResolverContext context) {
                log.info("同步处理2, 无返回值: message: {}, context: {}", message, context);
            }

            @Override
            public Class<TextMessage> supportType() {
                return TextMessage.class;
            }
        });

        // 异步消息
        resolver.addWeChatHandler(new WeComMessageHandler<WeChatMpMessage>() {
            @Override
            public WeComEchoMessage handle(WeComService service, WeChatMpMessage message, MessageResolverContext context) {
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
        resolver.addWeChatHandler(new WeComMessageHandler<TextMessage>() {
            @Override
            public void execute(WeComService service, TextMessage message, MessageResolverContext context) {
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
    }*/

}
