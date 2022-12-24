package org.kangspace.wechat.helper.core.message;

/**
 * 微信消息接口
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/12
 */
public interface WeChatMessage {
    /**
     * 获取原始消息
     *
     * @return 原始消息
     */
    String getRaw();
}
