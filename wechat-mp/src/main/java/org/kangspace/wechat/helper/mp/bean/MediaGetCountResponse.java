package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

/**
 * 微信公众号素材管理:获取素材总数 响应参数<br>
 * 如:
 * <pre>
 * {
 *   "voice_count":COUNT,
 *   "video_count":COUNT,
 *   "image_count":COUNT,
 *   "news_count":COUNT
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#MATERIAL_GET_MATERIAL_COUNT
 * @since 2022/12/12
 */
@Setter
@Getter
public class MediaGetCountResponse extends WeChatMpResponseEntity {
    /**
     * 语音总数量
     */
    @JsonProperty("voice_count")
    private Integer voiceCount;
    /**
     * 视频总数量
     */
    @JsonProperty("video_count")
    private Integer videoCount;
    /**
     * 图片总数量
     */
    @JsonProperty("image_count")
    private Integer imageCount;
    /**
     * 图文总数量
     */
    @JsonProperty("news_count")
    private Integer newsCount;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "MediaGetCountResponse{" +
                        "voiceCount=" + voiceCount +
                        ", videoCount=" + videoCount +
                        ", imageCount=" + imageCount +
                        ", newsCount=" + newsCount +
                        "}"
        );
    }
}

