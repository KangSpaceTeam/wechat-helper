package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.core.util.TokenUtil;
import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;
import org.kangspace.wechat.helper.mp.token.WeChatMpAccessTokenService;

import java.util.Objects;

/**
 * 微信公众号openApi管理相关Service实现类
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/4
 */
public class DefaultWeChatMpOpenApiService extends AbstractWeChatMpService implements WeChatMpOpenApiService {
    public DefaultWeChatMpOpenApiService(WeChatMpConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultWeChatMpOpenApiService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService) {
        super(weChatConfig, weChatMpAccessTokenService);
    }

    public DefaultWeChatMpOpenApiService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weChatConfig, weChatMpAccessTokenService, requestFilterChain);
    }

    @Override
    public WeChatMpResponseEntity clearQuota(String accessToken, String appId) {
        Objects.requireNonNull(accessToken, "accessToken must be not null");
        Objects.requireNonNull(appId, "appId must be not null");
        String url = WeChatMpApiPaths.CLEAR_QUOTA;
        url = TokenUtil.appendAccessToken(url, accessToken);
        MpOpenApiClearQuotaParam param = new MpOpenApiClearQuotaParam(appId);
        return post(url, param, WeChatMpResponseEntity.class, isNeedAccessToken());
    }

    @Override
    public MpOpenApiQuotaGetResponse quotaGet(String accessToken, String cgiPath) {
        Objects.requireNonNull(accessToken, "accessToken must be not null");
        Objects.requireNonNull(cgiPath, "cgiPath must be not null");
        String url = WeChatMpApiPaths.OPENAPI_QUOTA_GET;
        url = TokenUtil.appendAccessToken(url, accessToken);
        MpOpenApiQuotaGetParam param = new MpOpenApiQuotaGetParam(cgiPath);
        return post(url, param, MpOpenApiQuotaGetResponse.class, isNeedAccessToken());
    }

    @Override
    public MpOpenApiRidGetResponse ridGet(String accessToken, String rid) {
        Objects.requireNonNull(accessToken, "accessToken must be not null");
        Objects.requireNonNull(rid, "rid must be not null");
        String url = WeChatMpApiPaths.OPENAPI_RID_GET;
        url = TokenUtil.appendAccessToken(url, accessToken);
        MpOpenApiRidGetParam param = new MpOpenApiRidGetParam(rid);
        return post(url, param, MpOpenApiRidGetResponse.class, isNeedAccessToken());
    }

    @Override
    public boolean isNeedAccessToken() {
        return false;
    }
}
