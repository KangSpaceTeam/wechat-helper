package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;
import org.kangspace.wechat.helper.mp.request.filter.WeChatMpRequestFilterChainFactory;
import org.kangspace.wechat.helper.mp.token.DefaultWeChatMpAccessTokenService;
import org.kangspace.wechat.helper.mp.token.WeChatMpAccessTokenService;

import javax.annotation.Nonnull;

/**
 * <p>
 * 微信公众号"账户管理"相关Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/25
 */
public class DefaultAccountManagementService extends AbstractWeChatMpService implements AccountManagementService {

    public DefaultAccountManagementService(WeChatMpConfig weChatConfig) {
        this(new DefaultWeChatMpAccessTokenService(weChatConfig));
    }

    public DefaultAccountManagementService(WeChatMpAccessTokenService weChatMpAccessTokenService) {
        this(weChatMpAccessTokenService, WeChatMpRequestFilterChainFactory.defaultRequestFilterChain());
    }

    public DefaultAccountManagementService(WeChatMpAccessTokenService weChatMpAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weChatMpAccessTokenService, requestFilterChain);
    }

    @Override
    public QrcodeCreateResponse qrcodeCreate(@Nonnull QrcodeCreateRequest request) {
        String url = WeChatMpApiPaths.QRCODE_CREATE;
        return post(url, request, QrcodeCreateResponse.class);
    }

    @Override
    public MediaGetResponse showQrcode(@Nonnull String ticket) {
        String url = urlTransfer(WeChatMpApiPaths.SHOW_QRCODE, ticket);
        return get(url, MediaGetResponse.class, false);
    }

    @Override
    public ShortenGenResponse shortenGen(@Nonnull ShortenGenRequest request) {
        String url = WeChatMpApiPaths.SHORTEN_GEN;
        return post(url, request, ShortenGenResponse.class);
    }

    @Override
    public ShortenFetchResponse shortenFetch(@Nonnull ShortenFetchRequest request) {
        String url = WeChatMpApiPaths.SHORTEN_FETCH;
        return post(url, request, ShortenFetchResponse.class);
    }
}
