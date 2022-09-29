package org.kangspace.wechat.helper.core.env;

import lombok.Getter;

/**
 * 配置源抽象类
 *
 * @author kango2gler@gmail.com
 * @date 2022/9/29
 */
@Getter
public abstract class PropertySource<T> {
    /**
     * 配置源名称
     */
    private String name;
    /**
     * 配置来源,如properties,yaml
     */
    private T source;

    public PropertySource(String name, T source) {
        this.name = name;
        this.source = source;
    }

    /**
     * 获取配置值
     * @param key 配置项
     * @return Object
     */
    public String getPropertyString(String key){
        return getProperty(key,null);
    }
    /**
     * 获取配置值
     * @param key 配置项
     * @return Object
     */
    public abstract Object getProperty(String key);

    /**
     * 获取配置值,配置不存在时返回默认值
     * @param key 配置项
     * @param defaultVal 默认值
     * @return Object
     */
    public abstract String getProperty(String key,String defaultVal);

    /**
     * 配置是否存在
     * @param key 配置项
     * @return boolean
     */
    public boolean contain(String key) {
        return getProperty(key) != null;
    }

}
