package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.core.constant.WeChatLang;
import org.kangspace.wechat.helper.mp.bean.*;

import javax.annotation.Nonnull;

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

    /**
     * 用户管理-设置用户备注名 <br>
     * 开发者可以通过该接口对指定用户设置备注名，该接口暂时开放给微信认证的服务号。 <br>
     * <pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/Configuring_user_notes.html">https://developers.weixin.qq.com/doc/offiaccount/User_Management/Configuring_user_notes.html</a>
     * </pre>
     *
     * @param request {@link UserInfoUpdateRemarkRequest}
     * @return {@link WeChatMpResponseEntity}
     */
    WeChatMpResponseEntity userInfoUpdateRemark(UserInfoUpdateRemarkRequest request);

    /**
     * 用户管理-获取用户基本信息(UnionID机制) <br>
     * <pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/Get_users_basic_information_UnionID.html#UinonId">https://developers.weixin.qq.com/doc/offiaccount/User_Management/Get_users_basic_information_UnionID.html#UinonId</a>
     * </pre>
     *
     * @param openId 用户openId
     * @return {@link WeChatMpResponseEntity}
     */
    default UserInfoResponse userInfo(@Nonnull String openId){
        return this.userInfo(openId, WeChatLang.ZH_CN);
    }

    /**
     * 用户管理-获取用户基本信息(UnionID机制) <br>
     * <pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/Get_users_basic_information_UnionID.html#UinonId">https://developers.weixin.qq.com/doc/offiaccount/User_Management/Get_users_basic_information_UnionID.html#UinonId</a>
     * </pre>
     *
     * @param openId 用户openId
     * @param lang {@link WeChatLang} 国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为zh-CN
     * @return {@link WeChatMpResponseEntity}
     */
    UserInfoResponse userInfo(@Nonnull String openId, WeChatLang lang);

    /**
     * 用户管理-批量获取用户基本信息 <br>
     * 开发者可通过该接口来批量获取用户基本信息。最多支持一次拉取100条。<br>
     * <pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/Get_users_basic_information_UnionID.html#UinonId">https://developers.weixin.qq.com/doc/offiaccount/User_Management/Get_users_basic_information_UnionID.html#UinonId</a>
     * </pre>
     *
     * @param request {@link UserInfoBatchGetRequest}
     * @return {@link UserInfoBatchGetResponse}
     */
    UserInfoBatchGetResponse userInfoBatchGet(UserInfoBatchGetRequest request);
}
