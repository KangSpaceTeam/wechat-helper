package org.kangspace.wechat.helper.core.request.serialize.string;

import org.kangspace.wechat.helper.core.request.serialize.ResponseDataSerializer;

/**
 * JSON 请求序列化
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/11
 */
public class StringResponseDataSerializer extends ResponseDataSerializer<String> {

    @Override
    public String serialize(String data) {
        return data;
    }

    @Override
    public String deserialize(String data, Class<String> targetClass) {
        return data;
    }
}
