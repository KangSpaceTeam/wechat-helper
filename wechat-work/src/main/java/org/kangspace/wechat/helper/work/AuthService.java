package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.work.bean.*;

import javax.annotation.Nonnull;

/**
 * 企业微信"身份验证"相关 Service <br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/91022">https://developer.work.weixin.qq.com/document/path/91022</a> <br>
 * @author kango2gler@gmail.com
 * @since 2023/07/30
 */
public interface AuthService extends WeComService {

    /**
     * 身份验证-网页授权登录
     * @param appId CORPID, 企业的CorpID
     * @param redirectUri 授权后重定向的回调链接地址，请使用urlencode对链接进行处理
     * @param scope 应用授权作用域 {@link org.kangspace.wechat.helper.work.constant.Scope}
     * @param state 重定向后会带上state参数，企业可以填写a-zA-Z0-9的参数值，长度不可超过128个字节
     * @param agentId 应用agentid，建议填上该参数（对于第三方应用和代开发自建应用，在填写该参数的情况下或者在工作台、聊天工具栏、应用会话内发起oauth2请求的场景中，会触发接口许可的自动激活）。snsapi_privateinfo时必填否则报错；
     * @return 网页授权登录连接
     */
    String connectOAuth2Authorize(@Nonnull String appId,@Nonnull String redirectUri,@Nonnull String scope, String state,@Nonnull String agentId);

    /**
     * 身份验证-获取访问用户身份
     * @param code 通过成员授权获取到的code，最大为512字节。每次成员授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。
     * @return {@link AuthGetUserInfoResponse}
     */
    AuthGetUserInfoResponse authGetUserInfo(@Nonnull String code);

    /**
     * 身份验证-获取访问用户敏感信息
     * @param request {@link AuthGetUserDetailRequest}
     * @return {@link AuthGetUserDetailResponse}
     */
    AuthGetUserDetailResponse authGetUserDetail(AuthGetUserDetailRequest request);
}
