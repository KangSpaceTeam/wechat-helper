package org.kangspace.wechat.helper.core.util;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Gson工具类
 * // TODO 切换为jackson
 *
 * @author kango2gler@gmail.com
 * @since 2022/9/29
 */
public class JsonUtil {



    /**
     * 对象转换为Json字符串
     *
     * @param jsonObj 对象
     * @return Json字符串
     */
    public static String toJsonString(Object jsonObj) {
        return JacksonUtil.toJsonString(jsonObj);
    }


    /**
     * JSON字符串转换为对象
     *
     * @param jsonString JSON字符串
     * @param targetClass 目标类型
     * @return T
     */
    public static <T> T parse(String jsonString, Class<T> targetClass) {
        return JacksonUtil.parse(jsonString, targetClass);
    }

    /**
     * JSON字符串转换为对象
     *
     * @param jsonString JSON字符串
     * @param typeReference 目标类型
     * @return T
     */
    public static <T> T parse(String jsonString, TypeReference<T> typeReference) {
        return JacksonUtil.parse(jsonString, typeReference);
    }
}
