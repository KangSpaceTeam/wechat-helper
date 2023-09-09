package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.kangspace.wechat.helper.work.constant.MediaConstant;

import javax.annotation.Nonnull;

/**
 * 素材管理-异步上传临时素材 请求对象<br>
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/9/8
 */
@Data
@Builder
public class MediaUploadByUrlRequest {
    /**
     * 场景值。1-客户联系入群欢迎语素材（目前仅支持1）。注意：每个场景值有对应的使用范围，详见上面的「使用场景说明」
     */
    @Nonnull
    @JsonProperty("scene")
    private Integer scene;

    /**
     * 媒体文件类型。目前仅支持video-视频，file-普通文件 不超过32字节。
     *
     * @see MediaConstant.MediaUploadMediaType
     */
    @Nonnull
    @JsonProperty("type")
    private String type;

    /**
     * 文件名，标识文件展示的名称。比如，使用该media_id发消息时，展示的文件名由该字段控制。不超过128字节。
     */
    @Nonnull
    @JsonProperty("filename")
    private String fileName;

    /**
     * 文件cdn url。url要求支持Range分块下载 不超过1024字节。如果为腾讯云cos链接，则需要设置为「公有读」权限。
     */
    @Nonnull
    @JsonProperty("url")
    private String url;

    /**
     * 文件md5。对比从url下载下来的文件md5是否一致。不超过32字节。
     */
    @Nonnull
    @JsonProperty("md5")
    private String md5;
}
