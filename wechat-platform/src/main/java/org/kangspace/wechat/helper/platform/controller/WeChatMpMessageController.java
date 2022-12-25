package org.kangspace.wechat.helper.platform.controller;

import lombok.extern.slf4j.Slf4j;
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
     * @param messageSignature {@link MessageSignature}
     * @return string
     */
    @GetMapping("")
    public String checkSignature(MessageSignature messageSignature, @RequestParam("echostr") String echostr) {
        messageSignature.setEchoStr(echostr);
        return weChatMpMessageResolver.checkSignature(messageSignature);
    }

    /**
     * 微信消息
     *
     * @param body 消息内容
     * @return String
     */
    @PostMapping("")
    public String messageHandle(@RequestBody String body) {
        log.info("微信消息: \n{}\n", body);
        return "";
    }
}
