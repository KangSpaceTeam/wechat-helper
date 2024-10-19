package org.kangspace.wechat.helper.platform.message.mp;

import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.event.SubscribeEvent;
import org.kangspace.wechat.helper.mp.event.WeChatMpEventHandler;
import org.kangspace.wechat.helper.mp.message.response.TextEchoMessage;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 订阅事件处理器
 * @author kango2gler@gmail.com
 * @since 0.1.1
 */
@Slf4j
@Order(1)
@Component
public class SubscribeEventHandler implements WeChatMpEventHandler<SubscribeEvent> {
    @Override
    public WeChatMpEchoMessage handle(WeChatMpService service, SubscribeEvent event, MessageResolverContext context) {
        log.info("公众号事件解析器: event: {}, context: {}", event, context);
        return subscribeReplyMessage(event, context);
    }

    /**
     * 订阅响应信息
     * @param event 订阅事件
     * @param context 消息解析上下文
     * @return 返回的消息内容
     */
    private WeChatMpEchoMessage subscribeReplyMessage(SubscribeEvent event, MessageResolverContext context) {
        StringBuilder message = new StringBuilder();
        message.append("\uD83D\uDCE3 欢迎关注「极谷小站」！\n");
        message.append("(").append(context.getOpenId()).append(")\n\n");
        message.append("路漫漫其修远，吾将上下而求索\n");

        // 如果是扫描二维码关注，添加额外信息
        if (event.getEventKey() != null && event.getEventKey().startsWith(SubscribeEvent.SUBSCRIPT_EVENT_KEY_PREFIX)) {
            String sceneId = event.getEventKey().substring(SubscribeEvent.SUBSCRIPT_EVENT_KEY_PREFIX.length());
            message.append("\n").append("您是通过扫描二维码关注的，场景值为：「").append(sceneId).append("」\n");
        }
        TextEchoMessage xmlMessage = new TextEchoMessage();
        BeanUtils.copyProperties(event, xmlMessage);
        xmlMessage.setEvent(null);
        xmlMessage.setContent(message.toString());
        String toUser = event.getToUser();
        String fromUser = event.getFromUser();
        xmlMessage.setFromUser(toUser);
        xmlMessage.setToUser(fromUser);
        return xmlMessage;
    }

    @Override
    public Class<? extends SubscribeEvent> supportType() {
        return SubscribeEvent.class;
    }

    @Override
    public Integer getOrder() {
        return 1;
    }
}
