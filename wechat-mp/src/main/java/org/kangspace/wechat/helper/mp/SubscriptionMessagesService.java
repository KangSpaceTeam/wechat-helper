package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.mp.bean.*;

import javax.annotation.Nonnull;

/**
 * 微信公众号"订阅通知接口"相关Service<br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html</a><br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/08
 */
public interface SubscriptionMessagesService extends WeChatMpService {

    /**
     * 选用模板 <br>
     * 从公共模板库中选用模板，到私有模板库中
     *
     * @param request {@link NewTmplAddTemplateRequest}
     * @return {@link NewTmplAddTemplateResponse}
     */
    NewTmplAddTemplateResponse addTemplate(@Nonnull NewTmplAddTemplateRequest request);

    /**
     * 删除模板 <br>
     * 删除私有模板库中的模板
     *
     * @param request {@link NewTmplDelTemplateRequest}
     * @return {@link WeChatMpResponseEntity}
     */
    WeChatMpResponseEntity delTemplate(@Nonnull NewTmplDelTemplateRequest request);

    /**
     * 获取公众号类目 <br>
     * 获取公众号所属类目，可用于查询类目下的公共模板
     *
     * @return {@link NewTmplGetCategoryResponse}
     */
    NewTmplGetCategoryResponse getCategory();

    /**
     * 获取模板中的关键词 <br>
     * 获取公共模板下的关键词列表
     *
     * @param tid 模板标题 id，可通过接口获取
     * @return {@link NewTmplGetPubTemplateKeyWordsResponse}
     */
    NewTmplGetPubTemplateKeyWordsResponse getPubTemplateKeyWordsById(@Nonnull String tid);

    /**
     * 获取类目下的公共模板 <br>
     * 获取类目下的公共模板，可从中选用模板使用
     *
     * @param ids   类目 id，多个用逗号隔开
     * @param start 用于分页，表示从 start 开始，从 0 开始计数
     * @param limit 用于分页，表示拉取 limit 条记录，最大为 30
     * @return {@link NewTmplGetPubTemplateTitlesResponse}
     */
    NewTmplGetPubTemplateTitlesResponse getPubTemplateTitles(@Nonnull String ids, @Nonnull Integer start, @Nonnull Integer limit);

    /**
     * 获取私有模板列表 <br>
     * 获取私有的模板列表
     *
     * @return {@link NewTmplGetTemplateListResponse}
     */
    NewTmplGetTemplateListResponse getTemplateList();

    /**
     * 发送订阅通知<br>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html#send%E5%8F%91%E9%80%81%E8%AE%A2%E9%98%85%E9%80%9A%E7%9F%A5">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html#send%E5%8F%91%E9%80%81%E8%AE%A2%E9%98%85%E9%80%9A%E7%9F%A5</a>
     *
     * @param request {@link MessageTemplateSubscribeRequest}
     * @return {@link WeChatMpResponseEntity}
     * @see {@link WeChatMpMessageService#subscribeBizSend(MessageTemplateSubscribeRequest)}
     */
    WeChatMpResponseEntity subscribeBizSend(MessageTemplateSubscribeRequest request);
}
