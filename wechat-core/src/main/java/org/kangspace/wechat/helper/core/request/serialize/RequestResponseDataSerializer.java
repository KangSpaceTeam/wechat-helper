package org.kangspace.wechat.helper.core.request.serialize;

/**
 * 请求数据序列化对象
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/11
 */
public class RequestResponseDataSerializer<FROM> extends AbstractDataSerializer<FROM> {

    /**
     * 是否支持该Scope的序列化
     *
     * @param scope {@link DataSerializerScope}
     * @return boolean
     */
    public boolean isSupport(DataSerializerScope scope) {
        return DataSerializerScope.REQUEST.equals(scope) || DataSerializerScope.RESPONSE.equals(scope);
    }

    @Override
    public boolean isSupport(String contentType, DataSerializerScope scope) {
        return contentType != null && isSupport(scope);
    }
}
