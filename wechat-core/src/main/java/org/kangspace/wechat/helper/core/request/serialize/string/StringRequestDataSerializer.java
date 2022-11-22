package org.kangspace.wechat.helper.core.request.serialize.string;

import org.kangspace.wechat.helper.core.request.serialize.RequestDataSerializer;

/**
 * String 请求序列化
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/11
 */
public class StringRequestDataSerializer extends RequestDataSerializer<String> {
    @Override
    public String serialize(String data) {
        return data;
    }

    @Override
    public String deserialize(String data, Class<String> targetClass) {
        return data;
    }
}
