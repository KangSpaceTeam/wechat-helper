package org.kangspace.wechat.helper.platform.message;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.event.MenuScanCodeWaitMsgEvent;
import org.kangspace.wechat.helper.mp.event.WeChatMpEventHandler;
import org.kangspace.wechat.helper.mp.event.WeChatMpEvents;
import org.kangspace.wechat.helper.mp.event.WeChatMpXmlEvent;
import org.kangspace.wechat.helper.mp.message.response.TextEchoMessage;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 事件消息解析器
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/5
 */
@Slf4j
@Component
public class EventHandler implements WeChatMpEventHandler<WeChatMpXmlEvent> {

    /**
     * emoji表情
     */
    private final static String[] EMOJI_ARR = {"\uD83D\uDCE3", "\uD83D\uDDFA️", "\uD83C\uDF05", "\uD83D\uDDBC️", "\uD83C\uDF88", "\uD83D\uDD16", "\uD83C\uDF87", "\uD83C\uDF84", "\uD83D\uDCA1", "\uD83C\uDF10", "☕", "\uD83D\uDC51", "\uD83D\uDC31", "\uD83D\uDC36", "\uD83D\uDCF1", "⌚", "\uD83D\uDC8E"};

    @Override
    public WeChatMpEchoMessage handle(WeChatMpService service, WeChatMpXmlEvent event, MessageResolverContext context) {
        log.info("消息解析器: message: {}, context: {}", event, context);
        TextEchoMessage xmlMessage = null;
        String eventType = event.getEvent();
        String content = null;
        // 存在对应类型的被动回复消息类型
        if (WeChatMpEvents.Click.getEvent().equals(eventType)) {
            // 拉取消息
            content = "event: " + event.getEvent() + ", eventKey: " + event.getEventKey() + "\n" +
                    randomEmoji();
        } else if (WeChatMpEvents.ScanCodeWaitMsg.getEvent().equals(eventType)) {
            MenuScanCodeWaitMsgEvent.ScanCodeInfo scanCodeInfo = ((MenuScanCodeWaitMsgEvent) event).getScanCodeInfo();
            // 扫码等消息
            content = "event: " + event.getEvent() + ", eventKey: " + event.getEventKey() + "\n" +
                    "扫描类型: " + scanCodeInfo.getScanType() + "\n" +
                    "扫描结果: " + scanCodeInfo.getScanResult();
        } else if (WeChatMpEvents.Subscribe.getEvent().equals(eventType)) {
            // 订阅
            content = "\uD83D\uDCE3感谢关注公众号！(" + context.getOpenId() + ")";
        } else {
            log.info("event: " + event.getEvent() + ", eventKey: " + event.getEventKey());
        }

        if (content != null) {
            xmlMessage = new TextEchoMessage();
            BeanUtils.copyProperties(event, xmlMessage);
            xmlMessage.setEvent(null);
            xmlMessage.setContent(content);
            String toUser = event.getToUser();
            String fromUser = event.getFromUser();
            xmlMessage.setFromUser(toUser);
            xmlMessage.setToUser(fromUser);
        }
        log.info("消息解析器: 响应消息: {}", xmlMessage);
        return xmlMessage;
    }

    /**
     * 随机emoji
     *
     * @return emoji
     */
    private String randomEmoji() {
        int idx = new Random().nextInt(EMOJI_ARR.length);
        return EMOJI_ARR[idx];
    }
}
