package org.kangspace.wechat.helper.core.request.serialize;

import org.kangspace.wechat.helper.core.request.serialize.json.JSONRequestDataSerializer;
import org.kangspace.wechat.helper.core.request.serialize.json.JSONResponseDataSerializer;
import org.kangspace.wechat.helper.core.request.serialize.xml.XMLRequestDataSerializer;
import org.kangspace.wechat.helper.core.request.serialize.xml.XMLResponseDataSerializer;

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
    public static DataSerializers defaultJSONSerializers() {
        List<DataSerializer> list = new ArrayList<>();
        list.add(new JSONRequestDataSerializer());
        list.add(new JSONResponseDataSerializer());
        return new DataSerializers(list);
    }

    /**
     * 默认XML请求,响应序列化
     *
     * @return List&lt;{@link DataSerializer}&gt;
     */
    public static DataSerializers defaultXMLSerializers() {
        List<DataSerializer> list = new ArrayList<>();
        list.add(new XMLRequestDataSerializer());
        list.add(new XMLResponseDataSerializer());
        return new DataSerializers(list);
    }
}
