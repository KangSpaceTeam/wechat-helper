package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.kangspace.wechat.helper.core.bean.MultipartRequest;
import org.kangspace.wechat.helper.core.constant.WeChatConstant;
import org.kangspace.wechat.helper.core.util.IoStreamUtil;
import org.kangspace.wechat.helper.work.constant.MediaConstant;
import org.kangspace.wechat.helper.work.constant.WeComConstant;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import static org.kangspace.wechat.helper.work.constant.MediaConstant.FILE_FORM_NAME;

/**
 * 素材上传 参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/17
 */
@Data
@Builder
public class MediaUploadRequest implements MultipartRequest {
    /**
     * form-data中媒体文件标识，有filename、filelength、content-type等信息
     */
    @Nonnull
    private String fileName;

    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @see MediaConstant.MediaUploadMediaType
     */
    @Nonnull
    @JsonProperty("type")
    private String type;

    /**
     * form-data中媒体文件标识，有filename、filelength、content-type等信息
     */
    @Nonnull
    @JsonProperty(FILE_FORM_NAME)
    private InputStream media;

    /**
     * 文件类型
     *
     * @see org.kangspace.wechat.helper.core.util.MimeContentTypes
     * @see org.kangspace.wechat.helper.core.request.HttpConstant
     * @see io.netty.handler.codec.http.HttpHeaderNames
     */
    @Nonnull
    private String contentType;

    public MediaUploadRequest() {
    }

    public MediaUploadRequest(@Nonnull String fileName, @Nonnull String type, @Nonnull InputStream media, @Nonnull String contentType) {
        this.fileName = fileName;
        this.type = type;
        this.media = media;
        this.contentType = contentType;
    }

    public MediaUploadRequest(@Nonnull String type, @Nonnull File media, @Nonnull String contentType) {
        this.fileName = media.getName();
        this.type = type;
        this.media = IoStreamUtil.toInputStream(media);
        this.contentType = contentType;
    }

    @Override
    public List<Multipart> getMultipartList() {
        InputStream inputStream = this.getMedia();
        return Collections.singletonList(new Multipart(FILE_FORM_NAME, getFileName(), inputStream, this.getContentType()));
    }

    @Override
    public List<FormData> getFormDataList() {
        return MultipartRequest.super.getFormDataList();
    }
}
