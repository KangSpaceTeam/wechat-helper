package org.kangspace.wechat.helper.core.request.serialize;

import org.kangspace.wechat.helper.core.request.serialize.file.AttachmentResponseSerializer;
import org.kangspace.wechat.helper.core.request.serialize.json.JsonRequestResponseDataSerializer;
import org.kangspace.wechat.helper.core.request.serialize.string.StringRequestResponseDataSerializer;
import org.kangspace.wechat.helper.core.request.serialize.xml.XmlRequestResponseDataSerializer;

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
    public static DataSerializers defaultSerializers() {
        List<DataSerializer<?>> list = new ArrayList<>();
        list.add(new AttachmentResponseSerializer());
        list.add(new JsonRequestResponseDataSerializer());
        list.add(new XmlRequestResponseDataSerializer());
        list.add(new StringRequestResponseDataSerializer());
        return new DataSerializers(list);
    }

    /**
     * 默认JSON请求,响应序列化
     *
     * @return List&lt;{@link DataSerializer}&gt;
     */
    public static DataSerializers defaultJsonSerializers() {
        List<DataSerializer<?>> list = new ArrayList<>();
        list.add(new JsonRequestResponseDataSerializer());
        return new DataSerializers(list);
    }

    /**
     * 默认XML请求,响应序列化
     *
     * @return List&lt;{@link DataSerializer}&gt;
     */
    public static DataSerializers defaultXmlSerializers() {
        List<DataSerializer<?>> list = new ArrayList<>();
        list.add(new XmlRequestResponseDataSerializer());
        return new DataSerializers(list);
    }

    /**
     * 默认String请求,响应序列化
     *
     * @return List&lt;{@link DataSerializer}&gt;
     */
    public static DataSerializers defaultStringSerializers() {
        List<DataSerializer<?>> list = new ArrayList<>();
        list.add(new StringRequestResponseDataSerializer());
        return new DataSerializers(list);
    }
}
