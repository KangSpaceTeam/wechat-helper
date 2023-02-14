package org.kangspace.wechat.helper.mp.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.ToString;
import org.kangspace.wechat.helper.mp.constant.WebAppConstant;

/**
 * 授权用户信息变更<br>
 * <p>
 * 1、 授权用户资料变更：当部分用户的资料存在风险时，平台会对用户资料进行清理，并通过消息推送服务器通知最近30天授权过的公众号开发者，我们建议开发者留意响应该事件，及时主动更新或清理用户的头像及昵称，降低风险。<br>
 * 2、 授权用户资料撤回：当用户撤回授权信息时，平台会通过消息推送服务器通知给公众号开发者，请开发者注意及时删除用户信息。<br>
 * 3、 授权用户完成注销：当授权用户完成注销后，平台会通过消息推送服务器通知给公众号开发者，请依法依规及时履行相应个人信息保护义务，保护用户权益。<br>
 * </p>
 * Event:user_info_modified：用户资料变更，user_authorization_revoke：用户撤回，user_authorization_cancellation：用户完成注销； <br>
 * 文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/authorization_change.html">https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/authorization_change.html</a><br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/14 22:39:15
 */
@Data
@ToString(callSuper = true)
public class UserAuthorizationRevokeEvent extends WeChatMpXmlEvent {


    /**
     * 授权用户OpenID
     */
    @JacksonXmlProperty(localName = "OpenID")
    @JacksonXmlCData
    private String openId;

    /**
     * 公众号的AppID
     */
    @JacksonXmlProperty(localName = "AppID")
    @JacksonXmlCData
    private String appId;

    /**
     * 用户撤回的H5授权信息，201:地址,202:发票信息,203:卡券信息,204:麦克风,205:昵称和头像,206:位置信息,207:选中的图片或视频
     * @see WebAppConstant.RevokeInfo
     */
    @JacksonXmlProperty(localName = "RevokeInfo")
    @JacksonXmlCData
    private String revokeInfo;
}
