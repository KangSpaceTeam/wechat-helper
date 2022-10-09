package org.kangspace.wechat.helper.work.env;

import org.kangspace.wechat.helper.core.env.ApiEnumPropertySource;
import org.kangspace.wechat.helper.core.env.ApiPropertiesPropertySource;
import org.kangspace.wechat.helper.core.env.EnumPropertySource;
import org.kangspace.wechat.helper.work.constant.WeComApiPathMapping;

/**
 * 基于Api枚举的数据源
 * @author kango2gler@gmail.com
 * @since 2022/10/2
 */
public class WeComApiEnumPropertySource extends ApiEnumPropertySource<WeComApiPathMapping> {
    private static final String NAME = "weComApiEnumPropertySource";

    public WeComApiEnumPropertySource() {
        super(NAME, WeComApiPathMapping.class);
    }

    @Override
    public String getProperty(String key) {
        return getProperty(key, null);
    }

    @Override
    public String getProperty(String key, String defaultVal) {
        WeComApiPathMapping mapping;
        return (mapping = WeComApiPathMapping.parse(key)) != null ? mapping.getValue() : defaultVal;
    }

    @Override
    public String getValue(WeComApiPathMapping e) {
        return e != null? e.getValue(): null;
    }
}
