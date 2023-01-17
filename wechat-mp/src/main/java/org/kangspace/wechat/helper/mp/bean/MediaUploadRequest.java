package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kangspace.wechat.helper.core.bean.MultipartRequest;
import org.kangspace.wechat.helper.core.util.IOStreamUtil;
import org.kangspace.wechat.helper.mp.constant.MediaConstant;

import javax.annotation.Nonnull;
import java.io.File;
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
    private File media;

    /**
     * 文件类型
     */
    @Nonnull
    private String contentType;

    @Override
    public List<Multipart> getMultipartList() {
        File file = this.getMedia();
        if (!file.isFile()) {
            throw new IllegalArgumentException("media must be a file!");
        }
        return Collections.singletonList(new Multipart(FILE_FORM_NAME, file.getName(), IOStreamUtil.toInputStream(file), this.getContentType()));
    }

    @Override
    public List<FormData> getFormDataList() {
        return MultipartRequest.super.getFormDataList();
    }
}
