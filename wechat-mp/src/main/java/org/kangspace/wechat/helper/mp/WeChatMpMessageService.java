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
}
