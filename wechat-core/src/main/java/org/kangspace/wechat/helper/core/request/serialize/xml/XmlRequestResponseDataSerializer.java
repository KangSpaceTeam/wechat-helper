package org.kangspace.wechat.helper.core.request.serialize.xml;

import io.netty.handler.codec.http.HttpHeaderValues;
import org.kangspace.wechat.helper.core.request.serialize.DataSerializerScope;
import org.kangspace.wechat.helper.core.request.serialize.RequestResponseDataSerializer;


/**
 * JSON 请求序列化
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/11
 */
public class XmlRequestResponseDataSerializer extends RequestResponseDataSerializer<Object> {

    @Override
    public boolean isSupport(String contentType, DataSerializerScope scope) {
        return super.isSupport(contentType, scope) &&
                (contentType.contains(HttpHeaderValues.APPLICATION_XML) ||
                        contentType.contains(HttpHeaderValues.APPLICATION_XHTML));
    }

    @Override
    public int getOrder() {
        return super.getOrder() - 1;
    }
}
