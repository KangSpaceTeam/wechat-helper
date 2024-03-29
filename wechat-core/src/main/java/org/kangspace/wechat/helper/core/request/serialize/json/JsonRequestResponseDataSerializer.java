package org.kangspace.wechat.helper.core.request.serialize.json;

import io.netty.handler.codec.http.HttpHeaderValues;
import org.kangspace.devhelper.json.JsonParser;
import org.kangspace.wechat.helper.core.request.HttpConstant;
import org.kangspace.wechat.helper.core.request.serialize.DataSerializerScope;
import org.kangspace.wechat.helper.core.request.serialize.RequestResponseDataSerializer;

/**
 * JSON 请求序列化
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/11
 */
public class JsonRequestResponseDataSerializer extends RequestResponseDataSerializer<Object> {
    @Override
    public String serialize(Object data) {
        return JsonParser.toJsonString(data);
    }

    @Override
    public Object deserialize(String data, Class<Object> targetClass) {
        return JsonParser.parse(data, targetClass);
    }

    @Override
    public boolean isSupport(String contentType, DataSerializerScope scope, Object data) {
        return super.isSupport(contentType, scope) &&
                (contentType.contains(HttpHeaderValues.APPLICATION_JSON) ||
                        (contentType.contains(HttpConstant.TEXT) && JsonParser.fastCheckJson(data.toString())));
    }

    @Override
    public int getOrder() {
        return super.getOrder() - 2;
    }
}
