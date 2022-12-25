package org.kangspace.wechat.helper.core.util;

import org.kangspace.wechat.helper.core.exception.WeChatException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射工具类
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public class ReflectUtil {


    /**
     * 创建新实例
     *
     * @param instanceClass             需要实例化的类
     * @param singleConstructorArgClass 构造方法参数类型数组
     * @param constructorArg            构造方法参数
     * @return {@link T}
     */
    public static <T> T newInstance(Class<T> instanceClass, Class<?> singleConstructorArgClass, Object constructorArg) {
        return newInstance(instanceClass, new Class[]{singleConstructorArgClass}, constructorArg);
    }

    /**
     * 创建新实例
     *
     * @param instanceClass         需要实例化的类
     * @param constructorArgClasses 构造方法参数类型数组
     * @param constructorArgs       构造方法参数
     * @return {@link T}
     */
    public static <T> T newInstance(Class<T> instanceClass, Class<?>[] constructorArgClasses, Object... constructorArgs) {
        try {
            Constructor<T> instanceClassConstructor = instanceClass.getConstructor(constructorArgClasses);
            return instanceClassConstructor.newInstance(constructorArgs);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new WeChatException("实例创建失败: error: " + e.getMessage(), e);
        }
    }
}
