package org.kangspace.wechat.helper.mp.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框的事件 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Custom_Menu_Push_Events.html">https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Custom_Menu_Push_Events.html</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MenuScanCodeWaitMsgEvent extends MenuScanCodePushEvent {
}
