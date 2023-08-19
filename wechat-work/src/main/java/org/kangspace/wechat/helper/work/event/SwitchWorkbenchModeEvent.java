package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 菜单事件-点击菜单拉取消息的事件推送 <br>
 * 接口文档:
 * <a href="https://developer.work.weixin.qq.com/document/path/92535">https://developer.work.weixin.qq.com/document/path/92535</a> <br>
 * <p>
 * 管理员在管理端应用详情页的自定义工作台页面启用或者停用自定义工作台模式时，会推送接收修改设置工作台自定义开关事件推送到应用的回调url上（如果是第三方应用为数据回调url）。事件推送处理过程详见接收消息与事件。<br>
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SwitchWorkbenchModeEvent extends WeComXmlEvent {
    public static final String EVENT = "switch_workbench_mode";

    /**
     * 1表示开启工作台自定义模式，0表示关闭工作台自定义模式
     */
    @JacksonXmlProperty(localName = "Mode")
    private String mode;

    /**
     * 企业应用的id，整型。可在应用的设置页面查看
     */
    @JacksonXmlProperty(localName = "AgentID")
    @JacksonXmlCData
    private String agentId;

}
