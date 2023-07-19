package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.bean.UserBatchDeleteRequest;
import org.kangspace.wechat.helper.work.bean.UserRequest;
import org.kangspace.wechat.helper.work.bean.UserResponse;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

/**
 * <p>
 * 企业微信"通讯录管理-成员管理"相关 Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/17
 */
public class DefaultUserService extends AbstractWeComService implements UserService {

    public DefaultUserService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultUserService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultUserService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }

    @Override
    public UserResponse userGet(String userId) {
        String url = urlTransfer(WeComApiPaths.USER_GET, userId);
        return get(url, UserResponse.class);
    }

    @Override
    public WeComResponseEntity userCreate(UserRequest request) {
        String url = WeComApiPaths.USER_CREATE;
        return post(url, request, WeComResponseEntity.class);
    }

    @Override
    public WeComResponseEntity userUpdate(UserRequest request) {
        String url = WeComApiPaths.USER_UPDATE;
        return post(url, request, WeComResponseEntity.class);
    }

    @Override
    public WeComResponseEntity userDelete(String userId) {
        String url = urlTransfer(WeComApiPaths.USER_DELETE, userId);
        return get(url, UserResponse.class);
    }

    @Override
    public WeComResponseEntity userBatchDelete(UserBatchDeleteRequest request) {
        String url = WeComApiPaths.USER_BATCH_DELETE;
        return post(url, request, WeComResponseEntity.class);
    }
}
