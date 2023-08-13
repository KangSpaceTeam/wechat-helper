package org.kangspace.wechat.helper.platform.controller;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.message.GetMessageSignature;
import org.kangspace.wechat.helper.core.message.MessageSignature;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;
import org.kangspace.wechat.helper.platform.config.WeComServiceConfig;
import org.kangspace.wechat.helper.work.message.WeComMessageResolver;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 企业微信消息Controller
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/6
 */
@Slf4j
@RestController
@RequestMapping("wecom/message")
public class WeComMessageController {
    @Resource
    private WeComServiceConfig weComServiceConfig;

    /**
     * 签名检查,循环配置检查.
     *
     * @param messageSignature messageSignature
     */
    private String checkSignature(GetMessageSignature messageSignature) {
        AtomicReference<String> isChecked = new AtomicReference<>("");
        weComServiceConfig.getMessageResolvers().forEach(t -> {
            if (!StringUtils.hasText(isChecked.get())) {
                try {
                    String receiveId = t.checkSignatureWithReplyEchoStr(messageSignature);
                    isChecked.set(receiveId);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        });
        return isChecked.get();
    }

    /**
     * 响应微信发送的Token验证
     *
     * @param messageSignature {@link GetMessageSignature}
     * @return string
     */
    @GetMapping("")
    public String checkSignature(GetMessageSignature messageSignature,
                                 @RequestParam("echostr") String echoStr,
                                 @RequestParam("msg_signature") String msgSignature) {
        messageSignature.setEchoStr(echoStr);
        messageSignature.setSignature(msgSignature);
        String receiveId;
        if (StringUtils.hasText(receiveId = checkSignature(messageSignature))) {
            return receiveId;
        }
        log.error("签名验证失败(checkSignature): messageSignature: {}, echoStr: {}", messageSignature, echoStr);
        return null;
    }

    /**
     * 微信消息
     *
     * @param body 消息内容
     * @return String
     */
    @PostMapping(path = "", produces = MimeTypeUtils.APPLICATION_XML_VALUE)
    public String messageHandle(@RequestParam("timestamp") String timestamp,
                                @RequestParam("nonce") String nonce,
                                @RequestParam("msg_signature") String msgSignature,
                                @RequestBody String body) {
        MessageSignature messageSignature = MessageSignature.buildMsgSignature(msgSignature, timestamp, nonce);
        log.info("微信消息: messageSignature:{} \n{}\n", messageSignature, body);
        String corpId = WeComMessageResolver.extractToUserName(body);
        String agentId = WeComMessageResolver.extractToAgentId(body);
        WeComMessageResolver resolver = weComServiceConfig.getMessageResolver(corpId, agentId);
//        String echoMessage = resolver.resolveEcho(messageSignature, body, MessageResolverContext.newContext(openId));
        String echoMessage = null;
        log.info("响应消息: {}", echoMessage);
        return StringUtils.hasText(echoMessage) ? echoMessage : WeChatMpEchoMessage.echoSuccess();
    }
}
