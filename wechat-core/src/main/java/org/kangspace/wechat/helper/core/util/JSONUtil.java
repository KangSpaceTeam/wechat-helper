package org.kangspace.wechat.helper.core.util;

import com.google.gson.GsonBuilder;

/**
 * Gson工具类
 *
 * @author kango2gler@gmail.com
 * @since 2022/9/29
 */
public class JSONUtil {

    /**
     * 对象转换为Json字符串
     *
     * @param jsonObj 对象
     * @return Json字符串
     */
    public static String toJsonString(Object jsonObj) {
        return new GsonBuilder().create().toJson(jsonObj);
    }


    /**
     * JSON字符串转换为对象
     *
     * @param jsonString JSON字符串
     * @param targetClass 目标类型
     * @return T
     */
    public static <T> T parse(String jsonString, Class<T> targetClass) {
        return new GsonBuilder().create().fromJson(jsonString, targetClass);
    }
}
