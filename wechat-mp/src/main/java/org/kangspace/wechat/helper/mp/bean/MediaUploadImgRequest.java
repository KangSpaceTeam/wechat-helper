package org.kangspace.wechat.helper.mp.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.kangspace.wechat.helper.mp.constant.MediaConstant;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import static org.kangspace.wechat.helper.mp.constant.MediaConstant.FILE_FORM_NAME;

/**
 * 微信公众号素材管理: 新增永久素材,上传图文消息内的图片获取URL 参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MediaUploadImgRequest extends MediaUploadRequest {

    public MediaUploadImgRequest(@Nonnull String fileName, @Nonnull InputStream media, @Nonnull String contentType) {
        super(fileName, MediaConstant.MediaType.IMAGE, media, contentType);
    }

    public MediaUploadImgRequest(@Nonnull File media, @Nonnull String contentType) {
        super(MediaConstant.MediaType.IMAGE, media, contentType);
    }

    @Override
    public List<Multipart> getMultipartList() {
        InputStream inputStream = this.getMedia();
        if (inputStream == null) {
            throw new IllegalArgumentException("media must be not null!");
        }
        return Collections.singletonList(new Multipart(FILE_FORM_NAME, getFileName(), inputStream, this.getContentType()));
    }

    @Nonnull
    @Override
    public MediaConstant.MediaType getType() {
        return MediaConstant.MediaType.IMAGE;
    }
}
