package org.kangspace.wechat.helper.mp.event;

import org.kangspace.wechat.helper.core.event.WeChatEvent;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessage;

/**
 * 微信公众号事件
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/12
 */
public interface WeChatMpEvent extends WeChatMpMessage, WeChatEvent {

    /**
     * 事件 KEY 值，与自定义菜单接口中 KEY 值对应
     *
     * @return key
     */
    String getEventKey();

    /**
     * 获取事件
     * @return event
     */
    String getEvent();
}
