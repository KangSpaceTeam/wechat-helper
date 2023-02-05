package org.kangspace.wechat.helper.core.request.serialize;

/**
 * 数据序列化接口
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/11
 */
public interface DataSerializer<FROM> {
    /**
     * 序列化对象
     *
     * @param data data
     * @return {@link String}
     */
    String serialize(FROM data);

    /**
     * 反序列化对象
     *
     * @param data        data
     * @param targetClass 需要转换的类
     * @return {@link FROM}
     */
    FROM deserialize(String data, Class<FROM> targetClass);

    /**
     * 是否支持该序列化
     *
     * @param contentType MIME ContentType类型
     * @param scope       {@link DataSerializerScope}
     * @return boolean
     */
    boolean isSupport(String contentType, DataSerializerScope scope);

    /**
     * 是否支持该序列化
     *
     * @param contentType MIME ContentType类型
     * @param scope       {@link DataSerializerScope}
     * @param data data
     * @return boolean
     */
    boolean isSupport(String contentType, DataSerializerScope scope, Object data);

    /**
     * 获取处理顺序
     *
     * @return 顺序
     */
    int getOrder();
}
