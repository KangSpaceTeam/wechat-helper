package org.kangspace.wechat.helper.work.message;

import org.kangspace.wechat.helper.core.message.WeChatMessage;

/**
 * 企业微信消息
 *
 * @author kango2gler@gmail.com
 * @since 2023/07/25
 */
public interface WeComMessage extends WeChatMessage {
    /**
     * 获取消息类型
     *
     * @return {@link MessageConstant.MessageType}
     */
    MessageConstant.MessageType getMsgType();

    /**
     * 开发者微信号、
     *
     * @return 开发者微信号
     */
    String getToUser();

    /**
     * 发送方帐号（一个OpenID）
     *
     * @return OpenID
     */
    String getFromUser();

    /**
     * 消息创建时间 （整型, Unix时间戳）
     *
     * @return 消息创建时间 （整型）
     */
    Long getCreateTime();

    /**
     * 获取消息ID
     *
     * @return 消息ID
     */
    Long getMsgId();

    /**
     * 是否是事件类型消息
     *
     * @return boolean
     */
    default boolean isEvent() {
        return MessageConstant.MessageType.EVENT.equals(this.getMsgType());
    }
}
