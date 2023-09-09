package org.kangspace.wechat.helper.mp.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 关注/取消关注事件(取消关注) <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_event_pushes.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_event_pushes.html</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UnsubscribeEvent extends WeChatMpXmlEvent {
}
