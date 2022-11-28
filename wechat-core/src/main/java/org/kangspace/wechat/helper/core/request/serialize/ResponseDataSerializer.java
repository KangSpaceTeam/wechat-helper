package org.kangspace.wechat.helper.core.request.serialize;

/**
 * 响应数据数据序列化对象
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/11
 */
public class ResponseDataSerializer<FROM> extends AbstractDataSerializer<FROM> {

    @Override
    public boolean isSupport(String contentType, DataSerializerScope scope) {
        return false;
    }
}
