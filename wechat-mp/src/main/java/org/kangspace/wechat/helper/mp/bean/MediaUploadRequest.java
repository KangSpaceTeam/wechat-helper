package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kangspace.devhelper.IoStreamUtil;
import org.kangspace.wechat.helper.core.bean.MultipartRequest;
import org.kangspace.wechat.helper.mp.constant.MediaConstant;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import static org.kangspace.wechat.helper.mp.constant.MediaConstant.FILE_FORM_NAME;

/**
 * 微信公众号素材管理:新增临时素材 参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/17
 */
@Data
public class MediaUploadRequest implements MultipartRequest {
    /**
     * form-data中媒体文件标识，有filename、filelength、content-type等信息
     */
    @Nonnull
    private String fileName;

    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     */
    @Nonnull
    @JsonProperty("type")
    private MediaConstant.MediaType type;

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

    public MediaUploadRequest(@Nonnull String fileName, @Nonnull MediaConstant.MediaType type, @Nonnull InputStream media, @Nonnull String contentType) {
        this.fileName = fileName;
        this.type = type;
        this.media = media;
        this.contentType = contentType;
    }

    public MediaUploadRequest(@Nonnull MediaConstant.MediaType type, @Nonnull File media, @Nonnull String contentType) {
        this.fileName = media.getName();
        this.type = type;
        this.media = IoStreamUtil.toInputStream(media);
        this.contentType = contentType;
    }

    @Override
    public List<Multipart> getMultipartList() {
        InputStream inputStream = this.getMedia();
        if (inputStream == null) {
            throw new IllegalArgumentException("media must be not null!");
        }
        return Collections.singletonList(new Multipart(FILE_FORM_NAME, getFileName(), inputStream, this.getContentType()));
    }

    @Override
    public List<FormData> getFormDataList() {
        return MultipartRequest.super.getFormDataList();
    }
}
