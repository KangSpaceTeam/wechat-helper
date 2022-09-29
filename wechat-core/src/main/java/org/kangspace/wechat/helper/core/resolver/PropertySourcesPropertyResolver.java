package org.kangspace.wechat.helper.core.resolver;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.env.PropertySource;
import org.kangspace.wechat.helper.core.env.PropertySources;

/**
 * Properties配置文件解析类
 *
 * @author kango2gler@gmail.com
 * @date 2022/9/29
 */
@Slf4j
@Getter
public class PropertySourcesPropertyResolver extends AbstractPropertyResolver {
    private PropertySources propertySources;

    public PropertySourcesPropertyResolver(PropertySources propertySources) {
        this.propertySources = propertySources;
    }

    @Override
    public String getProperty(String key) {
        return getProperty(key, String.class, null);
    }

    @Override
    public String getProperty(String key, String defaultValue) {
        return getProperty(key, String.class, defaultValue);
    }

    @Override
    public <T> T getProperty(String key, Class<T> targetType) {
        return getProperty(key, targetType, null);
    }

    @Override
    public <T> T getProperty(String key, Class<T> targetType, T defaultValue) {
        if (hasPropertySources()) {
            PropertySource<?> propertySource = this.propertySources.stream().filter(t -> t.contain(key)).findFirst().orElse(null);
            if (propertySource != null) {
                if (String.class.equals(targetType)) {
                    return (T) propertySource.getProperty(key, (String) defaultValue);
                }
                Object val = propertySource.getProperty(key);
                return val != null ? (T) val : defaultValue;
            }
        }
        log.trace("Property:{} not found", key);
        return null;
    }

    private boolean hasPropertySources() {
        return propertySources != null;
    }
}
