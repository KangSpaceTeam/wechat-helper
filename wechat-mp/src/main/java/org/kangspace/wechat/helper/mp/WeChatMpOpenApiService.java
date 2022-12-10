package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.mp.bean.OpenApiQuotaGetResponse;
import org.kangspace.wechat.helper.mp.bean.OpenApiRidGetResponse;
import org.kangspace.wechat.helper.mp.bean.WeChatMpResponseEntity;

/**
 * 微信公众号"openApi管理"相关Service
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/4
 */
public interface WeChatMpOpenApiService extends WeChatMpService {

    /**
     * 清空 api 的调用quota <br>
     * 本接口用于清空公众号/小程序/第三方平台等接口的每日调用接口次数。<br>
     * <pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/openApi/clear_quota.html">https://developers.weixin.qq.com/doc/offiaccount/openApi/clear_quota.html</a>
     * 注意事项:
     * 1、如果要清空公众号的接口的quota，则需要用公众号的access_token；如果要清空小程序的接口的quota，则需要用小程序的access_token；如果要清空第三方平台的接口的quota，则需要用第三方平台的component_access_token
     * 2、如果是第三方服务商代公众号或者小程序清除quota，则需要用authorizer_access_token
     * 3、每个帐号每月共10次清零操作机会，清零生效一次即用掉一次机会；第三方帮助公众号/小程序调用时，实际上是在消耗公众号/小程序自身的quota
     * 4、由于指标计算方法或统计时间差异，实时调用量数据可能会出现误差，一般在1%以内
     * </pre>
     *
     * @param accessToken 依据需要查询的接口属于的账号类型不同而使用不同的token，详情查看注上述注意事项
     * @param appId       要被清空的账号的appid
     * @return {@link WeChatMpResponseEntity}
     */
    WeChatMpResponseEntity clearQuota(String accessToken, String appId);

    /**
     * 查询 openAPI 调用quota <br>
     * 本接口用于查询公众号/小程序/第三方平台等接口的每日调用接口的额度以及调用次数。<br>
     *
     * <pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/openApi/get_api_quota.html">https://developers.weixin.qq.com/doc/offiaccount/openApi/get_api_quota.html</a> <br>
     * 注意事项
     * 1、如果查询的 api 属于公众号的接口，则需要用公众号的access_token；如果查询的 api 属于小程序的接口，则需要用小程序的access_token；如果查询的接口属于第三方平台的接口，则需要用第三方平台的component_access_token；否则会出现76022报错。
     * 2、如果是第三方服务商代公众号或者小程序查询公众号或者小程序的api，则需要用authorizer_access_token
     * 3、每个接口都有调用次数限制，请开发者合理调用接口
     * 4、”/xxx/sns/xxx“这类接口不支持使用该接口，会出现76022报错。
     * </pre>
     *
     * @param accessToken 依据需要查询的接口属于的账号类型不同而使用不同的token，详情查看注上述注意事项
     * @param cgiPath     api的请求地址，例如"/cgi-bin/message/custom/send";不要前缀"https://api.weixin.qq.com" ，也不要漏了"/",否则都会76003的报错
     * @return {@link OpenApiQuotaGetResponse}
     */
    OpenApiQuotaGetResponse quotaGet(String accessToken, String cgiPath);

    /**
     * 查询rid信息 <br>
     * 本接口用于查询调用公众号/小程序/第三方平台等接口报错返回的 rid 详情信息，辅助开发者高效定位问题。<br>
     *
     * <pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/openApi/get_rid_info.html">https://developers.weixin.qq.com/doc/offiaccount/openApi/get_rid_info.html</a> <br>
     * 注意事项
     * 1、由于查询 rid 信息属于开发者私密行为，因此仅支持同账号的查询。举个例子，rid=1111，是小程序账号 A 调用某接口出现的报错，那么则需要使用小程序账号 A 的access_token调用当前接口查询rid=1111的详情信息，如果使用小程序账号 B 的身份查询，则出现报错，错误码为xxx。公众号、第三方平台账号的接口同理。
     * 2、如果是第三方服务商代公众号或者小程序查询公众号或者小程序的 api 返回的rid，则使用同一账号的authorizer_access_token调用即可
     * 3、rid的有效期只有7天，即只可查询最近7天的rid，查询超过7天的 rid 会出现报错，错误码为76001
     * </pre>
     *
     * @param accessToken 依据需要查询的接口属于的账号类型不同而使用不同的token，详情查看注上述注意事项
     * @param rid         调用接口报错返回的rid
     * @return {@link OpenApiQuotaGetResponse}
     */
    OpenApiRidGetResponse ridGet(String accessToken, String rid);
}
