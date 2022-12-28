package org.kangspace.wechat.helper.core.util;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Xml解析器
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public class XmlParser {
    /**
     * 对象转换为Xml字符串
     *
     * @param object 对象
     * @return Json字符串
     */
    public static String toXmlString(Object object) {
        return JacksonXmlParser.getInstance().toJacksonString(object);
    }

    /**
     * Xml字符串转换为对象
     *
     * @param xml         Xml字符串
     * @param targetClass 目标类型
     * @return T
     */
    public static <T> T parse(String xml, Class<T> targetClass) {
        return JacksonXmlParser.getInstance().parse(xml, targetClass);
    }

    /**
     * Xml字符串转换为对象
     *
     * @param xml           Xml字符串
     * @param typeReference 目标类型
     * @return T
     */
    public static <T> T parse(String xml, TypeReference<T> typeReference) {
        return JacksonXmlParser.getInstance().parse(xml, typeReference);
    }
}
