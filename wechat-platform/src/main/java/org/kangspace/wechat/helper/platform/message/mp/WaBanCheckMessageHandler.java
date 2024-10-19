package org.kangspace.wechat.helper.platform.message.mp;

import javax.annotation.Resource;

import org.kangspace.wechat.helper.banhelper.wa.WaBanCheckResult;
import org.kangspace.wechat.helper.banhelper.wa.WaBanChecker;
import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.core.util.WeChatAppIdHelper;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.constant.MessageConstant;
import org.kangspace.wechat.helper.mp.message.TextMessage;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessage;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessageHandler;
import org.kangspace.wechat.helper.mp.message.response.TextEchoMessage;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoXmlMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 小程序封禁检查处理器
 * 
 * @author kango2gler@gmail.com
 * @since 0.1.1
 */
@Slf4j
@Order(1)
@Profile("wechat-ban-check")
@Component
public class WaBanCheckMessageHandler implements WeChatMpMessageHandler<WeChatMpMessage> {
    @Resource
    private WaBanChecker waBanChecker;

    @Override
    public WeChatMpEchoMessage handle(WeChatMpService service, WeChatMpMessage message,
            MessageResolverContext context) {
        log.info("公众号消息解析器(小程序封禁检测): message: {}, context: {}", message, context);
        MessageConstant.MessageType messageType = message.getMsgType();
        if (MessageConstant.MessageType.TEXT.equals(messageType)) {
            String content = ((TextMessage) message).getContent().trim();
            // 1. 检查是否为AppId
            if (WeChatAppIdHelper.isAppId(content)) {
                // 2. 检查是否被封禁
                WaBanCheckResult banCheckResult = waBanChecker.banCheck(content);
                if (banCheckResult.isSucceed()) {
                    log.info("公众号消息解析器(小程序封禁检测): 命中, appId: {}", content);
                    StringBuilder contentBuffer = new StringBuilder();
                    contentBuffer.append("AppId: ").append(content).append("\n");
                    contentBuffer.append("小程序名称: ").append(banCheckResult.getAppName()).append("\n");
                    boolean isBanned = banCheckResult.getBanned();
                    contentBuffer.append("小程序状态: ").append(isBanned ? "封禁" : "正常").append("\n");
                    if (isBanned) {
                        if (banCheckResult.getReason() != null) {
                            contentBuffer.append("封禁原因: ").append(banCheckResult.getReason()).append("\n");
                        }
                        if (banCheckResult.getDetail() != null) {
                            contentBuffer.append("封禁详情: ").append(banCheckResult.getDetail()).append("\n");
                        }
                    }
                    TextEchoMessage reply = new TextEchoMessage();
                    reply.setContent(contentBuffer.toString());
                    String toUser = message.getToUser();
                    String fromUser = message.getFromUser();
                    reply.setFromUser(toUser);
                    reply.setToUser(fromUser);
                    return reply;
                }
            }
        }
        log.info("公众号消息解析器(小程序封禁检测): 未命中");
        return null;
    }

    @Configuration
    public static class BanHelperConfigure {
        @Bean
        public WaBanChecker waBanChecker() {
            return new WaBanChecker();
        }
    }
}
