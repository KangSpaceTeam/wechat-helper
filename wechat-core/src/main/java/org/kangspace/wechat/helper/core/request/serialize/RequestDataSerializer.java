package org.kangspace.wechat.helper.core.request.serialize;

/**
 * 请求数据序列化对象
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/11
 */
public class RequestDataSerializer extends AbstractDataSerializer {

    @Override
    public boolean isSupport(DataSerializerScope scope) {
        return DataSerializerScope.REQUEST.equals(scope);
    }
}
