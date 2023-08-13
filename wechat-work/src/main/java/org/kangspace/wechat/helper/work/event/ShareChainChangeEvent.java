package org.kangspace.wechat.helper.work.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 上下游共享应用事件回调 <br>
 * 接口文档:
 * <a href="https://developer.work.weixin.qq.com/document/path/90240">https://developer.work.weixin.qq.com/document/path/90240</a> <br>
 * <p>
 * 本事件触发时机为：<br>
 * 1. 上游企业把自建应用共享给下游企业使用<br>
 * 2. 上级企业把下级企业从共享应用中移除<br>
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShareChainChangeEvent extends WeComXmlEvent {
    public static final String EVENT = "share_chain_change";

}
