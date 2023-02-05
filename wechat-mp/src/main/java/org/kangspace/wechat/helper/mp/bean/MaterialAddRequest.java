package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.kangspace.wechat.helper.core.util.JsonParser;
import org.kangspace.wechat.helper.mp.constant.MediaConstant;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 微信公众号素材管理:新增其他类型永久素材 参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/17
 */
@Setter
@Getter
@ToString(callSuper = true)
public class MaterialAddRequest extends MediaUploadRequest {
    /**
     * 视频素材描述表单name
     */
    private final static String VIDEO_DESCRIPTION_FORM_NAME = "description";

    /**
     * 视频素材描述<br>
     * 新增永久视频素材需特别注意, 在上传视频素材时需要 POST 另一个表单，id为description，包含素材的描述信息，内容格式为JSON。
     */
    @JsonProperty(value = VIDEO_DESCRIPTION_FORM_NAME)
    private Description description;

    public MaterialAddRequest(@Nonnull String fileName, @Nonnull MediaConstant.MediaType type, @Nonnull InputStream media, @Nonnull String contentType) {
        super(fileName, type, media, contentType);
    }

    public MaterialAddRequest(@Nonnull MediaConstant.MediaType type, @Nonnull File media, @Nonnull String contentType) {
        super(type, media, contentType);
    }

    @Override
    public List<FormData> getFormDataList() {
        if (MediaConstant.MediaType.VIDEO.equals(getType())) {
            Objects.requireNonNull(getDescription(), "description must be not null for video upload");
            return Collections.singletonList(new FormData(VIDEO_DESCRIPTION_FORM_NAME, getDescriptionString()));
        }
        return super.getFormDataList();
    }

    /**
     * 转换为Json字符串
     *
     * @return Json字符串
     */
    public String getDescriptionString() {
        return this.getDescription() != null ? JsonParser.toJsonString(this.getDescription()) : "";
    }

    /**
     * 视频描述 <br>
     * 在上传视频素材时需要 POST 另一个表单，id为description，包含素材的描述信息，内容格式为JSON
     */
    @Data
    public static class Description {
        private String title;
        private String introduction;
    }
}
