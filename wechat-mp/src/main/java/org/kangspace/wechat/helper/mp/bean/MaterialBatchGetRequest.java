package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kangspace.wechat.helper.mp.constant.MediaConstant;

import javax.annotation.Nonnull;

/**
 * 微信公众号素材管理:获取素材列表 参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/17
 */
@Data
public class MaterialBatchGetRequest {

    /**
     * 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
     */
    @Nonnull
    @JsonProperty("type")
    private MediaConstant.MediaType type;

    /**
     * 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     */
    @Nonnull
    @JsonProperty("offset")
    private Integer offset = 0;

    /**
     * 返回素材的数量，取值在1到20之间
     */
    @Nonnull
    @JsonProperty("count")
    private Integer count = 20;

    public MaterialBatchGetRequest(@Nonnull MediaConstant.MediaType type) {
        this.type = type;
    }

    public MaterialBatchGetRequest(@Nonnull MediaConstant.MediaType type, @Nonnull Integer offset, @Nonnull Integer count) {
        this.type = type;
        this.offset = offset;
        this.count = count;
    }
}
