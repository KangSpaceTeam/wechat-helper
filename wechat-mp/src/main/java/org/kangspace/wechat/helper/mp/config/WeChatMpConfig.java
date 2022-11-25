package org.kangspace.wechat.helper.mp.config;

import lombok.Data;
import lombok.ToString;
import org.kangspace.wechat.helper.core.config.AbstractWeChatConfig;

/**
 * 微信公众号配置类
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@Data
@ToString(callSuper = true)
public class WeChatMpConfig extends AbstractWeChatConfig {
    /**
     * appId
     */
    private String appId;
    /**
     * appSecret
     */
    private String appSecret;


    public WeChatMpConfig(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

    public WeChatMpConfig(String appId, String appSecret, RequestConfig requestConfig) {
        this.appId = appId;
        this.appSecret = appSecret;
    }
}
