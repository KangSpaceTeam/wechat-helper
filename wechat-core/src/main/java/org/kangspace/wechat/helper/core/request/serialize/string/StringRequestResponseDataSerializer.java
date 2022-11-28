package org.kangspace.wechat.helper.core.request.serialize.string;

import io.netty.handler.codec.http.HttpHeaderValues;
import org.kangspace.wechat.helper.core.request.serialize.DataSerializerScope;
import org.kangspace.wechat.helper.core.request.serialize.RequestResponseDataSerializer;

/**
 * String 请求序列化
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/11
 */
public class StringRequestResponseDataSerializer extends RequestResponseDataSerializer<String> {
    @Override
    public String serialize(String data) {
        return data;
    }

    @Override
    public String deserialize(String data, Class<String> targetClass) {
        return data;
    }

    @Override
    public boolean isSupport(String contentType, DataSerializerScope scope) {
        return contentType == null || (super.isSupport(scope) &&
                (contentType.contains(HttpHeaderValues.TEXT_HTML) ||
                        contentType.contains(HttpHeaderValues.TEXT_PLAIN.toString()) ||
                        contentType.contains(HttpHeaderValues.TEXT_EVENT_STREAM)));
    }

    @Override
    public int getOrder() {
        return super.getOrder();
    }
}
