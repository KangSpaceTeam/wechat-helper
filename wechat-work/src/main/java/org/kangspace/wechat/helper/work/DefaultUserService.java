package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

import javax.annotation.Nonnull;

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
    public UserResponse userGet(@Nonnull String userId) {
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

    @Override
    public UserSimpleListResponse userSimpleList(@Nonnull Long departmentId) {
        String url = urlTransfer(WeComApiPaths.USER_SIMPLE_LIST, departmentId.toString());
        return get(url, UserSimpleListResponse.class);
    }

    @Override
    public UserListResponse userList(@Nonnull Long departmentId) {
        String url = urlTransfer(WeComApiPaths.USER_LIST, departmentId.toString());
        return get(url, UserListResponse.class);
    }

    @Override
    public UserConvertToOpenIdResponse userConvertToOpenId(@Nonnull UserConvertToOpenIdRequest request) {
        String url = WeComApiPaths.USER_CONVERT_TO_OPEN_ID;
        return post(url, request, UserConvertToOpenIdResponse.class);
    }

    @Override
    public UserConvertToUserIdResponse userConvertToUserId(@Nonnull UserConvertToUserIdRequest request) {
        String url = WeComApiPaths.USER_CONVERT_TO_USER_ID;
        return post(url, request, UserConvertToUserIdResponse.class);
    }

    @Override
    public WeComResponseEntity userAuthSucc(@Nonnull String userId) {
        String url = urlTransfer(WeComApiPaths.USER_AUTH_SUCC, userId);
        return get(url, WeComResponseEntity.class);
    }

    @Override
    public BatchInviteResponse batchInvite(BatchInviteRequest request) {
        String url = WeComApiPaths.BATCH_INVITE;
        return post(url, request, BatchInviteResponse.class);
    }

    @Override
    public CorpGetJoinQrCodeResponse corpGetJoinQrCode(Integer sizeType) {
        String url = urlTransfer(WeComApiPaths.CORP_GET_JOIN_QRCODE, sizeType!=null?sizeType.toString():"");
        return get(url, CorpGetJoinQrCodeResponse.class);
    }

    @Override
    public UserGetUserIdResponse userGetUserId(UserGetUserIdRequest request) {
        String url = WeComApiPaths.USER_GET_USER_ID;
        return post(url, request, UserGetUserIdResponse.class);
    }

    @Override
    public UserGetUserIdByEmailResponse userGetUserIdByEmail(UserGetUserIdByEmailRequest request) {
        String url = WeComApiPaths.USER_GET_USER_ID_BY_EMAIL;
        return post(url, request, UserGetUserIdByEmailResponse.class);
    }

    @Override
    public UserListIdResponse userListId(UserListIdRequest request) {
        String url = WeComApiPaths.USER_LIST_ID;
        return post(url, request, UserListIdResponse.class);
    }
}
