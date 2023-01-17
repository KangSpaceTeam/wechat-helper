package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import java.util.List;

/**
 * 微信公众号素材管理:获取素材列表 响应参数<br>
 * 如:
 * <pre>
 * 永久图文消息素材列表的响应如下：
 * {
 *    "total_count": TOTAL_COUNT,
 *    "item_count": ITEM_COUNT,
 *    "item": [{
 *        "media_id": MEDIA_ID,
 *        "content": {
 *            "news_item": [{
 *                "title": TITLE,
 *                "thumb_media_id": THUMB_MEDIA_ID,
 *                "show_cover_pic": SHOW_COVER_PIC(0 / 1),
 *                "author": AUTHOR,
 *                "digest": DIGEST,
 *                "content": CONTENT,
 *                "url": URL,
 *                "content_source_url": CONTETN_SOURCE_URL
 *            },
 *            //多图文消息会在此处有多篇文章
 *            ]
 *         },
 *         "update_time": UPDATE_TIME
 *     },
 *     //可能有多个图文消息 item 结构
 *   ]
 * }
 * 其他类型（图片、语音、视频）的返回如下：
 *
 * {
 *    "total_count": TOTAL_COUNT,
 *    "item_count": ITEM_COUNT,
 *    "item": [{
 *        "media_id": MEDIA_ID,
 *        "name": NAME,
 *        "update_time": UPDATE_TIME,
 *        "url":URL
 *    },
 *    //可能会有多个素材
 *    ]
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#MATERIAL_BATCH_GET_MATERIAL
 * @since 2022/12/12
 */
@Setter
@Getter
public class MaterialBatchGetResponse extends WeChatMpResponseEntity {
    /**
     * 该类型的素材的总数
     */
    @JsonProperty("total_count")
    private Integer totalCount;
    /**
     * 本次调用获取的素材的数量
     */
    @JsonProperty("item_count")
    private Integer itemCount;
    /**
     * 素材列表
     */
    @JsonProperty("item")
    private List<Item> items;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "MaterialBatchGetResponse{" +
                        "totalCount=" + totalCount +
                        ", itemCount=" + itemCount +
                        ", items=" + items +
                        "}"
        );
    }

    /**
     * 素材详情
     */
    @Data
    public static class Item {
        /**
         * 媒体ID
         */
        @JsonProperty("media_id")
        private String mediaId;
        /**
         * 这篇图文消息素材的最后更新时间
         */
        @JsonProperty("update_time")
        private String updateTime;
        /**
         * 其他类型（图片、语音、视频）: 文件名称
         */
        @JsonProperty("name")
        private String name;
        /**
         * 其他类型（图片、语音、视频）: 图文页的URL，或者，当获取的列表是图片素材列表时，该字段是图片的URL
         */
        @JsonProperty("url")
        private String url;
        /**
         * 图文内容
         */
        @JsonProperty("Content")
        private Content content;
    }

    /**
     * 图文内容
     */
    @Data
    public static class Content {
        /**
         * 图文内容列表
         */
        @JsonProperty("news_item")
        private List<MaterialGetResponse.NewItem> newsItems;
    }
}

