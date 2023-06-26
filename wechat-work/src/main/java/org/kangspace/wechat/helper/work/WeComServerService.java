package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.work.bean.ServerIpListResponse;

/**
 * 企业微信服务相关 Service
 *
 * @author kango2gler@gmail.com
 * @since 2023/06/26
 */
public interface WeComServerService extends WeComService {
    /**
     * 获取企业微信 API 接口 IP地址
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/92520">https://developer.work.weixin.qq.com/document/path/92520</a>
     * </p>
     *
     * @return {@link ServerIpListResponse}
     */
    ServerIpListResponse getApiDomainIp();

    /**
     * 获取企业微信callback IP地址
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/92521">https://developer.work.weixin.qq.com/document/path/92521</a>
     * </p>
     *
     * @return {@link ServerIpListResponse}
     */
    ServerIpListResponse getCallbackIp();
}
