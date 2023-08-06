package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.bean.MessageRecallRequest;
import org.kangspace.wechat.helper.work.bean.MessageSendResponse;
import org.kangspace.wechat.helper.work.bean.MessageUpdateTemplateCardResponse;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;
import org.kangspace.wechat.helper.work.message.push.WeComPushMessage;
import org.kangspace.wechat.helper.work.message.push.update.UpdateTemplateCardMessage;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

/**
 * <p>
 * 企业微信"消息推送"相关 Service默认实现 <br>
 * <a href="https://developer.work.weixin.qq.com/document/path/90235">https://developer.work.weixin.qq.com/document/path/90235</a>
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
public class DefaultMessageService extends AbstractWeComService implements MessageService {

    public DefaultMessageService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultMessageService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultMessageService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }

    @Override
    public MessageSendResponse messageSend(WeComPushMessage message) {
        String url = WeComApiPaths.MESSAGE_SEND;
        return post(url, message, MessageSendResponse.class);
    }

    @Override
    public MessageUpdateTemplateCardResponse messageUpdateTemplateCard(UpdateTemplateCardMessage updateMessage) {
        String url = WeComApiPaths.MESSAGE_UPDATE_TEMPLATE_CARD;
        return post(url, updateMessage, MessageUpdateTemplateCardResponse.class);
    }

    @Override
    public WeComResponseEntity messageRecall(MessageRecallRequest request) {
        String url = WeComApiPaths.MESSAGE_RECALL;
        return post(url, request, MessageUpdateTemplateCardResponse.class);
    }
}
