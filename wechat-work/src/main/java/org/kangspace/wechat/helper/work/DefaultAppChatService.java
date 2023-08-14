package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.bean.appchat.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

import javax.annotation.Nonnull;

/**
 * <p>
 * 企业微信"应用发送消息到群聊会话"相关 Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/14
 */
public class DefaultAppChatService extends AbstractWeComService implements AppChatService {

    public DefaultAppChatService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultAppChatService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultAppChatService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }

    @Override
    public AppChatCreateResponse appChatCreate(@Nonnull AppChatCreateRequest request) {
        String url = WeComApiPaths.APP_CHAT_CREATE;
        return post(url, request, AppChatCreateResponse.class);
    }

    @Override
    public WeComResponseEntity appChatUpdate(@Nonnull AppChatUpdateRequest request) {
        String url = WeComApiPaths.APP_CHAT_UPDATE;
        return post(url, request, WeComResponseEntity.class);
    }

    @Override
    public AppChatGetResponse appChatGet(@Nonnull String chatId) {
        String url = urlTransfer(WeComApiPaths.APP_CHAT_GET, chatId);
        return get(url, AppChatGetResponse.class);
    }

    @Override
    public WeComResponseEntity appChatSend(@Nonnull AppChatMessage message) {
        String url = WeComApiPaths.APP_CHAT_SEND;
        return post(url, message, WeComResponseEntity.class);
    }
}
