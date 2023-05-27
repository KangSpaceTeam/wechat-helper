package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.mp.bean.*;

import javax.annotation.Nonnull;

/**
 * 微信公众号"账号管理"相关Service <br>
 * 1. 生成带参数的二维码 <br>
 * 一个公众号，最多可以创建100个标签。 <br>
 * 2. 短key托管 <br>
 * 短key托管类似于短链API，开发者可以通过GenShorten将不超过4KB的长信息转成短key，再通过FetchShorten将短key还原为长信息。<br>
 * 3. 微信认证事件推送 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Account_Management/Generating_a_Parametric_QR_Code.html">https://developers.weixin.qq.com/doc/offiaccount/Account_Management/Generating_a_Parametric_QR_Code.html</a><br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/05/25
 */
public interface AccountManagementService extends WeChatMpService {
    /**
     * 账号管理-生成带参数的二维码 <br>
     * 目前有2种类型的二维码： <br>
     * 1、临时二维码，是有过期时间的，最长可以设置为在二维码生成后的30天（即2592000秒）后过期，但能够生成较多数量。临时二维码主要用于帐号绑定等不要求二维码永久保存的业务场景  <br>
     * 2、永久二维码，是无过期时间的，但数量较少（目前为最多10万个）。永久二维码主要用于适用于帐号绑定、用户来源统计等场景。 <br>
     * 用户扫描带场景值二维码时，可能推送以下两种事件： <br>
     * 如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。 <br>
     * 如果用户已经关注公众号，在用户扫描后会自动进入会话，微信也会将带场景值扫描事件推送给开发者。 <br>
     * 获取带参数的二维码的过程包括两步，首先创建二维码ticket，然后凭借ticket到指定URL换取二维码。 <br>
     * <br>
     * 创建二维码ticket<br>
     * 每次创建二维码ticket需要提供一个开发者自行设定的参数（scene_id）。<br>
     *
     * @param request {@link QrcodeCreateRequest}
     * @return {@link QrcodeCreateResponse}
     */
    QrcodeCreateResponse qrcodeCreate(@Nonnull QrcodeCreateRequest request);

    /**
     * 账号管理-通过ticket换取二维码 <br>
     * <p>
     * 获取二维码ticket后，开发者可用ticket换取二维码图片。请注意，本接口无须登录态即可调用。<br>
     *
     * @param ticket {@link #qrcodeCreate(QrcodeCreateRequest)}中获取的ticekt
     * @return {@link MediaGetResponse#getMedia()}
     */
    MediaGetResponse showQrcode(@Nonnull String ticket);

    /**
     * 账号管理-短key托管-生成短key
     *
     * @param request {@link ShortenGenRequest}
     * @return {@link ShortenGenResponse}
     */
    ShortenGenResponse shortenGen(@Nonnull ShortenGenRequest request);

    /**
     * 账号管理-短key托管-还原长信息
     *
     * @param request {@link ShortenGenRequest}
     * @return {@link ShortenFetchResponse}
     */
    ShortenFetchResponse shortenFetch(@Nonnull ShortenFetchRequest request);


}
