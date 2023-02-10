package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.core.constant.StringLiteral;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;
import org.kangspace.wechat.helper.mp.token.WeChatMpAccessTokenService;

import javax.annotation.Nonnull;

/**
 * 微信公众号"订阅通知接口"相关Service 默认实现
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/17
 */
public class DefaultSubscriptionMessagesService extends AbstractWeChatMpService implements SubscriptionMessagesService {

    public DefaultSubscriptionMessagesService(WeChatMpConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultSubscriptionMessagesService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService) {
        super(weChatConfig, weChatMpAccessTokenService);
    }

    public DefaultSubscriptionMessagesService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weChatConfig, weChatMpAccessTokenService, requestFilterChain);
    }

    @Override
    public NewTmplAddTemplateResponse addTemplate(@Nonnull NewTmplAddTemplateRequest request) {
        String url = WeChatMpApiPaths.NEW_TMPL_ADD_TEMPLATE;
        return post(url, request, NewTmplAddTemplateResponse.class);
    }

    @Override
    public WeChatMpResponseEntity delTemplate(@Nonnull NewTmplDelTemplateRequest request) {
        String url = WeChatMpApiPaths.NEW_TMPL_DEL_TEMPLATE;
        return post(url, request, WeChatMpResponseEntity.class);
    }

    @Override
    public NewTmplGetCategoryResponse getCategory() {
        String url = WeChatMpApiPaths.NEW_TMPL_GET_CATEGORY;
        return get(url, NewTmplGetCategoryResponse.class);
    }

    @Override
    public NewTmplGetPubTemplateKeyWordsResponse getPubTemplateKeyWordsById(@Nonnull String tid) {
        String url = WeChatMpApiPaths.NEW_TMPL_GET_PUB_TEMPLATE_KEYWORDS;
        url += StringLiteral.QUESTION_MARK + "tid=" + tid;
        return get(url, NewTmplGetPubTemplateKeyWordsResponse.class);
    }

    @Override
    public NewTmplGetPubTemplateTitlesResponse getPubTemplateTitles(@Nonnull String ids, @Nonnull Integer start, @Nonnull Integer limit) {
        String url = WeChatMpApiPaths.NEW_TMPL_GET_PUB_TEMPLATE_TITLES;
        url += StringLiteral.QUESTION_MARK + "ids=" + ids + StringLiteral.AND + "start=" + start + StringLiteral.AND + "limit=" + limit;
        return get(url, NewTmplGetPubTemplateTitlesResponse.class);
    }

    @Override
    public NewTmplGetTemplateListResponse getTemplateList() {
        String url = WeChatMpApiPaths.NEW_TMPL_GET_TEMPLATE;
        return get(url, NewTmplGetTemplateListResponse.class);
    }

    @Override
    public WeChatMpResponseEntity subscribeBizSend(MessageTemplateSubscribeRequest request) {
        return of(DefaultWeChatMpMessageService.class).subscribeBizSend(request);
    }
}
