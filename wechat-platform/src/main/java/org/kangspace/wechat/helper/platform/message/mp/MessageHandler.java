package org.kangspace.wechat.helper.platform.message.mp;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.devhelper.ReflectUtil;
import org.kangspace.wechat.helper.core.message.MessageResolverContext;
import org.kangspace.wechat.helper.core.message.WeChatMessage;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.constant.MessageConstant;
import org.kangspace.wechat.helper.mp.message.*;
import org.kangspace.wechat.helper.mp.message.response.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 消息解析器
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/5
 */
@Slf4j
@Component
public class MessageHandler implements WeChatMpMessageHandler<WeChatMpMessage> {
    /**
     * 音乐关键字
     */
    private final static List<String> MUSIC_CONTENT_KEY_LIST = Arrays.asList("music", "音乐");
    /**
     * 图文关键字
     * TODO 测试资源上传后的音乐,视频
     */
    private final static List<String> NEWS_KEY_LIST = Arrays.asList("news", "图文");

    @Override
    public WeChatMpEchoMessage handle(WeChatMpService service, WeChatMpMessage message, MessageResolverContext context) {
        log.info("公众号消息解析器: message: {}, context: {}", message, context);
        MessageConstant.MessageType messageType = message.getMsgType();
        Class<?> mappingClassByMsgType = WeChatMpEchoMessages.getMappingClassByMsgType(messageType);
        WeChatMpEchoXmlMessage xmlMessage;
        // 存在对应类型的被动回复消息类型
        if (MessageConstant.MessageType.TEXT.equals(messageType)) {
            String content = ((TextMessage) message).getContent();
            // 音乐响应消息
            if (MUSIC_CONTENT_KEY_LIST.contains(content)) {
                xmlMessage = newEchoMessageInstance(message, MusicEchoMessage.class);
                String title = "虞兮叹-闻人听書_";
                String description = "所属专辑：虞兮叹";
                String musicUrl = "https://m804.music.126.net/20230117144505/e39315b2f7e7a4442c7c9f725cad1cfc/jdyyaac/obj/w5rDlsOJwrLDjj7CmsOj/14096461130/e462/cd92/f6a4/22c75e4f49c1efd8f956d590727ee7e3.m4a?authSecret=00000185be628285071d0aaba61aa868";
                String hqMusicUrl = musicUrl;
                String thumbMediaId = "bhdru4vbXsWWVqx-HZifCLbrIRhrckYCFgoDewz-5dYcgYACXc6js3yZ8aCxzJmk";
                ((MusicEchoMessage) xmlMessage).setMusic(new MusicEchoMessage.Music(title, description, musicUrl, hqMusicUrl, thumbMediaId));
            } else if (NEWS_KEY_LIST.contains(content)) {
                xmlMessage = newEchoMessageInstance(message, NewsEchoMessage.class);
                String title = "KangSpace";
                String description = "KangSpace-T.L.S";
                String url = "https://kangspace.org";
                List<NewsEchoMessage.Article> articles = new ArrayList<>();
                String prcUrl = "https://avatars.githubusercontent.com/u/26271023?v=4";
                articles.add(new NewsEchoMessage.Article(title, description, prcUrl, url));
                ((NewsEchoMessage) xmlMessage).setArticleCount(1);
                ((NewsEchoMessage) xmlMessage).setArticles(articles);
            } else {
                xmlMessage = newEchoMessageInstance(message, mappingClassByMsgType);
            }
        } else if (MessageConstant.MessageType.IMAGE.equals(messageType)) {
            xmlMessage = newEchoMessageInstance(message, mappingClassByMsgType);
            ((ImageEchoMessage) xmlMessage).setImage(new ImageEchoMessage.Image(((ImageMessage) message).getMediaId()));
        } else if (MessageConstant.MessageType.VOICE.equals(messageType)) {
            xmlMessage = newEchoMessageInstance(message, VoiceEchoMessage.class);
            VoiceMessage voiceMessage = ((VoiceMessage) message);
            ((VoiceEchoMessage) xmlMessage).setVoice(new VoiceEchoMessage.Voice(voiceMessage.getMediaId()));
            log.info("VOICE 识别结果: {}", voiceMessage.getRecognition());
        } else if (MessageConstant.MessageType.VIDEO.equals(messageType) || MessageConstant.MessageType.SHORTVIDEO.equals(messageType)) {
            xmlMessage = newEchoMessageInstance(message, VideoEchoMessage.class);
            VideoMessage videoMessage = ((VideoMessage) message);
            String messageId = videoMessage.getMsgId().toString();
            // TODO 视频资源测试
            ((VideoEchoMessage) xmlMessage).setVideo(new VideoEchoMessage.Video(
                    videoMessage.getMediaId(), "视频ID: " + messageId, "描述: " + messageId
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
            String prcUrl = "https://avatars.githubusercontent.com/u/26271023?v=4";
            articles.add(new NewsEchoMessage.Article(linkMessage.getTitle(), linkMessage.getDescription(), prcUrl, linkMessage.getUrl()));
            ((NewsEchoMessage) xmlMessage).setArticleCount(1);
            ((NewsEchoMessage) xmlMessage).setArticles(articles);
        } else {
            // 返回文本消息
            String content = "msgId: " + message.getMsgId() + ", msgType: " + message.getMsgType();
            xmlMessage = new TextEchoMessage(message.getToUser(), message.getFromUser(), message.getCreateTime(), System.currentTimeMillis(), content);
        }
        String toUser = message.getToUser();
        String fromUser = message.getFromUser();
        xmlMessage.setFromUser(toUser);
        xmlMessage.setToUser(fromUser);
        log.info("公众号消息解析器: 响应消息: {}", xmlMessage);
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
