package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.work.bean.UserBatchDeleteRequest;
import org.kangspace.wechat.helper.work.bean.UserRequest;
import org.kangspace.wechat.helper.work.bean.UserResponse;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;

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
    UserResponse userGet(String userId);

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
}
