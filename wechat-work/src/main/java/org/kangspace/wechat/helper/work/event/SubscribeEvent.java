package org.kangspace.wechat.helper.work.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 成员关注事件 <br>
 * 接口文档:
 * <a href="https://developer.work.weixin.qq.com/document/path/90240">https://developer.work.weixin.qq.com/document/path/90240</a> <br>
 * <p>
 * 本事件触发时机为：<br>
 * 1. 成员已经加入企业，管理员添加成员到应用可见范围(或移除可见范围)时<br>
 * 2. 成员已经在应用可见范围，成员加入(或退出)企业时<br>
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SubscribeEvent extends WeComXmlEvent {
    public static final String EVENT = "subscribe";

}
