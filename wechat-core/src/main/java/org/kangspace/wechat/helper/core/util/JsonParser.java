package org.kangspace.wechat.helper.core.util;

import com.fasterxml.jackson.core.type.TypeReference;
import org.kangspace.wechat.helper.core.constant.StringLiteral;

/**
 * Json工具类
 *
 * @author kango2gler@gmail.com
 * @since 2022/9/29
 */
public class JsonParser {


    /**
     * 对象转换为Json字符串
     *
     * @param jsonObj 对象
     * @return Json字符串
     */
    public static String toJsonString(Object jsonObj) {
        return JacksonParser.getInstance().toJsonString(jsonObj);
    }


    /**
     * JSON字符串转换为对象
     *
     * @param jsonString  JSON字符串
     * @param targetClass 目标类型
     * @return T
     */
    public static <T> T parse(String jsonString, Class<T> targetClass) {
        return JacksonParser.getInstance().parse(jsonString, targetClass);
    }

    /**
     * JSON字符串转换为对象
     *
     * @param jsonString    JSON字符串
     * @param typeReference 目标类型
     * @return T
     */
    public static <T> T parse(String jsonString, TypeReference<T> typeReference) {
        return JacksonParser.getInstance().parse(jsonString, typeReference);
    }

    /**
     * 快速检查是否是Json
     *
     * @return boolean
     */
    public static boolean fastCheckJson(String str) {
        return str != null &&
                //{..}
                ((str.startsWith(StringLiteral.LCB) && str.endsWith(StringLiteral.RCB)) ||
                        // [{...}]
                        (str.startsWith(StringLiteral.LSB_LCB) && str.endsWith(StringLiteral.RCB_RSB))
                );
    }
}
