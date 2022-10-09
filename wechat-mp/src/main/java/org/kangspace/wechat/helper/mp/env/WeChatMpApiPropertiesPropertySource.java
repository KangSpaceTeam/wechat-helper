package org.kangspace.wechat.helper.mp.env;

import org.kangspace.wechat.helper.core.env.ApiPropertiesPropertySource;

/**
 * 微信公众号API接口解析器
 * @author kango2gler@gmail.com
 * @since 2022/10/1
 */
public class WeChatMpApiPropertiesPropertySource extends ApiPropertiesPropertySource {
    /**
     * 微信公众号API配置文件名
     */
    private static String propertyFileName = "wechat-mp-api.properties";

    public WeChatMpApiPropertiesPropertySource() {
        super(propertyFileName);
    }

    @Override
    public String getApiBasePath() {
        // TODO;
        return null;
    }
}
