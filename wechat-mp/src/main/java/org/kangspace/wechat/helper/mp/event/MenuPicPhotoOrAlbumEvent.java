package org.kangspace.wechat.helper.mp.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * pic_photo_or_album：弹出拍照或者相册发图的事件 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Custom_Menu_Push_Events.html">https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Custom_Menu_Push_Events.html</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MenuPicPhotoOrAlbumEvent extends MenuPicSysPhotoEvent {
}
