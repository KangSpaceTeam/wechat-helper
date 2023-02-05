package org.kangspace.wechat.helper.core.request.serialize.file;

import io.netty.buffer.ByteBuf;
import org.kangspace.wechat.helper.core.bean.AttachmentResponse;
import org.kangspace.wechat.helper.core.constant.StringLiteral;
import org.kangspace.wechat.helper.core.request.HttpUtil;
import org.kangspace.wechat.helper.core.request.serialize.DataSerializerScope;
import org.kangspace.wechat.helper.core.request.serialize.ResponseDataSerializer;
import org.kangspace.wechat.helper.core.util.IoStreamUtil;
import org.kangspace.wechat.helper.core.util.ReflectUtil;
import reactor.netty.http.client.HttpClientResponse;

import java.io.File;
import java.util.Objects;

/**
 * 文件响应序列化对象
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/04 00:51
 */
public class AttachmentResponseSerializer extends ResponseDataSerializer<Object> {

    @Override
    public Object deserialize(String data, Class<Object> targetClass) {
        return null;
    }


    /**
     * 文件解析, 并转换为目标对象
     *
     * @param response    响应
     * @param body        文件流
     * @param targetClass 目标对象类型
     * @return 目标对象实例
     */
    public <ResponseBody> ResponseBody deserialize(HttpClientResponse response, String savePath, ByteBuf body, Class<ResponseBody> targetClass) {
        Objects.requireNonNull(response, "response must be not null!");
        Objects.requireNonNull(savePath, "savePath must be not null!");
        Objects.requireNonNull(body, "bodyMono must be not null!");
        Objects.requireNonNull(targetClass, "targetClass must be not null!");
        checkAttachmentResponseTarget(targetClass);
        String contentDispositionFileName = HttpUtil.getContentDispositionFileName(response);
        Objects.requireNonNull(contentDispositionFileName, "contentDispositionFileName must be not null!");
        String contentType = HttpUtil.getContentType(response);
        if (contentType == null && contentDispositionFileName.contains(StringLiteral.DOT)) {
            int index = contentDispositionFileName.lastIndexOf(StringLiteral.DOT) + (contentDispositionFileName.endsWith(StringLiteral.DOT) ? 0 : 1);
            contentType = contentDispositionFileName.substring(index);
        }
        // 保存文件
        File file = IoStreamUtil.save(contentDispositionFileName, savePath, body);
        // 生成目标类实例
        ResponseBody responseBody = ReflectUtil.newInstance(targetClass);
        AttachmentResponse attachmentResponse = ((AttachmentResponse) responseBody);
        attachmentResponse.setContentType(contentType);
        attachmentResponse.setFile(file);
        return responseBody;
    }

    /**
     * 检查目标类是否为{@link org.kangspace.wechat.helper.core.bean.AttachmentResponse}
     *
     * @param targetClass 目标对象
     */
    private void checkAttachmentResponseTarget(Class<?> targetClass) {
        if (!AttachmentResponse.class.isAssignableFrom(targetClass)) {
            throw new IllegalArgumentException("targetClass must be implement AttachmentResponse interface!");
        }
    }


    @Override
    public boolean isSupport(String contentType, DataSerializerScope scope, Object data) {
        return super.isSupport(contentType, scope);
    }
}
