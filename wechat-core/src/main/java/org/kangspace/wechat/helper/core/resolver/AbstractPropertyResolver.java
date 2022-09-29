package org.kangspace.wechat.helper.core.resolver;

/**
 * Property处理器抽象实现
 * @author kango2gler@gmail.com
 * @date 2022/9/29
 */
public abstract class AbstractPropertyResolver implements PropertyResolver{

    @Override
    public boolean containsProperty(String key) {
        return this.getProperty(key) != null;
    }

    @Override
    public String getRequiredProperty(String key) throws IllegalStateException {
        String value = this.getProperty(key);
        if (value == null) {
            throw new IllegalStateException("Required key '" + key + "' not found");
        }
        return value;
    }

    @Override
    public <T> T getRequiredProperty(String key, Class<T> targetType) throws IllegalStateException {
        T value = this.getProperty(key, targetType);
        if (value == null) {
            throw new IllegalStateException("Required key '" + key + "' not found");
        }
        return value;
    }
}
