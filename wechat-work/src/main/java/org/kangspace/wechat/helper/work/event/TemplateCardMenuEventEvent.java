package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 菜单事件-通用模板卡片右上角菜单事件推送 <br>
 * 接口文档:
 * <a href="https://developer.work.weixin.qq.com/document/path/90240">https://developer.work.weixin.qq.com/document/path/90240</a> <br>
 * <p>
 * 成员点击自定义菜单后，企业微信会把点击事件推送给应用。<br>
 * 点击菜单弹出子菜单，不会产生上报。<br>
 * 企业微信iPhone1.2.2/Android1.2.2版本开始支持菜单事件，旧版本企业微信成员点击后将没有回应，应用不能正常接收到事件推送。<br>
 * 自定义菜单可以在管理后台的应用设置界面配置。<br>
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TemplateCardMenuEventEvent extends WeComXmlEvent {
    public static final String EVENT = "template_card_menu_event";

    /**
     * 与发送模板卡片消息时指定的task_id相同
     */
    @JacksonXmlProperty(localName = "TaskId")
    @JacksonXmlCData
    private String taskId;
    /**
     * 通用模板卡片的类型，类型有"text_notice", "news_notice", "button_interaction", "vote_interaction", "multiple_interaction"五种
     */
    @JacksonXmlProperty(localName = "CardType")
    @JacksonXmlCData
    private String cardType;
    /**
     * 用于调用更新卡片接口的ResponseCode，72小时内有效，且只能使用一次
     */
    @JacksonXmlProperty(localName = "ResponseCode")
    @JacksonXmlCData
    private String responseCode;

}
