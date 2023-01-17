package org.kangspace.wechat.helper.core.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/**
 * 文件上传请求超类
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/17
 */
public interface MultipartRequest {
    /**
     * 需要上传的文件列表
     *
     * @return {@link List}&lt;{@link Multipart}&gt;
     */
    List<Multipart> getMultipartList();

    /**
     * 需要上传的属性列表
     *
     * @return {@link List}&lt;{@link FormData}&gt;
     */
    default List<FormData> getFormDataList() {
        return Collections.emptyList();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Multipart {
        private String name;
        private String fileName;
        private InputStream stream;
        private String contentType;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class FormData {
        private String name;
        private String value;
    }
}
