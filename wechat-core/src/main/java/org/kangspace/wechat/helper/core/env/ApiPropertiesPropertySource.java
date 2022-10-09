package org.kangspace.wechat.helper.core.env;

import org.kangspace.wechat.helper.core.util.PropertiesLoader;

import java.util.Properties;

/**
 * API Properties配置源
 * @author kango2gler@gmail.com
 * @date 2022/9/29
 */
public abstract class ApiPropertiesPropertySource extends PropertiesPropertySource {

    public ApiPropertiesPropertySource(String fileName) {
        this(fileName, PropertiesLoader.load(fileName));
    }

    public ApiPropertiesPropertySource(String name, Properties source) {
        super(name, source);
    }

    @Override
    public Object getProperty(String name) {
        return this.getSource().get(name);
    }

    @Override
    public String getProperty(String name, String defaultVal) {
        return this.getSource().getProperty(name, defaultVal);
    }

    /**
     * 获取API基础路径
     * @return API基础路径
     */
    public abstract String getApiBasePath();

}
