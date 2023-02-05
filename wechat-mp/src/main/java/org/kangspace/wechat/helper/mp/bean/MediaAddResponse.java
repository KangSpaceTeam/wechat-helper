package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

/**
 * 微信公众号素材管理: 新增其他类型永久素材 响应参数<br>
 * 如:
 * <pre>
 * {
 *   "media_id":MEDIA_ID,
 *   "url":URL
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#MATERIAL_ADD_MATERIAL
 * @since 2022/12/12
 */
@Setter
@Getter
public class MediaAddResponse extends WeChatMpResponseEntity {

    /**
     * 新增的永久素材的media_id
     */
    @JsonProperty("media_id")
    private String mediaId;

    /**
     * 新增的图片素材的图片URL（仅新增图片素材时会返回该字段）
     */
    @JsonProperty("url")
    private String url;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "MediaAddResponse{" +
                        "mediaId='" + mediaId + '\'' +
                        ", url='" + url + '\'' +
                        "}"
        );
    }
}
