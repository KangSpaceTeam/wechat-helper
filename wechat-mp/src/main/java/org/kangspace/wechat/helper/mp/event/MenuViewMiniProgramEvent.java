package org.kangspace.wechat.helper.mp.event;

import lombok.Data;
import lombok.ToString;

/**
 * 点击菜单跳转小程序的事件 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Custom_Menu_Push_Events.html">https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Custom_Menu_Push_Events.html</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/31
 */
@Data
@ToString(callSuper = true)
public class MenuViewMiniProgramEvent extends MenuViewEvent {
}
