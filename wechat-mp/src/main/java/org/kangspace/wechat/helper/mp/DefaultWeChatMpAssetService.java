package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.token.WeChatMpAccessTokenService;

/**
 * 微信公众号"素材管理"相关Service 默认实现
 *
 * @author kangxuefeng
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
        // TODO post form
        String url = null;
        return null;
    }

    @Override
    public MediaGetResponse mediaGet(String mediaId) {
        return null;
    }

    @Override
    public MediaGetResponse mediaGetJsSdk(String mediaId) {
        return null;
    }

    @Override
    public MediaUploadImgResponse mediaUploadImg(MediaUploadImgRequest request) {
        return null;
    }

    @Override
    public MediaAddResponse materialAdd(MaterialAddRequest request) {
        return null;
    }

    @Override
    public MediaAddResponse materialGet(String mediaId) {
        return null;
    }

    @Override
    public WeChatMpResponseEntity materialDel(MaterialDelRequest request) {
        return null;
    }

    @Override
    public MediaGetCountResponse materialGetCount() {
        return null;
    }

    @Override
    public MaterialBatchGetResponse materialBatchGet(MaterialBatchGetRequest request) {
        return null;
    }
}
