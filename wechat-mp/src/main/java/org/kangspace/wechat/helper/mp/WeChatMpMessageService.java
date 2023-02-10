package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import javax.annotation.Nonnull;

/**
 * 微信公众号"基础消息能力"Service<br>
 * 模板消息: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html</a><br>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/11
 */
public interface WeChatMpMessageService extends WeChatMpService {
    /**
     * 模板消息-设置所属行业
     *
     * @param request {@link TemplateApiSetIndustryRequest}
     * @return {@link WeChatMpResponseEntity}
     * @see WeChatMpApiPaths#TEMPLATE_API_SET_INDUSTRY
     */
    WeChatMpResponseEntity templateApiSetIndustry(@Nonnull TemplateApiSetIndustryRequest request);

    /**
     * 模板消息-获取设置的行业信息
     *
     * @return {@link TemplateGetIndustryResponse}
     * @see WeChatMpApiPaths#TEMPLATE_GET_INDUSTRY
     */
    TemplateGetIndustryResponse templateGetIndustry();

    /**
     * 模板消息-获得模板ID
     *
     * @param request {@link TemplateApiAddTemplateRequest}
     * @return {@link TemplateApiAddTemplateResponse}
     * @see WeChatMpApiPaths#TEMPLATE_API_ADD_TEMPLATE
     */
    TemplateApiAddTemplateResponse templateApiAddTemplate(@Nonnull TemplateApiAddTemplateRequest request);

    /**
     * 模板消息-获取模板列表
     *
     * @return {@link TemplateGetAllPrivateTemplateResponse}
     * @see WeChatMpApiPaths#TEMPLATE_GET_ALL_PRIVATE_TEMPLATE
     */
    TemplateGetAllPrivateTemplateResponse templateGetAllPrivateTemplate();

    /**
     * 模板消息-删除模板
     *
     * @param request {@link TemplateDelPrivateTemplateRequest}
     * @return {@link WeChatMpResponseEntity}
     * @see WeChatMpApiPaths#TEMPLATE_DEL_PRIVATE_TEMPLATE
     */
    WeChatMpResponseEntity templateDelPrivateTemplate(@Nonnull TemplateDelPrivateTemplateRequest request);

    /**
     * 模板消息-发送模板消息
     *
     * @param request {@link MessageTemplateSendRequest}
     * @return {@link MessageTemplateSendResponse}
     * @see WeChatMpApiPaths#MESSAGE_TEMPLATE_SEND
     * @see org.kangspace.wechat.helper.mp.constant.MessageConstant.Color
     */
    MessageTemplateSendResponse messageTemplateSend(MessageTemplateSendRequest request);

    /**
     * 获取公众号的自动回复规则
     *
     * @return {@link GetCurrentAutoReplyInfoResponse}
     */
    GetCurrentAutoReplyInfoResponse getCurrentAutoReplyInfo();

    /**
     * 公众号一次性订阅消息: 获取授权链接
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/One-time_subscription_info.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/One-time_subscription_info.html</a>
     *
     * @param appId       公众号的唯一标识
     * @param scene       重定向后会带上 scene 参数，开发者可以填0-10000的整型值，用来标识订阅场景值
     * @param templateId  订阅消息模板ID，登录公众平台后台，在接口权限列表处可查看订阅模板ID
     * @param redirectUrl 授权后重定向的回调地址，请使用 UrlEncode 对链接进行处理。 注：要求redirect_url的域名要跟登记的业务域名一致，且业务域名不能带路径。 业务域名需登录公众号，在设置 - 公众号设置 - 功能设置里面对业务域名设置
     * @param reserved    用于保持请求和回调的状态，授权请后原样带回给第三方。该参数可用于防止 csrf 攻击（跨站请求伪造攻击），建议第三方带上该参数，可设置为简单的随机数加 session 进行校验，开发者可以填写a-zA-Z0-9的参数值，最多128字节，要求做urlencode
     * @return 授权链接
     */
    String subscribeMsg(String appId, String scene, String templateId, String redirectUrl, String reserved);

    /**
     * 公众号一次性订阅消息: 发送订阅消息
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/One-time_subscription_info.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/One-time_subscription_info.html</a>
     *
     * @param request {@link MessageTemplateSubscribeRequest}
     * @return {@link WeChatMpResponseEntity}
     */
    WeChatMpResponseEntity subscribe(MessageTemplateSubscribeRequest request);

    /**
     * 发送订阅通知<br>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html#send%E5%8F%91%E9%80%81%E8%AE%A2%E9%98%85%E9%80%9A%E7%9F%A5">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html#send%E5%8F%91%E9%80%81%E8%AE%A2%E9%98%85%E9%80%9A%E7%9F%A5</a>
     *
     * @param request {@link MessageTemplateSubscribeRequest}
     * @return {@link WeChatMpResponseEntity}
     */
    WeChatMpResponseEntity subscribeBizSend(MessageTemplateSubscribeRequest request);

// TODO 群发接口
}
