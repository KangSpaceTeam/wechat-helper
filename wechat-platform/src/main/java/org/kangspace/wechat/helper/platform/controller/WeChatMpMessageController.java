package org.kangspace.wechat.helper.platform.controller;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.message.GetMessageSignature;
import org.kangspace.wechat.helper.core.message.MessageSignature;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessageResolver;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    private WeChatMpMessageResolver weChatMpMessageResolver;

    /**
     * 响应微信发送的Token验证
     *
     * @param messageSignature {@link GetMessageSignature}
     * @return string
     */
    @GetMapping("")
    public String checkSignature(GetMessageSignature messageSignature, @RequestParam("echostr") String echostr) {
        messageSignature.setEchoStr(echostr);
        weChatMpMessageResolver.checkSignatureThrows(messageSignature);
        return echostr;
    }

    /**
     * 微信消息
     *
     * @param body 消息内容
     * @return String
     */
    @PostMapping("")
    public String messageHandle(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp, @RequestParam("nonce") String nonce,
                                @RequestParam("msg_signature") String msgSignature, @RequestParam("encrypt_type") String encryptType,
                                @RequestBody String body) {
        MessageSignature messageSignature = new MessageSignature(signature, timestamp, nonce, encryptType, msgSignature);
        log.info("微信消息: messageSignature:{} \n{}\n", messageSignature, body);
        return "";
    }
}
