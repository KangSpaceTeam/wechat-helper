package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Nonnull;

/**
 * 获取永久素材请求类
 * @author kango2gler@gmail.com
 * @since 2023/02/05 14:27
 */
@Data
public class MaterialGetRequest {

    @Nonnull
    @JsonProperty("media_id")
    private String mediaId;

    public MaterialGetRequest(@Nonnull String mediaId) {
        this.mediaId = mediaId;
    }
}
