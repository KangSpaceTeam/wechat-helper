package org.kangspace.wechat.helper.core.request.serialize.json;

import org.kangspace.wechat.helper.core.request.serialize.ResponseDataSerializer;
import org.kangspace.wechat.helper.core.util.JSONUtil;

/**
 * JSON 请求序列化
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/11
 */
public class JsonResponseDataSerializer extends ResponseDataSerializer<Object> {

    @Override
    public String serialize(Object data) {
        return JSONUtil.toJsonString(data);
    }

    @Override
    public Object deserialize(String data, Class<Object> targetClass) {
        return JSONUtil.parse(data, targetClass);
    }
}
