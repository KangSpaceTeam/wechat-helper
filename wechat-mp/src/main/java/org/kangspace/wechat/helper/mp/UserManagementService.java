package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.mp.bean.*;

/**
 * 微信公众号"用户管理"相关Service <br>
 * 1. 标签管理 <br>
 * 一个公众号，最多可以创建100个标签。 <br>
 * 2. 用户管理 <br>
 * 标签功能目前支持公众号为用户打上最多20个标签。<br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html">https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html</a><br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/05/07
 */
public interface UserManagementService extends WeChatMpService {

    /**
     * 标签管理-创建标签 <br>
     * 一个公众号，最多可以创建100个标签。<br>
     * <pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html">https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html</a>
     * </pre>
     *
     * @param request {@link UserTagsUpdateRequest}
     * @return {@link UserTagsCreateResponse}
     */
    UserTagsCreateResponse tagsCreate(UserTagsUpdateRequest request);

    /**
     * 标签管理-获取公众号已创建的标签 <br>
     * <pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html">https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html</a>
     * </pre>
     *
     * @return {@link UserTagsGetResponse}
     */
    UserTagsGetResponse tagsGet();

    /**
     * 标签管理-编辑标签 <br>
     * <pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html">https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html</a>
     * </pre>
     *
     * @param request {@link UserTagsUpdateRequest}
     * @return {@link WeChatMpResponseEntity}
     */
    WeChatMpResponseEntity tagsUpdate(UserTagsUpdateRequest request);

    /**
     * 标签管理-删除标签 <br>
     * <pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html">https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html</a>
     * </pre>
     *
     * @param request {@link UserTagsUpdateRequest}
     * @return {@link WeChatMpResponseEntity}
     */
    WeChatMpResponseEntity tagsDelete(UserTagsUpdateRequest request);

    /**
     * 标签管理-获取标签下粉丝列表 <br>
     * <pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html">https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html</a>
     * </pre>
     *
     * @param request {@link UserTagGetRequest}
     * @return {@link UserTagGetResponse}
     */
    UserTagGetResponse userTagGet(UserTagGetRequest request);

    /**
     * 用户管理-批量为用户打标签 <br>
     * 标签功能目前支持公众号为用户打上最多20个标签。 <br>
     * <pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html">https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html</a>
     * </pre>
     *
     * @param request {@link UserTagsBatchTaggingRequest}
     * @return {@link WeChatMpResponseEntity}
     */
    WeChatMpResponseEntity tagsMembersBatchTagging(UserTagsBatchTaggingRequest request);

    /**
     * 用户管理-批量为用户取消标签 <br>
     * <pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html">https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html</a>
     * </pre>
     *
     * @param request {@link UserTagsBatchTaggingRequest}
     * @return {@link WeChatMpResponseEntity}
     */
    WeChatMpResponseEntity tagsMembersBatchUntagging(UserTagsBatchTaggingRequest request);

    /**
     * 用户管理-获取用户身上的标签列表 <br>
     * <pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html">https://developers.weixin.qq.com/doc/offiaccount/User_Management/User_Tag_Management.html</a>
     * </pre>
     *
     * @param request {@link UserTagsGetIdListRequest}
     * @return {@link UserTagsGetIdListResponse}
     */
    UserTagsGetIdListResponse tagsGetIdList(UserTagsGetIdListRequest request);
}
