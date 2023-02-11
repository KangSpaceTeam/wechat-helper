package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import javax.annotation.Nonnull;

/**
 * 微信公众号"基础消息能力"Service默认实现
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/11
 */
public class DefaultMessageService extends AbstractWeChatMpService implements MessageService {
    public DefaultMessageService(WeChatMpConfig weChatConfig) {
        super(weChatConfig);
    }

    @Override
    public WeChatMpResponseEntity templateApiSetIndustry(@Nonnull TemplateApiSetIndustryRequest request) {
        String url = WeChatMpApiPaths.TEMPLATE_API_SET_INDUSTRY;
        return post(url, request, WeChatMpResponseEntity.class);
    }

    @Override
    public TemplateGetIndustryResponse templateGetIndustry() {
        String url = WeChatMpApiPaths.TEMPLATE_GET_INDUSTRY;
        return get(url, TemplateGetIndustryResponse.class);
    }

    @Override
    public TemplateApiAddTemplateResponse templateApiAddTemplate(@Nonnull TemplateApiAddTemplateRequest request) {
        String url = WeChatMpApiPaths.TEMPLATE_API_ADD_TEMPLATE;
        return post(url, request, TemplateApiAddTemplateResponse.class);
    }

    @Override
    public TemplateGetAllPrivateTemplateResponse templateGetAllPrivateTemplate() {
        String url = WeChatMpApiPaths.TEMPLATE_GET_ALL_PRIVATE_TEMPLATE;
        return get(url, TemplateGetAllPrivateTemplateResponse.class);
    }

    @Override
    public WeChatMpResponseEntity templateDelPrivateTemplate(@Nonnull TemplateDelPrivateTemplateRequest request) {
        String url = WeChatMpApiPaths.TEMPLATE_DEL_PRIVATE_TEMPLATE;
        return post(url, request, WeChatMpResponseEntity.class);
    }

    @Override
    public MessageTemplateSendResponse messageTemplateSend(MessageTemplateSendRequest request) {
        String url = WeChatMpApiPaths.MESSAGE_TEMPLATE_SEND;
        return post(url, request, MessageTemplateSendResponse.class);
    }

    @Override
    public GetCurrentAutoReplyInfoResponse getCurrentAutoReplyInfo() {
        String url = WeChatMpApiPaths.GET_CURRENT_AUTOREPLY_INFO;
        return get(url, GetCurrentAutoReplyInfoResponse.class);
    }

    @Override
    public String subscribeMsg(String appId, String scene, String templateId, String redirectUrl, String reserved) {
        return WeChatMpApiPaths.messageSubscribeMsgUrl(appId, scene, templateId, redirectUrl, reserved);
    }

    @Override
    public WeChatMpResponseEntity subscribe(MessageTemplateSubscribeRequest request) {
        String url = WeChatMpApiPaths.MESSAGE_TEMPLATE_SUBSCRIBE;
        return post(url, request, WeChatMpResponseEntity.class);
    }

    @Override
    public WeChatMpResponseEntity subscribeBizSend(MessageSubscribeBizSendRequest request) {
        String url = WeChatMpApiPaths.MESSAGE_TEMPLATE_SUBSCRIBE;
        return post(url, request, WeChatMpResponseEntity.class);
    }
}
