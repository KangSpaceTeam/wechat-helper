package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

import javax.annotation.Nonnull;

/**
 * <p>
 * 企业微信"通讯录管理-标签管理"相关 Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/21
 */
public class DefaultTagService extends AbstractWeComService implements TagService {

    public DefaultTagService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultTagService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultTagService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }

    @Override
    public TagCreateResponse tagCreate(TagRequest request) {
        String url = WeComApiPaths.TAG_CREATE;
        return post(url, request, TagCreateResponse.class);
    }

    @Override
    public WeComResponseEntity tagUpdate(TagUpdateRequest request) {
        String url = WeComApiPaths.TAG_UPDATE;
        return post(url, request, WeComResponseEntity.class);
    }

    @Override
    public WeComResponseEntity tagDelete(@Nonnull Long tagId) {
        String url = urlTransfer(WeComApiPaths.TAG_DELETE, tagId.toString());
        return get(url, WeComResponseEntity.class);
    }

    @Override
    public TagUserResponse tagGet(@Nonnull Long tagId) {
        String url = urlTransfer(WeComApiPaths.TAG_GET, tagId.toString());
        return get(url, TagUserResponse.class);
    }

    @Override
    public TagUpdateTagUsersResponse tagAddTagUsers(@Nonnull TagUpdateTagUsersRequest request) {
        String url = WeComApiPaths.TAG_ADD_TAG_USERS;
        return post(url, request, TagUpdateTagUsersResponse.class);
    }

    @Override
    public TagUpdateTagUsersResponse tagDelTagUsers(@Nonnull TagUpdateTagUsersRequest request) {
        String url = WeComApiPaths.TAG_DEL_TAG_USERS;
        return post(url, request, TagUpdateTagUsersResponse.class);
    }

    @Override
    public TagListResponse tagList() {
        String url = WeComApiPaths.TAG_LIST;
        return get(url, TagListResponse.class);
    }
}
