package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.mp.bean.WeChatMpServerIpListResponse;

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
     * @return {@link WeChatMpServerIpListResponse}
     */
    WeChatMpServerIpListResponse getApiDomainIp();

    /**
     * 获取微信callback IP地址
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_the_WeChat_server_IP_address.html">https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_the_WeChat_server_IP_address.html</a>
     * </p>
     *
     * @return {@link WeChatMpServerIpListResponse}
     */
    WeChatMpServerIpListResponse getCallbackIp();
}
