package org.kangspace.wechat.helper.core.env;

import java.util.Properties;

/**
 * 微信公共配置数据源
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/2
 */
public class WeChatPropertiesPropertySource extends PropertiesPropertySource {
    private static final String WECHAT_PROPERTY = "WECHAT_PROPERTY";
    /**
     * 加载排序
     */
    private static final Integer WECHAT_PROPERTY_ORDER = 0;

    public WeChatPropertiesPropertySource(Properties properties) {
        super(WECHAT_PROPERTY, properties);
    }

    @Override
    public void setOrder(Integer order) {
        super.setOrder(WECHAT_PROPERTY_ORDER);
    }
}
