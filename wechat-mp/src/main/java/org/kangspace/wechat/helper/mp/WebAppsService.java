package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.core.constant.WeChatLang;
import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.constant.WebAppConstant;

import javax.annotation.Nonnull;

/**
 * <p>
 * 微信公众号"网页开发"相关Service
 * </p>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/iOS_WKWebview.html">https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/iOS_WKWebview.html</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/11 17:18:54
 */
public interface WebAppsService extends WeChatMpService {

    /**
     * 生成网页授权地址<br>
     * 用户同意授权后:  <br>
     * 1. 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE。 <br>
     * code说明： <br>
     * 1. code作为换取access_token的票据，每次用户授权带上的 code 将不一样，code只能使用一次，5分钟未被使用自动过期。<br>
     *
     * @param appId       应用ID
     * @param redirectUrl 授权后的重定向地址
     * @param scope       应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo （弹出授权页面，可通过 openid 拿到昵称、性别、所在地。并且， 即使在未关注的情况下，只要用户授权，也能获取其信息 ） {@link WebAppConstant.Scope}
     * @param state       重定向后会带上 state 参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
     * @param forcePopup  强制此次授权需要用户弹窗确认；默认为false；需要注意的是，若用户命中了特殊场景下的静默授权逻辑，则此参数不生效
     * @return 网页授权地址
     */
    String authorizeUrl(@Nonnull String appId, @Nonnull String redirectUrl, @Nonnull WebAppConstant.Scope scope, String state, boolean forcePopup);

    /**
     * 生成网页授权地址<br>
     * 用户同意授权后:  <br>
     * 1. 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE。 <br>
     * code说明： <br>
     * 1. code作为换取access_token的票据，每次用户授权带上的 code 将不一样，code只能使用一次，5分钟未被使用自动过期。<br>
     *
     * @param appId       公众号的唯一标识
     * @param redirectUrl 授权后的重定向地址
     * @param scope       应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo （弹出授权页面，可通过 openid 拿到昵称、性别、所在地。并且， 即使在未关注的情况下，只要用户授权，也能获取其信息 ） {@link WebAppConstant.Scope}
     * @param state       重定向后会带上 state 参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
     * @return 网页授权地址
     */
    default String authorizeUrl(@Nonnull String appId, @Nonnull String redirectUrl, @Nonnull WebAppConstant.Scope scope, String state) {
        return this.authorizeUrl(appId, redirectUrl, scope, state, false);
    }

    /**
     * 通过 code 换取网页授权access_token
     *
     * @param appId  公众号的唯一标识
     * @param secret 公众号的appsecret
     * @param code   填写第一步获取的 code 参数 {@link #authorizeUrl(String, String, WebAppConstant.Scope, String)}
     * @return {@link WebAppsAccessTokenResponse}
     */
    WebAppsAccessTokenResponse accessToken(String appId, String secret, String code);

    /**
     * 刷新access_token<br>
     * 由于access_token拥有较短的有效期，当access_token超时后，可以使用refresh_token进行刷新，refresh_token有效期为30天，当refresh_token失效之后，需要用户重新授权<br>
     *
     * @param appId        公众号的唯一标识
     * @param refreshToken 填写通过access_token获取到的refresh_token参数
     * @return {@link WebAppsRefreshTokenResponse}
     */
    WebAppsRefreshTokenResponse refreshToken(String appId, String refreshToken);

    /**
     * 检验授权凭证（access_token）是否有效
     *
     * @param accessToken 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     * @param openId      用户的唯一标识
     * @return {@link WeChatMpResponseEntity}
     */
    WeChatMpResponseEntity auth(String accessToken, String openId);

    /**
     * 拉取用户信息(需 scope 为 snsapi_userinfo)<br>
     * 如果网页授权作用域为snsapi_userinfo，则此时开发者可以通过access_token和 openid 拉取用户信息了。<br>
     *
     * @param accessToken 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     * @param openId      用户的唯一标识
     * @param lang        返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return {@link WebAppsUserInfoResponse}
     */
    WebAppsUserInfoResponse userInfo(String accessToken, String openId, WeChatLang lang);

    /**
     * 拉取用户信息(需 scope 为 snsapi_userinfo,Lang为zh_CN)<br>
     * 如果网页授权作用域为snsapi_userinfo，则此时开发者可以通过access_token和 openid 拉取用户信息了。<br>
     *
     * @param accessToken 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     * @param openId      用户的唯一标识
     * @return {@link WebAppsUserInfoResponse}
     */
    default WebAppsUserInfoResponse userInfo(String accessToken, String openId){
        return userInfo(accessToken, openId, WeChatLang.ZH_CN);
    }

    /**
     * 获得jsapi_ticket <br>
     * 有效期7200秒，开发者必须在自己的服务全局缓存jsapi_ticket） <br>
     *
     * @return {@link WebAppsJsApiTicketResponse}
     */
    WebAppsJsApiTicketResponse jsApiTicket();

    /**
     * jsApi签名<br>
     * 签名生成规则如下：参与签名的字段包括noncestr（随机字符串）, 有效的jsapi_ticket, timestamp（时间戳）, url（当前网页的URL，不包含#及其后面部分） 。对所有待签名参数按照字段名的ASCII 码从小到大排序（字典序）后，使用 URL 键值对的格式（即key1=value1&key2=value2…）拼接成字符串string1。这里需要注意的是所有参数名均为小写字符。对string1作sha1加密，字段名和字段值都采用原始值，不进行URL 转义。
     * 即signature=sha1(string1)。 <br>
     * 注意事项: <br>
     * 1. 签名用的 noncestr 和timestamp必须与 wx.config 中的 nonceStr 和timestamp相同。<br>
     * 2. 签名用的 url 必须是调用 JS 接口页面的完整URL。 <br>
     * 3. 出于安全考虑，开发者必须在服务器端实现签名的逻辑。<br>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/JS-SDK.html#62">https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/JS-SDK.html#62</a>
     * @param jsApiTicket jsApiTicket
     * @param url 当前网页的URL，不包含#及其后面部分
     * @param nonceStr 随机字符串
     * @param timestamp 时间戳
     * @return js签名 {@link WebAppsJsApiSignResponse}
     */
    WebAppsJsApiSignResponse jsApiSign(String jsApiTicket, String url, String nonceStr, String timestamp);
}
