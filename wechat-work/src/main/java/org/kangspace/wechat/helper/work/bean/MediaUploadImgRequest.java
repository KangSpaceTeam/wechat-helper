package org.kangspace.wechat.helper.work.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.kangspace.wechat.helper.work.constant.MediaConstant;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import static org.kangspace.wechat.helper.work.constant.MediaConstant.FILE_FORM_NAME;


/**
 * 企业微信"素材管理"-上传图片 参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/09/9
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MediaUploadImgRequest extends MediaUploadRequest {

    public MediaUploadImgRequest(@Nonnull String fileName, @Nonnull InputStream media, @Nonnull String contentType) {
        super(fileName, MediaConstant.MediaType.IMAGE.getValue(), media, contentType);
    }

    public MediaUploadImgRequest(@Nonnull File media, @Nonnull String contentType) {
        super(MediaConstant.MediaType.IMAGE.getValue(), media, contentType);
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
    public String getType() {
        return MediaConstant.MediaType.IMAGE.getValue();
    }
}
