package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.mp.bean.MpCallbackCheckParam;
import org.kangspace.wechat.helper.mp.bean.MpCallbackCheckResponse;
import org.kangspace.wechat.helper.mp.bean.MpServerIpListResponse;

/**
 * <p>
 * 微信公众号服务器相关Service
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public interface WeChatMpServerService extends WeChatMpService {

    /**
     * 获取微信 API 接口 IP地址
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_the_WeChat_server_IP_address.html">https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_the_WeChat_server_IP_address.html</a>
     * </p>
     *
     * @return {@link MpServerIpListResponse}
     */
    MpServerIpListResponse getApiDomainIp();

    /**
     * 获取微信callback IP地址
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_the_WeChat_server_IP_address.html">https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_the_WeChat_server_IP_address.html</a>
     * </p>
     *
     * @return {@link MpServerIpListResponse}
     */
    MpServerIpListResponse getCallbackIp();

    /**
     * 网络检测<br/>
     * 为了帮助开发者排查回调连接失败的问题，提供这个网络检测的API。它可以对开发者 URL 做域名解析，然后对所有 IP 进行一次 ping 操作，得到丢包率和耗时。
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Network_Detection.html">https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Network_Detection.html</a>
     * </p>
     *
     * @param param 请求参数 {@link MpCallbackCheckParam}
     * @return {@link MpCallbackCheckResponse}
     */
    MpCallbackCheckResponse callbackCheck(MpCallbackCheckParam param);
}
