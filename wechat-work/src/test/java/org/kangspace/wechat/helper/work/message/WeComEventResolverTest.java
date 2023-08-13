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
import org.kangspace.wechat.helper.work.event.TemplateCardEventEvent;
import org.kangspace.wechat.helper.work.event.WeComEventHandler;
import org.kangspace.wechat.helper.work.message.response.WeComEchoMessage;
import org.kangspace.wechat.helper.work.message.response.WeComEchoXmlMessage;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;

/**
 * 企业微信事件测试
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/27
 */
@Slf4j
@RunWith(JUnit4.class)
public class WeComEventResolverTest {
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
     * 事件测试<br>
     * /wechat-platform/wecom/message?msg_signature=d424c2c33a1cf5ef0af2ff63baaa6bdcc2e4de9f&timestamp=1691921245&nonce=1692072758
     */
    @Test
    public void messageResolveEventTest() {
        addEventResolvers();

        String rawMessage = "<xml><ToUserName><![CDATA[ww4f516765184ba539]]></ToUserName><Encrypt><![CDATA[cgoOvJKRsF9lonFHDo0qmERC9eyDm8LSyBr/GgpjxqoSgOzwvfnwX++9039Zr7vTJH88RTy2++pF5tMvDrghcpMV1XnKynL1jkk5X4a0AufQi5XdEHLPhgxpjq0MKMJz1vDATib07e2TkmokD1uov8Z6hnCgHB+JTToin1z/TbU+v0EhD6nKuWU0X9Qlj066hUZjkZ/xfhMsSf1Y1rM60YgjXjS4DdAbQRtQElvrfliQRh8fBH4Crcn6kd3oZpnLRX4AIWGdqucGti4hZL+mIBtvGJ54P7EhZjv25gTnq1f5CBWy3lRK7tW35i4inuF3Cvpo0KZSmvnINsb0Ps3k/Iy5ltqsKKI9f78ITchHsFhRbxVKTM/M7VtAUvPUI01w4UAhXq85rsPl5pJ/D+3eX3IGHIpsQfJ9qzn2PqS7uhFUPgtIQeamXGA3dfsRNFwI1mbqz5bT84hmY2c8e2h5RwXa8DiCTbUH1F1X+PWsEWIns3VWnhihumDQwAODW7NcMIe5pDIqPzhw8l4rJLLkxnm+uk0AijX/GU6vvU4W/BcesIfvnqLYLz5Kd77yo9a+//WhmchsnC721/6QMoZxvsN7Reqcx7lMlkyeRvSjDPBm12vEmOaLSakeimUZ0IGBkB4QPD9Yzf9I6ISPiawa/OkMPpQvZ7CNF8xj1aUSI2L65vMghIpqMcQ1IDqcNx2PRRqgo21/ZrC45rLH0ieaUfYv+apiUWJMoG+0HTA/GQ170m6OYbvQj7EvxoL2BSC9DNpwobbfD1ca7xay2D9yueW+m/XWJxGdEfbckE+oLPnX+HWkucZqNZWoLbRI3kKWGLwIde4jtoJLJx+XPCBIPnAmXOjWvXFyKLWJcq/Id3NlW9hmRUtQKD5AHgBSrNF/+9CT+AvdvVTf6SyMc6KtcVaPKCB/YiBEUVg6vitlXdg=]]></Encrypt><AgentID><![CDATA[1000004]]></AgentID></xml>";
        log.info("rawMessage: {}", rawMessage);
        String timestamp = "1691921245";
        String nonce = "1692072758";
        String msgSignature = "d424c2c33a1cf5ef0af2ff63baaa6bdcc2e4de9f";
        MessageSignature messageSignature = MessageSignature.buildMsgSignature(msgSignature, timestamp, nonce);
        WeChatEchoMessage echoMessage = resolver.resolve(messageSignature, rawMessage);
        String echo = resolver.resolveEcho(messageSignature, rawMessage);
        log.info("echoMessage: {}", echoMessage);
        log.info("echo: {}", echo);
    }


    /**
     * 添加事件消息解析器
     */
    private void addEventResolvers() {
        // 同步消息
        resolver.addWeChatHandler(new WeComEventHandler<TemplateCardEventEvent>() {
            @Override
            public WeComEchoMessage handle(WeComService service, TemplateCardEventEvent message, MessageResolverContext context) {
                log.info("异步处理1, 有返回值: message: {}, context: {}", message, context);
                return new WeComEchoXmlMessage();
            }

            @Override
            public Class<TemplateCardEventEvent> supportType() {
                return TemplateCardEventEvent.class;
            }
        });
        // 异步消息
        resolver.addWeChatHandler(new WeComEventHandler<TemplateCardEventEvent>() {
            @Override
            public void execute(WeComService service, TemplateCardEventEvent event, MessageResolverContext context) {
                log.info("异步处理2, 无返回值 message: {}, context: {}", event, context);
            }

            @Override
            public Class<TemplateCardEventEvent> supportType() {
                return TemplateCardEventEvent.class;
            }

            @Override
            public boolean isAsync() {
                return true;
            }
        });
    }

}
