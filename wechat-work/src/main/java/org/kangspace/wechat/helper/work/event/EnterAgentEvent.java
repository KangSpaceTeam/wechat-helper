package org.kangspace.wechat.helper.work.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 进入应用 <br>
 * 接口文档:
 * <a href="https://developer.work.weixin.qq.com/document/path/90240">https://developer.work.weixin.qq.com/document/path/90240</a> <br>
 * <p>
 * 本事件触发时机为：<br>
 * 1. 本事件在成员进入企业微信的应用时触发<br>
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EnterAgentEvent extends WeComXmlEvent {
    public static final String EVENT = "enter_agent";

}
