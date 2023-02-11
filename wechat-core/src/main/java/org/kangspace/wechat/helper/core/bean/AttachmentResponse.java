package org.kangspace.wechat.helper.core.bean;

import java.io.File;

/**
 * 文件响应
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/04 00:30
 */
public interface AttachmentResponse {

    /**
     * 文件名
     *
     * @return 文件名
     */
    default String getFileName() {
        return getFile().getName();
    }

    /**
     * 文件类型
     *
     * @return 文件类型
     */
    String getContentType();

    /**
     * 设置ContentType
     *
     * @param contentType contentType
     */
    void setContentType(String contentType);

    /**
     * 文件
     *
     * @return File
     */
    File getFile();

    /**
     * 设置文件
     *
     * @param file file
     */
    void setFile(File file);

}
