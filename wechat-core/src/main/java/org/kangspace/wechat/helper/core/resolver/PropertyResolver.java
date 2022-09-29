package org.kangspace.wechat.helper.core.resolver;

/**
 * Property处理器
 * @author kango2gler@gmail.com
 * @date 2022/9/29
 */
public interface PropertyResolver {
    boolean containsProperty(String key);

    String getProperty(String key);

    String getProperty(String key, String defaultValue);

    <T> T getProperty(String key, Class<T> targetType);

    <T> T getProperty(String key, Class<T> targetType, T defaultValue);

    String getRequiredProperty(String key) throws IllegalStateException;

    <T> T getRequiredProperty(String key, Class<T> targetType) throws IllegalStateException;
}
