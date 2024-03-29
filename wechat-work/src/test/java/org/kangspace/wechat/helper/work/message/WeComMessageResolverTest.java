package org.kangspace.wechat.helper.work.message;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.core.message.MessageSignature;
import org.kangspace.wechat.helper.core.message.response.WeChatEchoMessage;
import org.kangspace.wechat.helper.work.DefaultWeComService;
import org.kangspace.wechat.helper.work.WeComAppConstant;
import org.kangspace.wechat.helper.work.WeComService;
import org.kangspace.wechat.helper.work.config.WeComConfig;
 import org.kangspace.wechat.helper.work.message.response.WeComEchoMessage;
import org.kangspace.wechat.helper.work.message.response.WeComEchoXmlMessage;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;

/**
 * 企业微信消息测试
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/27
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
        weChatMpConfig.setToken(token);
        weChatMpConfig.setEncodingAESKey(encodingAesKey);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        WeComService weComService = new DefaultWeComService(weComAccessTokenService);
        resolver = new WeComMessageResolver(weComService);
    }


    /**
     * 消息测试<br>
     * wechat-platform/wecom/message?msg_signature=70dd76227f0df9beadbde233c080a09fb77f7f10&timestamp=1691919277&nonce=1691933706
     */
    @Test
    public void messageResolveEventTest() {
        addMessageResolvers();
        String rawMessage = "<xml><ToUserName><![CDATA[ww4f516765184ba539]]></ToUserName><Encrypt><![CDATA[O/FLj7mf7HGvaPww6+TMmTxmduHR6vHnle/OLg4qdCfnZD4y83/zrYVs4rzdZZZtITu3KX6fBRkniK55viR92u7TQgdLN/oOkTLbY6FgJmkkEjMGgZeIW0h4LPcCb8JFD/lvhkK73yAQmDXRFOFxjvJ01TJEuZvvBm8bweXgN7/L4VHyKU+xX78I1NAikHjlR39EkPF51ix+O9UVrvMHFhdv7tU0ejQmo2hRJoZZZmItFxso7CzQ/3qZbh46+Hl8ve8yWb3CbdMjjKWQKsmPgf/hnk/Ytpep2FnZD0ewg+1FSCTZMqWP/D+QRB5DjIGnN7jno6juF1D5FRNkt7j4Z5FG/u6LKrAKOZ1BV/pKeLAI9AkriuPSoh0FeVzHrFxe/OB/GvjfM7jVPmHl6qEd+fnb50jyLo1SHUPZ7KRt2zJTLyX1cJY20lDmUpkPincMZBFxBghhYEDKafBBTTgUyY7qzVh8fbdKXF2fCvsZG7CnQKeAZvTTwRjCcxEHdRV2xQJe5+aAj++dPOJcvCJ0e2ubUS+puI7uXGkSZ/1Di2F3UtM7ni98gS9Syxoj2NRPmOkci0B9p8krtFoybRvTXw==]]></Encrypt><AgentID><![CDATA[1000004]]></AgentID></xml>";
        log.info("rawMessage: {}", rawMessage);
        String timestamp = "1691919277";
        String nonce = "1691933706";
        String msgSignature = "70dd76227f0df9beadbde233c080a09fb77f7f10";
        MessageSignature messageSignature = MessageSignature.buildMsgSignature(msgSignature, timestamp, nonce);
        WeChatEchoMessage echoMessage = resolver.resolve(messageSignature, rawMessage);
        String echo = resolver.resolveEcho(messageSignature, rawMessage);
        log.info("echoMessage: {}", echoMessage);
        log.info("echo: {}", echo);
    }


    /**
     * 添加事件消息解析器
     */
    private void addMessageResolvers() {
        // 同步消息
        resolver.addWeChatHandler(new WeComMessageHandler<LocationMessage>() {
            @Override
            public WeComEchoMessage handle(WeComService service, LocationMessage message, MessageResolverContext context) {
                log.info("异步处理1, 有返回值: message: {}, context: {}", message, context);
                return new WeComEchoXmlMessage();
            }

            @Override
            public Class<LocationMessage> supportType() {
                return LocationMessage.class;
            }
        });
        // 异步消息
        resolver.addWeChatHandler(new WeComMessageHandler<LocationMessage>() {
            @Override
            public void execute(WeComService service, LocationMessage message, MessageResolverContext context) {
                log.info("异步处理2, 无返回值 message: {}, context: {}", message, context);
            }

            @Override
            public Class<LocationMessage> supportType() {
                return LocationMessage.class;
            }

            @Override
            public boolean isAsync() {
                return true;
            }
        });
    }

}
