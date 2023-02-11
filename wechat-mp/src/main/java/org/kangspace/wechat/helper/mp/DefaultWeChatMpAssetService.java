package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.core.constant.StringLiteral;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;
import org.kangspace.wechat.helper.mp.token.WeChatMpAccessTokenService;

import javax.annotation.Nonnull;

/**
 * 微信公众号"素材管理"相关Service 默认实现
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/17
 */
public class DefaultWeChatMpAssetService extends AbstractWeChatMpService implements WeChatMpAssetService {
    public DefaultWeChatMpAssetService(WeChatMpConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultWeChatMpAssetService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService) {
        super(weChatConfig, weChatMpAccessTokenService);
    }

    public DefaultWeChatMpAssetService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weChatConfig, weChatMpAccessTokenService, requestFilterChain);
    }

    @Override
    public MediaUploadResponse mediaUpload(MediaUploadRequest request) {
        String url = WeChatMpApiPaths.MEDIA_UPLOAD;
        url += StringLiteral.QUESTION_MARK + "type=" + request.getType().getValue();
        return post(url, request, MediaUploadResponse.class);
    }

    @Override
    public MediaGetResponse mediaGet(@Nonnull String mediaId) {
        String url = WeChatMpApiPaths.MEDIA_GET;
        url += StringLiteral.QUESTION_MARK + "media_id=" + mediaId;
        return get(url, MediaGetResponse.class);
    }

    @Override
    public MediaGetResponse mediaGetJsSdk(@Nonnull String mediaId) {
        String url = WeChatMpApiPaths.MEDIA_GET_JS_SDK;
        url += StringLiteral.QUESTION_MARK + "media_id=" + mediaId;
        return get(url, MediaGetResponse.class);
    }

    @Override
    public MediaUploadImgResponse mediaUploadImg(MediaUploadImgRequest request) {
        String url = WeChatMpApiPaths.MEDIA_UPLOAD_IMG;
        return post(url, request, MediaUploadImgResponse.class);
    }

    @Override
    public MediaAddResponse materialAdd(MaterialAddRequest request) {
        String url = WeChatMpApiPaths.MATERIAL_ADD_MATERIAL;
        url += StringLiteral.QUESTION_MARK + "type=" + request.getType().getValue();
        return post(url, request, MediaAddResponse.class);
    }

    @Override
    public MaterialGetResponse materialGet(@Nonnull MaterialGetRequest request) {
        String url = WeChatMpApiPaths.MATERIAL_GET_MATERIAL;
        return post(url, request, MaterialGetResponse.class);
    }

    @Override
    public WeChatMpResponseEntity materialDel(MaterialDelRequest request) {
        String url = WeChatMpApiPaths.MATERIAL_DEL_MATERIAL;
        return post(url, request, WeChatMpResponseEntity.class);
    }

    @Override
    public MediaGetCountResponse materialGetCount() {
        String url = WeChatMpApiPaths.MATERIAL_GET_MATERIAL_COUNT;
        return get(url, MediaGetCountResponse.class);
    }

    @Override
    public MaterialBatchGetResponse materialBatchGet(MaterialBatchGetRequest request) {
        String url = WeChatMpApiPaths.MATERIAL_BATCH_GET_MATERIAL;
        return post(url, request, MaterialBatchGetResponse.class);
    }
}
