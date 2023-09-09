package org.kangspace.wechat.helper.work.bean;

import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.core.bean.AttachmentResponse;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;

import java.io.File;

/**
 * 微信公众号素材管理:获取临时素材 响应参数<br>
 * 如:
 * <pre>
 * {"type":"TYPE","media_id":"MEDIA_ID","created_at":123456789}
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeComApiPaths#MEDIA_GET
 * @since 2022/12/12
 */
@Setter
@Getter
public class MediaGetResponse extends WeComResponseEntity implements AttachmentResponse {

    /**
     * 下载的文件内容
     */
    private File media;

    /**
     * 下载的文件类型
     */
    private String contentType;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "MediaGetResponse{" +
                        ", contentType=" + contentType +
                        ", media=" + media +
                        "}"
        );
    }

    @Override
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public File getFile() {
        return media;
    }

    @Override
    public void setFile(File file) {
        this.media = file;
    }
}

