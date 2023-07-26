package org.kangspace.wechat.helper.work.event;

import org.kangspace.wechat.helper.core.event.WeChatEvent;
import org.kangspace.wechat.helper.work.message.WeComMessage;

/**
 * 企业微信事件
 *
 * @author kango2gler@gmail.com
 * @since 2023/07/25
 */
public interface WeComEvent extends WeComMessage, WeChatEvent {

    /**
     * 事件 KEY 值，与自定义菜单接口中 KEY 值对应
     *
     * @return key
     */
    String getEventKey();

    /**
     * 获取事件
     *
     * @return event
     */
    String getEvent();
}
