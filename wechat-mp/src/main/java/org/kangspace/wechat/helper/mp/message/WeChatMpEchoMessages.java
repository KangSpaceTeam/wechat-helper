package org.kangspace.wechat.helper.mp.message;

import org.kangspace.wechat.helper.mp.constant.MessageConstant;
import org.kangspace.wechat.helper.mp.message.response.*;

import java.util.Arrays;

/**
 * 微信公众号响应消息枚举(被动回复)<br>
 * 指定各消息类型对应的实体类。
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/29
 */
public enum WeChatMpEchoMessages {
    /**
     * 文本消息
     */
    Text(MessageConstant.MessageType.TEXT, TextEchoMessage.class),
    /**
     * 图片消息
     */
    Image(MessageConstant.MessageType.IMAGE, ImageEchoMessage.class),
    /**
     * 语音消息
     */
    Voice(MessageConstant.MessageType.VOICE, VoiceEchoMessage.class),
    /**
     * 视频消息
     */
    Video(MessageConstant.MessageType.VIDEO, VideoEchoMessage.class),
    /**
     * 小视频消息
     */
    Music(MessageConstant.MessageType.MUSIC, MusicEchoMessage.class),
    /**
     * 地理位置消息
     */
    News(MessageConstant.MessageType.NEWS, NewsEchoMessage.class),

    ;

    /**
     * 消息类型
     */
    private final MessageConstant.MessageType msgType;
    /**
     * 事件映射的对象
     */
    private final Class<? extends WeChatMpXmlMessage> mappingClass;

    WeChatMpEchoMessages(MessageConstant.MessageType msgType, Class<? extends WeChatMpXmlMessage> mappingClass) {
        this.msgType = msgType;
        this.mappingClass = mappingClass;
    }

    /**
     * 通过MsgType获取事件处理对象(指定消息类型不存在时,返回{@link WeChatMpXmlMessage})
     *
     * @param msgType 消息类型
     * @return mappingClass 消息映射的对象
     */
    public static Class<? extends WeChatMpXmlMessage> getMappingClassByMsgType(MessageConstant.MessageType msgType) {
        Class<? extends WeChatMpXmlMessage> mappingClass = Arrays.stream(values()).filter(t -> t.getMsgType().equals(msgType)).map(WeChatMpEchoMessages::getMappingClass).findFirst().orElse(null);
        return mappingClass != null ? mappingClass : WeChatMpXmlMessage.class;
    }

    public MessageConstant.MessageType getMsgType() {
        return msgType;
    }

    public Class<? extends WeChatMpXmlMessage> getMappingClass() {
        return mappingClass;
    }
}
