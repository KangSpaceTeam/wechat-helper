package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.bean.MediaUploadRequest;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.bean.WebHookUploadMediaResponse;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;
import org.kangspace.wechat.helper.work.message.webhook.WebHookMessage;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

import javax.annotation.Nonnull;

/**
 * <p>
 * 企业微信"群机器人"相关 Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
public class DefaultWebHookService extends AbstractWeComService implements WebHookService {

    public DefaultWebHookService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultWebHookService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultWebHookService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }

    @Override
    public WeComResponseEntity webhookSend(@Nonnull String key, @Nonnull WebHookMessage message) {
        String url = urlTransfer(WeComApiPaths.WEBHOOK_SEND, key);
        return post(url, message, WeComResponseEntity.class, false);
    }

    @Override
    public WebHookUploadMediaResponse webhookUploadMedia(@Nonnull String key, @Nonnull String type, @Nonnull MediaUploadRequest request) {
        String url = urlTransfer(WeComApiPaths.WEBHOOK_UPLOAD_MEDIA, key, type);
        return post(url, request, WebHookUploadMediaResponse.class, false);
    }
}
