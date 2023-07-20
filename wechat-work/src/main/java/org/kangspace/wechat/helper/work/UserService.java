package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.work.bean.*;

import javax.annotation.Nonnull;

/**
 * 企业微信"通讯录管理-成员管理"相关 Service
 *
 * @author kango2gler@gmail.com
 * @since 2023/07/17
 */
public interface UserService extends WeComService {


    /**
     * 读取成员
     *
     * @param userId 成员UserID。对应管理端的帐号，企业内必须唯一。不区分大小写，长度为1~64个字节
     * @return {@link UserResponse}
     */
    UserResponse userGet(@Nonnull String userId);

    /**
     * 创建成员
     *
     * @param request {@link UserRequest}
     * @return {@link WeComResponseEntity}
     */
    WeComResponseEntity userCreate(UserRequest request);

    /**
     * 更新成员
     *
     * @param request {@link UserRequest}
     * @return {@link WeComResponseEntity}
     */
    WeComResponseEntity userUpdate(UserRequest request);

    /**
     * 删除成员
     *
     * @param userId 成员UserID。对应管理端的帐号，企业内必须唯一。不区分大小写，长度为1~64个字节
     * @return {@link WeComResponseEntity}
     */
    WeComResponseEntity userDelete(String userId);

    /**
     * 批量删除成员
     *
     * @param request {@link UserBatchDeleteRequest}
     * @return {@link WeComResponseEntity}
     */
    WeComResponseEntity userBatchDelete(UserBatchDeleteRequest request);

    /**
     * 获取部门成员<br>
     * 【重要】从2022年8月15日10点开始，“企业管理后台 - 管理工具 - 通讯录同步”的新增IP将不能再调用此接口，企业可通过「获取成员ID列表」和「获取部门ID列表」接口获取userid和部门ID列表。查看调整详情。<br>
     *
     * @param departmentId 获取的部门id
     * @return {@link UserSimpleListResponse}
     */
    UserSimpleListResponse userSimpleList(@Nonnull Long departmentId);

    /**
     * 获取部门成员详情<br>
     * 从2022年6月20号20点开始，除通讯录同步以外的基础应用（如客户联系、微信客服、会话存档、日程等），以及新创建的自建应用与代开发应用，调用该接口时，不再返回以下字段：头像、性别、手机、邮箱、企业邮箱、员工个人二维码、地址，应用需要通过oauth2手工授权的方式获取管理员与员工本人授权的字段。<br>
     * 【重要】从2022年8月15日10点开始，“企业管理后台 - 管理工具 - 通讯录同步”的新增IP将不能再调用此接口，企业可通过「获取成员ID列表」和「获取部门ID列表」接口获取userid和部门ID列表。查看调整详情。<br>
     *
     * @param departmentId 获取的部门id
     * @return {@link UserListResponse}
     */
    UserListResponse userList(@Nonnull Long departmentId);

    /**
     * userid与openid互换-userid转openid<br>
     *
     * @param request {@link UserConvertToOpenIdRequest}
     * @return {@link UserConvertToOpenIdResponse}
     */
    UserConvertToOpenIdResponse userConvertToOpenId(@Nonnull UserConvertToOpenIdRequest request);

    /**
     * userid与openid互换-openid转userid<br>
     *
     * @param request {@link UserConvertToUserIdRequest}
     * @return {@link UserConvertToUserIdResponse}
     */
    UserConvertToUserIdResponse userConvertToUserId(@Nonnull UserConvertToUserIdRequest request);

    /**
     * 二次验证<br>
     *
     * @param userId 成员UserID。对应管理端的帐号
     * @return {@link WeComResponseEntity}
     */
    WeComResponseEntity userAuthSucc(@Nonnull String userId);

    /**
     * 邀请成员<br>
     *
     * @param request {@link BatchInviteRequest}
     * @return {@link BatchInviteResponse}
     */
    BatchInviteResponse batchInvite(BatchInviteRequest request);

    /**
     * 获取加入企业二维码<br>
     *
     * @param sizeType qrcode尺寸类型，1: 171 x 171; 2: 399 x 399; 3: 741 x 741; 4: 2052 x 2052
     * @return {@link BatchInviteResponse}
     */
    CorpGetJoinQrCodeResponse corpGetJoinQrCode(Integer sizeType);

    /**
     * 手机号获取userid<br>
     *
     * @param request {@link UserGetUserIdRequest}
     * @return {@link UserGetUserIdResponse}
     */
    UserGetUserIdResponse userGetUserId(UserGetUserIdRequest request);

    /**
     * 邮箱获取userid<br>
     *
     * @param request {@link UserGetUserIdByEmailRequest}
     * @return {@link UserGetUserIdByEmailResponse}
     */
    UserGetUserIdByEmailResponse userGetUserIdByEmail(UserGetUserIdByEmailRequest request);

    /**
     * 获取成员ID列表<br>
     *
     * @param request {@link UserListIdRequest}
     * @return {@link UserListIdResponse}
     */
    UserListIdResponse userListId(UserListIdRequest request);
}
