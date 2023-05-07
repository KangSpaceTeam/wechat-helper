package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;
import org.kangspace.wechat.helper.mp.request.filter.WeChatMpRequestFilterChainFactory;
import org.kangspace.wechat.helper.mp.token.DefaultWeChatMpAccessTokenService;
import org.kangspace.wechat.helper.mp.token.WeChatMpAccessTokenService;

/**
 * <p>
 * 微信公众号"用户管理 "相关Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/7
 */
public class DefaultUserManagementService extends AbstractWeChatMpService implements UserManagementService {

    public DefaultUserManagementService(WeChatMpConfig weChatConfig) {
        this(weChatConfig, new DefaultWeChatMpAccessTokenService(weChatConfig));
    }

    public DefaultUserManagementService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService) {
        this(weChatConfig, weChatMpAccessTokenService, WeChatMpRequestFilterChainFactory.defaultRequestFilterChain());
    }

    public DefaultUserManagementService(WeChatMpConfig weChatConfig, WeChatMpAccessTokenService weChatMpAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weChatConfig, weChatMpAccessTokenService, requestFilterChain);
    }

    @Override
    public UserTagsCreateResponse tagsCreate(UserTagsUpdateRequest request) {
        String url = WeChatMpApiPaths.TAGS_CREATE;
        return post(url, request, UserTagsCreateResponse.class);
    }

    @Override
    public UserTagsGetResponse tagsGet() {
        String url = WeChatMpApiPaths.TAGS_GET;
        return get(url, UserTagsGetResponse.class);
    }

    @Override
    public WeChatMpResponseEntity tagsUpdate(UserTagsUpdateRequest request) {
        String url = WeChatMpApiPaths.TAGS_UPDATE;
        return post(url, request, WeChatMpResponseEntity.class);
    }

    @Override
    public WeChatMpResponseEntity tagsDelete(UserTagsUpdateRequest request) {
        String url = WeChatMpApiPaths.TAGS_DELETE;
        return post(url, request, WeChatMpResponseEntity.class);
    }

    @Override
    public UserTagGetResponse userTagGet(UserTagGetRequest request) {
        String url = WeChatMpApiPaths.USER_TAG_GET;
        return post(url, request, UserTagGetResponse.class);
    }

    @Override
    public WeChatMpResponseEntity tagsMembersBatchTagging(UserTagsBatchTaggingRequest request) {
        String url = WeChatMpApiPaths.TAGS_MEMBERS_BATCH_TAGGING;
        return post(url, request, WeChatMpResponseEntity.class);
    }

    @Override
    public WeChatMpResponseEntity tagsMembersBatchUntagging(UserTagsBatchTaggingRequest request) {
        String url = WeChatMpApiPaths.TAGS_MEMBERS_BATCH_UNTAGGING;
        return post(url, request, WeChatMpResponseEntity.class);
    }

    @Override
    public UserTagsGetIdListResponse tagsGetIdList(UserTagsGetIdListRequest request) {
        String url = WeChatMpApiPaths.TAGS_GET_ID_LIST;
        return post(url, request, UserTagsGetIdListResponse.class);
    }
}
