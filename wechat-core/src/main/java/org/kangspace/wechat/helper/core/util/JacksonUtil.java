package org.kangspace.wechat.helper.core.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Jackson JSON工具类
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public class JacksonUtil {

    /**
     *
     */
    static final ObjectMapper MAPPER;
    static {
        MAPPER = new ObjectMapper();
        //在反序列化时忽略在 json 中存在但 Java 对象不存在的属性
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ
        MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //在序列化时忽略值为 null 的属性
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //忽略值为默认值的属性
        MAPPER.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
    }

    /**
     * 对象转换为Json字符串
     *
     * @param jsonObj 对象
     * @return Json字符串
     */
    public static String toJsonString(Object jsonObj) {
        try {
            if (jsonObj instanceof String) {
                return (String) jsonObj;
            }
            return MAPPER.writeValueAsString(jsonObj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * JSON字符串转换为对象
     *
     * @param jsonString  JSON字符串
     * @param targetClass 目标类型
     * @return T
     */
    @SuppressWarnings("unchecked")
    public static <T> T parse(String jsonString, Class<T> targetClass) {
        try {
            if (targetClass.equals(String.class)) {
                return (T) jsonString;
            }
            return MAPPER.readValue(jsonString, targetClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * JSON字符串转换为对象
     *
     * @param jsonString  JSON字符串
     * @param typeReference 目标类型
     * @return T
     */
    public static <T> T parse(String jsonString, TypeReference<T> typeReference) {
        try {
            return MAPPER.readValue(jsonString, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
