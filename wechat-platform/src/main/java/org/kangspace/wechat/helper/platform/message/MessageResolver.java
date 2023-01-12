package org.kangspace.wechat.helper.platform.message;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.core.util.ReflectUtil;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.constant.MessageConstant;
import org.kangspace.wechat.helper.mp.message.*;
import org.kangspace.wechat.helper.mp.message.response.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息解析器
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/5
 */
@Slf4j
@Component
public class MessageResolver implements WeChatMpMessageHandler<WeChatMpMessage> {

    @Override
    public WeChatMpEchoMessage handle(WeChatMpService service, WeChatMpMessage message, MessageResolverContext context) {
        log.info("消息解析器: message: {}, context: {}", message, context);
        MessageConstant.MessageType messageType = message.getMsgType();
        Class<?> mappingClassByMsgType = WeChatMpEchoMessages.getMappingClassByMsgType(messageType);
        WeChatMpEchoXmlMessage xmlMessage;
        // 存在对应类型的被动回复消息类型
        if (MessageConstant.MessageType.TEXT.equals(messageType)) {
            xmlMessage = newEchoMessageInstance(message, mappingClassByMsgType);
        } else if (MessageConstant.MessageType.IMAGE.equals(messageType)) {
            xmlMessage = newEchoMessageInstance(message, mappingClassByMsgType);
            ((ImageEchoMessage) xmlMessage).setImage(new ImageEchoMessage.Image(((ImageMessage) message).getMediaId()));
        } else if (MessageConstant.MessageType.VOICE.equals(messageType)) {
            xmlMessage = newEchoMessageInstance(message, VoiceEchoMessage.class);
            VoiceMessage voiceMessage = ((VoiceMessage) message);
            ((VoiceEchoMessage) xmlMessage).setVoice(new VoiceEchoMessage.Voice(voiceMessage.getMediaId()));
        } else if (MessageConstant.MessageType.VIDEO.equals(messageType) || MessageConstant.MessageType.SHORTVIDEO.equals(messageType)) {
            xmlMessage = newEchoMessageInstance(message, VideoEchoMessage.class);
            VideoMessage videoMessage = ((VideoMessage) message);
            ((VideoEchoMessage) xmlMessage).setVideo(new VideoEchoMessage.Video(
                    videoMessage.getMediaId(), "视频ID: " + videoMessage.getMediaId(), "描述: " + videoMessage.getMediaId()
            ));
        } else if (MessageConstant.MessageType.LOCATION.equals(messageType)) {
            xmlMessage = newEchoMessageInstance(message, TextEchoMessage.class);
            LocationMessage locationMessage = ((LocationMessage) message);
            String content = "地址: " + locationMessage.getLabel() + "\n" +
                    "坐标: " + locationMessage.getLocationX() + "," + locationMessage.getLocationY() + "\n" +
                    "缩放: " + locationMessage.getScale();
            ((TextEchoMessage) xmlMessage).setContent(content);
        } else if (MessageConstant.MessageType.LINK.equals(messageType)) {
            xmlMessage = newEchoMessageInstance(message, NewsEchoMessage.class);
            LinkMessage linkMessage = ((LinkMessage) message);
            List<NewsEchoMessage.Article> articles = new ArrayList<>();
            String prcUrl = "https://kangspace.org/img/logo-h1.0413ed19.webp";
            articles.add(new NewsEchoMessage.Article(linkMessage.getTitle(), linkMessage.getDescription(), prcUrl, linkMessage.getUrl()));
            ((NewsEchoMessage) xmlMessage).setArticleCount(1);
            ((NewsEchoMessage) xmlMessage).setArticles(articles);
        }
        // 缺少音乐响应消息
        else {
            // 返回文本消息
            String content = "msgId: " + message.getMsgId() + ", msgType: {}" + message.getMsgType();
            xmlMessage = new TextEchoMessage(message.getToUser(), message.getFromUser(), message.getCreateTime(), System.currentTimeMillis(), content);
        }
        String toUser = message.getToUser();
        String fromUser = message.getFromUser();
        xmlMessage.setFromUser(toUser);
        xmlMessage.setToUser(fromUser);
        log.info("消息解析器: 响应消息: {}", xmlMessage);
        return xmlMessage;
    }

    /**
     * 创建新的响应对象
     *
     * @param message               原始消息
     * @param mappingClassByMsgType 响应对象类
     * @return {@link WeChatMpEchoXmlMessage}
     */
    private WeChatMpEchoXmlMessage newEchoMessageInstance(WeChatMpMessage message, Class<?> mappingClassByMsgType) {
        WeChatMpEchoXmlMessage xmlMessage = (WeChatMpEchoXmlMessage) ReflectUtil.newInstance(mappingClassByMsgType);
        BeanUtils.copyProperties(message, xmlMessage);
        return xmlMessage;
    }
}
