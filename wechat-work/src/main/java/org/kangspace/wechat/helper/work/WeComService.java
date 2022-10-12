package org.kangspace.wechat.helper.work;

import lombok.Getter;
import org.kangspace.wechat.helper.core.WeChatService;
import org.kangspace.wechat.helper.core.env.MultiPropertySources;
import org.kangspace.wechat.helper.core.env.PropertySource;
import org.kangspace.wechat.helper.core.request.WeChatHttpClient;
import org.kangspace.wechat.helper.core.resolver.PropertyResolver;
import org.kangspace.wechat.helper.core.resolver.PropertySourcesPropertyResolver;
import org.kangspace.wechat.helper.work.constant.WeComConfig;
import org.kangspace.wechat.helper.work.env.WeComApiEnumPropertySource;
import org.kangspace.wechat.helper.work.env.WeComApiPropertiesPropertySource;

import java.util.Objects;
import java.util.Properties;

/**
 * 企业微信Service
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/3
 */
@Getter
public class WeComService implements WeChatService {
    private WeComConfig weComConfig;
    private PropertyResolver apiPropertyResolver;

    public WeComService(WeComConfig weComConfig) {
        Objects.requireNonNull(weComConfig, "weComConfig must be not null!");
        this.weComConfig = weComConfig;
        this.apiPropertyResolver = initApiPropertyResolver(weComConfig);
    }

    /**
     * 初始化配置处理器
     *
     * @param weComConfig
     * @return
     */
    private PropertyResolver initApiPropertyResolver(WeComConfig weComConfig) {
        MultiPropertySources multiPropertySources = new MultiPropertySources(new WeComApiEnumPropertySource());
        PropertySource customApiProperties = initCustomApiProperties(weComConfig);
        if (customApiProperties != null) {
            multiPropertySources.add(customApiProperties);
        }
        return new PropertySourcesPropertyResolver(multiPropertySources);
    }

    /**
     * 初始化自定义api 配置
     *
     * @param weComConfig {@link WeComConfig}
     * @return {@link  PropertySource}
     */
    private PropertySource initCustomApiProperties(WeComConfig weComConfig) {
        if (weComConfig.getApiPathMapping() == null || weComConfig.getApiPathMapping().size() < 1) {
            return null;
        }
        Properties apiProperties = new Properties();
        apiProperties.putAll(weComConfig.getApiPathMapping());
        return new WeComApiPropertiesPropertySource("customApiProperties", apiProperties);
    }


    @Override
    public WeChatHttpClient getWeChatRequestClient() {
        return null;
    }
}
