package org.kangspace.wechat.helper.work.env;

import org.kangspace.wechat.helper.core.env.ApiPropertiesPropertySource;
import org.kangspace.wechat.helper.work.constant.WeComApiPathMapping;

import java.util.Properties;

/**
 * 企业微信API接口解析器
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/1
 */
public class WeComApiPropertiesPropertySource extends ApiPropertiesPropertySource {
    /**
     * 企业微信API配置文件名
     */
    private static String propertyFileName = "wecom-api.properties";

    public WeComApiPropertiesPropertySource() {
        super(propertyFileName);
    }

    public WeComApiPropertiesPropertySource(String name, Properties source) {
        super(name, source);
    }

    @Override
    public String getApiBasePath() {
        return this.getSource().getProperty(WeComApiPathMapping.API_BASE_PATH.getPathName());
    }
}
