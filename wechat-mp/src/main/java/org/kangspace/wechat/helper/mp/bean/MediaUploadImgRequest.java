package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.File;

/**
 * 微信公众号素材管理: 新增永久素材,上传图文消息内的图片获取URL 参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/17
 */
@Data
public class MediaUploadImgRequest {
    /**
     * form-data中媒体文件标识，有filename、filelength、content-type等信息
     */
    @JsonProperty("media")
    private File media;
}
