package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 菜单事件-弹出微信相册发图器的事件推送 <br>
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
public class PicWeiXinEvent extends WeComXmlEvent {
    public static final String EVENT = "pic_weixin";

    /**
     * 发送的图片信息
     */
    @JacksonXmlProperty(localName = "SendPicsInfo")
    private SendPicsInfo sendPicsInfo;
}
