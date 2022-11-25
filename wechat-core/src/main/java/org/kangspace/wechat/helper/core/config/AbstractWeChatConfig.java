package org.kangspace.wechat.helper.core.config;

/**
 * 微信配置抽象类
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public class AbstractWeChatConfig implements WeChatConfig {
    private RequestConfig requestConfig = new RequestConfig();

    public AbstractWeChatConfig() {
    }

    public AbstractWeChatConfig(RequestConfig requestConfig) {
        this.requestConfig = requestConfig;
    }

    @Override
    public RequestConfig requestConfig() {
        return requestConfig;
    }
}
