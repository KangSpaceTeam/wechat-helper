package org.kangspace.wechat.helper.core.request.serialize;

/**
 * 数据序列化接口
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/11
 */
public abstract class AbstractDataSerializer<FROM> implements DataSerializer<FROM> {

    @Override
    public String serialize(FROM data) {
        return (String) data;
    }

    @SuppressWarnings("unchecked")
    @Override
    public FROM deserialize(String data, Class<FROM> targetClass) {
        return (FROM) data;
    }

    @Override
    public boolean isSupport(String contentType, DataSerializerScope scope, Object data) {
        return isSupport(contentType, scope);
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
