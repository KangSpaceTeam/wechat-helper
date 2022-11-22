package org.kangspace.wechat.helper.core.request.serialize;

import org.kangspace.wechat.helper.core.request.serialize.json.JsonRequestDataSerializer;
import org.kangspace.wechat.helper.core.request.serialize.json.JsonResponseDataSerializer;
import org.kangspace.wechat.helper.core.request.serialize.string.StringRequestDataSerializer;
import org.kangspace.wechat.helper.core.request.serialize.string.StringResponseDataSerializer;
import org.kangspace.wechat.helper.core.request.serialize.xml.XmlRequestDataSerializer;
import org.kangspace.wechat.helper.core.request.serialize.xml.XmlResponseDataSerializer;

import java.util.ArrayList;
import java.util.List;

/**
 * 序列化工厂
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/11
 */
public class DataSerializerFactory {
    /**
     * 默认JSON请求,响应序列化
     *
     * @return List&lt;{@link DataSerializer}&gt;
     */
    public static DataSerializers<Object> defaultJsonSerializers() {
        List<DataSerializer<Object>> list = new ArrayList<>();
        list.add(new JsonRequestDataSerializer());
        list.add(new JsonResponseDataSerializer());
        return new DataSerializers<>(list);
    }

    /**
     * 默认XML请求,响应序列化
     *
     * @return List&lt;{@link DataSerializer}&gt;
     */
    public static DataSerializers<Object> defaultXmlSerializers() {
        List<DataSerializer<Object>> list = new ArrayList<>();
        list.add(new XmlRequestDataSerializer());
        list.add(new XmlResponseDataSerializer());
        return new DataSerializers<>(list);
    }

    /**
     * 默认String请求,响应序列化
     *
     * @return List&lt;{@link DataSerializer}&gt;
     */
    public static DataSerializers<String> defaultStringSerializers() {
        List<DataSerializer<String>> list = new ArrayList<>();
        list.add(new StringRequestDataSerializer());
        list.add(new StringResponseDataSerializer());
        return new DataSerializers<>(list);
    }
}
