package org.kangspace.wechat.helper.platform.controller;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.message.GetMessageSignature;
import org.kangspace.wechat.helper.core.message.MessageSignature;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessageResolver;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;
import org.kangspace.wechat.helper.platform.config.WeChatMpServiceConfig;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 微信公众号消息Controller
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/25
 */
@Slf4j
@RestController
@RequestMapping("message")
public class WeChatMpMessageController {
    @Resource
    private WeChatMpServiceConfig weChatMpServiceConfig;

    /**
     * 签名检查,循环配置检查.
     *
     * @param messageSignature messageSignature
     */
    private boolean checkSignature(GetMessageSignature messageSignature) {
        AtomicBoolean isChecked = new AtomicBoolean(false);
        weChatMpServiceConfig.getMessageResolvers().forEach(t -> {
            if (!isChecked.get()) {
                try {
                    t.checkSignature(messageSignature);
                    isChecked.set(true);
                } catch (Exception ignored) {
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
    public String checkSignature(GetMessageSignature messageSignature, @RequestParam("echostr") String echoStr) {
        messageSignature.setEchoStr(echoStr);
        if (checkSignature(messageSignature)) {
            return echoStr;
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
    @PostMapping("")
    public String messageHandle(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp, @RequestParam("nonce") String nonce,
                                @RequestParam(value = "msg_signature", required = false) String msgSignature,
                                @RequestParam(value = "encrypt_type", required = false) String encryptType,
                                @RequestBody String body) {
        MessageSignature messageSignature = new MessageSignature(signature, timestamp, nonce, encryptType, msgSignature);
        log.info("微信消息: messageSignature:{} \n{}\n", messageSignature, body);
        String rawId = WeChatMpMessageResolver.extractToUserName(body);
        WeChatMpMessageResolver resolver = weChatMpServiceConfig.getMessageResolver(rawId);
        String echoMessage = resolver.resolveEcho(messageSignature, body);
        log.info("响应消息: {}", echoMessage);
        return StringUtils.hasText(echoMessage) ? echoMessage : WeChatMpEchoMessage.echoSuccess();
    }
}
