package org.kangspace.wechat.helper.core.resolver;

/**
 * Property处理器
 * @author kango2gler@gmail.com
 * @date 2022/9/29
 */
public interface PropertyResolver {
    /**
     * 是否包含属性
     * @param key key
     * @return boolean
     */
    boolean containsProperty(String key);

    /**
     * 获取属性值
     * @param key key
     * @return 属性值
     */
    String getProperty(String key);

    /**
     * 获取属性值
     * @param key key
     * @param defaultValue key不存在时的默认值
     * @return 属性值
     */
    String getProperty(String key, String defaultValue);

    /**
     * 获取属性值
     * @param key key
     * @param targetType 值类型
     * @return T 属性值
     * @param <T>
     */
    <T> T getProperty(String key, Class<T> targetType);

    /**
     * 获取属性值
     * @param key key
     * @param targetType 值类型
     * @param defaultValue key不存在时的默认值
     * @return T 属性值
     * @param <T>
     */
    <T> T getProperty(String key, Class<T> targetType, T defaultValue);

    /**
     * 获取必须的属性值
     * @param key key
     * @return 属性值
     * @throws IllegalStateException
     */
    String getRequiredProperty(String key) throws IllegalStateException;

    /**
     * 获取必须的属性值
     * @param key key
     * @param targetType 值类型
     * @return T 属性值
     * @param <T>
     * @throws IllegalStateException
     */
    <T> T getRequiredProperty(String key, Class<T> targetType) throws IllegalStateException;
}
