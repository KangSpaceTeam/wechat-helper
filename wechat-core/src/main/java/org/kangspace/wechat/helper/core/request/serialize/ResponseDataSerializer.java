package org.kangspace.wechat.helper.core.request.serialize;

/**
 * 响应数据数据序列化对象
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/11
 */
public class ResponseDataSerializer extends AbstractDataSerializer {


    @Override
    public boolean isSupport(DataSerializerScope scope) {
        return DataSerializerScope.RESPONSE.equals(scope);
    }
}
