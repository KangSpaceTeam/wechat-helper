package org.kangspace.wechat.helper.core.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.HashMap;
import java.util.Map;

/**
 * Jackson JSON工具类
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public class JacksonParser {

    /**
     * Jackson ObjectMapper
     */
    static final Map<String, JacksonParser> TYPE_MAPPER = new HashMap<>(2);
    /**
     * JSON类型
     */
    private static final String JSON_TYPE = "JSON";

    static {
        TYPE_MAPPER.put(JSON_TYPE, new JacksonParser());
    }

    ObjectMapper mapper;

    public JacksonParser() {
        mapper = new ObjectMapper();
        //在反序列化时忽略在 json 中存在但 Java 对象不存在的属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //在序列化时忽略值为 null 的属性
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //忽略值为默认值的属性
        mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
    }

    /**
     * 获取Mapper对象
     *
     * @return {@link JacksonParser}
     */
    public static JacksonParser getInstance() {
        return TYPE_MAPPER.get(JSON_TYPE);
    }

    /**
     * 获得当前Mapper
     *
     * @return {@link ObjectMapper}
     */
    public ObjectMapper getMapper() {
        return mapper;
    }

    /**
     * 转换为Json/XML字符串
     *
     * @param object 对象
     * @return 字符串
     */
    public String toJacksonString(Object object) {
        try {
            if (object instanceof String) {
                return (String) object;
            }
            return getMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对象转换为Json字符串
     *
     * @param jsonObj 对象
     * @return Json字符串
     */
    public String toJsonString(Object jsonObj) {
        return toJacksonString(jsonObj);
    }

    /**
     * JSON字符串转换为对象
     *
     * @param str         JSON字符串
     * @param targetClass 目标类型
     * @return T
     */
    @SuppressWarnings("unchecked")
    public <T> T parse(String str, Class<T> targetClass) {
        try {
            if (targetClass.equals(String.class)) {
                return (T) str;
            }
            return getMapper().readValue(str, targetClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * JSON字符串转换为对象
     *
     * @param str           JSON字符串
     * @param typeReference 目标类型
     * @return T
     */
    public <T> T parse(String str, TypeReference<T> typeReference) {
        try {
            return getMapper().readValue(str, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
