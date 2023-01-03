package org.kangspace.wechat.helper.mp.message;

import org.kangspace.wechat.helper.mp.constant.MessageConstant;

import java.util.Arrays;

/**
 * 微信公众号消息枚举<br>
 * 指定各消息类型对应的实体类。
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/29
 */
public enum WeChatMpMessages {
    /**
     * 文本消息
     */
    Text(MessageConstant.MessageType.TEXT, TextMessage.class),
    /**
     * 图片消息
     */
    Image(MessageConstant.MessageType.IMAGE, ImageMessage.class),
    /**
     * 语音消息
     */
    Voice(MessageConstant.MessageType.VOICE, VoiceMessage.class),
    /**
     * 视频消息
     */
    Video(MessageConstant.MessageType.VIDEO, VideoMessage.class),
    /**
     * 小视频消息
     */
    ShortVideo(MessageConstant.MessageType.SHORTVIDEO, ShortVideoMessage.class),
    /**
     * 地理位置消息
     */
    Location(MessageConstant.MessageType.LOCATION, LocationMessage.class),
    /**
     * 链接消息
     */
    Link(MessageConstant.MessageType.LINK, LinkMessage.class),

    ;

    /**
     * 消息类型
     */
    private final MessageConstant.MessageType msgType;
    /**
     * 事件映射的对象
     */
    private final Class<? extends WeChatMpXmlMessage> mappingClass;

    WeChatMpMessages(MessageConstant.MessageType msgType, Class<? extends WeChatMpXmlMessage> mappingClass) {
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
        Class<? extends WeChatMpXmlMessage> mappingClass = Arrays.stream(values()).filter(t -> t.getMsgType().equals(msgType)).map(WeChatMpMessages::getMappingClass).findFirst().orElse(null);
        return mappingClass != null ? mappingClass : WeChatMpXmlMessage.class;
    }

    public MessageConstant.MessageType getMsgType() {
        return msgType;
    }

    public Class<? extends WeChatMpXmlMessage> getMappingClass() {
        return mappingClass;
    }
}
