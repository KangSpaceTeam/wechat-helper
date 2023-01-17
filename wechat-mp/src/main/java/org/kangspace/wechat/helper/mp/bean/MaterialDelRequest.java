package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Nonnull;

/**
 * 微信公众号素材管理:删除永久素材 参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/17
 */
@Data
public class MaterialDelRequest {
    @Nonnull
    @JsonProperty("media_id")
    private String mediaId;
}
