package org.kangspace.wechat.helper.mp.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 微信认证事件推送-资质认证成功<br>
 * <p>
 * 为了帮助公众号开发者获取公众号的认证状态，也为了第三方平台开发者获知旗下公众号的认证状态，微信公众平台提供了公众号认证过程中各个阶段的事件推送。 <br>
 * 事件推送到哪里？ <br>
 * 1、事件推送将会推送给公众号在公众平台官网开发者中心设置的服务地址中 <br>
 * 2、如果公众号已将帐号管理权限集（因为该接口权限从属于帐号管理权限集）授权给第三方平台，那么将由第三方平台代公众号接收事件推送，具体是推送到第三方平台的公众号消息与事件接收URL <br>
 * 请注意：<br>
 * 1、资质认证成功后，公众号就获得了认证相关接口权限，资质认证成功一定发生在名称认证成功之前 <br>
 * 2、名称认证成功后，公众号才在微信客户端中获得打勾认证标识 <br>
 * </p>
 * 文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Account_Management/Wechat_Accreditation_Event_Push.html">https://developers.weixin.qq.com/doc/offiaccount/Account_Management/Wechat_Accreditation_Event_Push.html</a><br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/05/27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class QualificationVerifySuccessEvent extends WeChatMpXmlEvent {

    /**
     * 有效期 (整型)，指的是时间戳，将于该时间戳认证过期
     */
    @JacksonXmlProperty(localName = "ExpiredTime")
    @JacksonXmlCData
    private Long expiredTime;
}
