package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

import javax.annotation.Nonnull;

/**
 * <p>
 * 企业微信"素材管理"相关 Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/9/6
 */
public class DefaultMediaService extends AbstractWeComService implements MediaService {

    public DefaultMediaService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultMediaService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultMediaService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }

    @Override
    public MediaUploadResponse mediaUpload(@Nonnull MediaUploadRequest request) {
        String url = urlTransfer(WeComApiPaths.MEDIA_UPLOAD, request.getType());
        return post(url, request, MediaUploadResponse.class);
    }

    @Override
    public MediaUploadImgResponse mediaUploadImg(@Nonnull MediaUploadImgRequest request) {
        String url = WeComApiPaths.MEDIA_UPLOAD_IMG;
        return post(url, request, MediaUploadImgResponse.class);
    }

    @Override
    public MediaGetResponse mediaGet(@Nonnull String mediaId) {
        String url = urlTransfer(WeComApiPaths.MEDIA_GET, mediaId);
        return get(url, MediaGetResponse.class);
    }

    @Override
    public MediaGetResponse mediaGetJsSdK(@Nonnull String mediaId) {
        String url = urlTransfer(WeComApiPaths.MEDIA_GET_JS_SDK, mediaId);
        return get(url, MediaGetResponse.class);
    }

    @Override
    public MediaUploadByUrlResponse mediaUploadByUrl(@Nonnull MediaUploadByUrlRequest request) {
        String url = WeComApiPaths.MEDIA_UPLOAD_BY_URL;
        return post(url, request, MediaUploadByUrlResponse.class);
    }

    @Override
    public MediaGetUploadByUrlResultResponse mediaGetUploadByUrlResult(@Nonnull MediaGetUploadByUrlResultRequest request) {
        String url = WeComApiPaths.MEDIA_GET_UPLOAD_BY_URL_RESULT;
        return post(url, request, MediaGetUploadByUrlResultResponse.class);
    }
}
