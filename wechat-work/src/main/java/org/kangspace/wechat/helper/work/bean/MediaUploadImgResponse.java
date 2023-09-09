package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 素材管理-上传图片 响应对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/9/7
 */
@Setter
@Getter
public class MediaUploadImgResponse extends WeComResponseEntity {

    /**
     * 上传后得到的图片URL。永久有效
     */
    @JsonProperty("url")
    private String url;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "MediaUploadImgResponse{" +
                        "url='" + url + '\'' +
                        "}"
        );
    }
}
