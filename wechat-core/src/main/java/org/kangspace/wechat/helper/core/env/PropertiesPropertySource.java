package org.kangspace.wechat.helper.core.env;

import org.kangspace.wechat.helper.core.util.PropertiesLoader;

import java.util.Properties;

/**
 * Properties配置源
 *
 * @author kango2gler@gmail.com
 * @date 2022/9/29
 */
public class PropertiesPropertySource extends PropertySource<Properties> {

    public PropertiesPropertySource(String fileName) {
        this(fileName, PropertiesLoader.load(fileName));
    }

    public PropertiesPropertySource(String name, Properties source) {
        super(name, source);
    }

    @Override
    public Object getProperty(String key) {
        return this.getSource().get(key);
    }

    @Override
    public String getProperty(String key, String defaultVal) {
        return this.getSource().getProperty(key, defaultVal);
    }

}
