package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kangspace.wechat.helper.mp.constant.MediaConstant;

import java.io.File;

/**
 * 微信公众号素材管理:新增临时素材 参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/17
 */
@Data
public class MediaUploadRequest {
    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     */
    @JsonProperty("type")
    private MediaConstant.MediaType type;

    /**
     * form-data中媒体文件标识，有filename、filelength、content-type等信息
     */
    @JsonProperty("media")
    private File media;
}
