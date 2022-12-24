package org.kangspace.wechat.helper.core.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * JacksonXml工具类
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public class JacksonXmlParser extends JacksonParser {

    private static final String XML_TYPE = "XML";

    static {
        TYPE_MAPPER.put(XML_TYPE, new JacksonXmlParser());
    }

    public JacksonXmlParser() {
        mapper = new XmlMapper();
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
     * @return {@link JacksonXmlParser}
     */
    public static JacksonXmlParser getInstance() {
        return (JacksonXmlParser) TYPE_MAPPER.get(XML_TYPE);
    }
}
