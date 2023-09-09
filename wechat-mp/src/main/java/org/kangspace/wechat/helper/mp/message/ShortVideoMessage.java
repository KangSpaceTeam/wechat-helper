package org.kangspace.wechat.helper.mp.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 小视频消息<br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_standard_messages.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_standard_messages.html</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShortVideoMessage extends VideoMessage {

}
