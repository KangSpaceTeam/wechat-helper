package org.kangspace.wechat.helper.work.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 长期未使用应用临时停用事件 <br>
 * 接口文档:
 * <a href="https://developer.work.weixin.qq.com/document/path/90240">https://developer.work.weixin.qq.com/document/path/90240</a> <br>
 * <p>
 * 当应用因长期无人使用被系统自动停用时，回调此事件。
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CloseInactiveAgentEvent extends WeComXmlEvent {
    public static final String EVENT = "close_inactive_agent";

}
