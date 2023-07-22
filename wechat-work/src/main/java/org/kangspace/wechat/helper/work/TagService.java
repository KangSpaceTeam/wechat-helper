package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.work.bean.*;

import javax.annotation.Nonnull;

/**
 * 企业微信"通讯录管理-标签管理"相关 Service
 *
 * @author kango2gler@gmail.com
 * @since 2023/07/22
 */
public interface TagService extends WeComService {
    /**
     * 创建标签
     *
     * @param request {@link TagRequest}
     * @return {@link TagCreateResponse}
     */
    TagCreateResponse tagCreate(TagRequest request);

    /**
     * 更新标签名字
     *
     * @param request {@link TagUpdateRequest}
     * @return {@link WeComResponseEntity}
     */
    WeComResponseEntity tagUpdate(TagUpdateRequest request);

    /**
     * 删除标签
     *
     * @param tagId 标签ID
     * @return {@link WeComResponseEntity}
     */
    WeComResponseEntity tagDelete(@Nonnull Long tagId);

    /**
     * 获取标签成员
     *
     * @param tagId 标签ID
     * @return {@link TagUserResponse}
     */
    TagUserResponse tagGet(@Nonnull Long tagId);

    /**
     * 增加标签成员
     *
     * @param request {@link TagUpdateTagUsersRequest}
     * @return {@link TagUpdateTagUsersResponse}
     */
    TagUpdateTagUsersResponse tagAddTagUsers(@Nonnull TagUpdateTagUsersRequest request);

    /**
     * 删除标签成员
     *
     * @param request {@link TagUpdateTagUsersRequest}
     * @return {@link TagUpdateTagUsersResponse}
     */
    TagUpdateTagUsersResponse tagDelTagUsers(@Nonnull TagUpdateTagUsersRequest request);

    /**
     * 获取标签列表
     *
     * @return {@link TagListResponse}
     */
    TagListResponse tagList();
}
