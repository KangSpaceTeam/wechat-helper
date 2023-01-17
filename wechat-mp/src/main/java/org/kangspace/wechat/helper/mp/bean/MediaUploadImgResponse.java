package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

/**
 * 微信公众号素材管理: 新增永久素材,上传图文消息内的图片获取URL 响应参数<br>
 * 如:
 * <pre>
 * {
 *     "url":  "http://mmbiz.qpic.cn/mmbiz/gLO17UPS6FS2xsypf378iaNhWacZ1G1UplZYWEYfwvuU6Ont96b1roYs CNFwaRrSaKTPCUdBK9DgEHicsKwWCBRQ/0"
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#MEDIA_UPLOAD_IMG
 * @since 2022/12/12
 */
@Setter
@Getter
public class MediaUploadImgResponse extends WeChatMpResponseEntity {

    /**
     * 媒体文件上传后，获取标识
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
