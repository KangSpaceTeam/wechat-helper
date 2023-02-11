package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.core.bean.AttachmentResponse;
import org.kangspace.wechat.helper.core.constant.WeChatConstant;
import org.kangspace.wechat.helper.mp.constant.MediaConstant;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;
import org.kangspace.wechat.helper.mp.util.MediaUtil;

import java.io.File;
import java.util.List;

/**
 * 微信公众号素材管理:获取永久素材 响应参数<br>
 * 如:
 * <pre>
 * 图文素材:
 *
 * {
 *  "news_item":
 *  [
 *      {
 *      "title":TITLE,
 *      "thumb_media_id":THUMB_MEDIA_ID,
 *      "show_cover_pic":SHOW_COVER_PIC(0/1),
 *      "author":AUTHOR,
 *      "digest":DIGEST,
 *      "content":CONTENT,
 *      "url":URL,
 *      "content_source_url":CONTENT_SOURCE_URL
 *      },
 *      //多图文消息有多篇文章
 *   ]
 * }
 * 视频消息素材：
 *
 * {
 *   "title":TITLE,
 *   "description":DESCRIPTION,
 *   "down_url":DOWN_URL,
 * }
 * 其他类型的素材消息，则响应的直接为素材的内容，开发者可以自行保存为文件。例如：
 *
 * 示例 curl "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN" -d '{"media_id":"61224425"}' > file
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#MATERIAL_GET_MATERIAL
 * @since 2022/12/12
 */
@Setter
@Getter
public class MaterialGetResponse extends WeChatMpResponseEntity implements AttachmentResponse {
    /**
     * 视频消息素材: 下载地址
     */
    @JsonProperty(value = "down_url")
    private String downUrl;
    /**
     * 视频消息素材: 标题
     */
    @JsonProperty(value = "title")
    private String title;
    /**
     * 视频消息素材: 描述
     */
    @JsonProperty(value = "description")
    private String description;

    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）和缩略图（thumb）, 图文(news)
     */
    private MediaConstant.MediaType type;

    @JsonProperty("news_item")
    private List<NewItem> newItems;

    /**
     * 其他类型的素材消息: 下载的文件类型
     */
    private String contentType;
    /**
     * 其他类型的素材消息: 下载的文件内容
     */
    private File media;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "MaterialGetResponse{" +
                        "downUrl='" + downUrl + '\'' +
                        ", title='" + title + '\'' +
                        ", description='" + description + '\'' +
                        ", type=" + type +
                        ", media=" + media +
                        ", newItems=" + newItems +
                        "}"
        );
    }

    @Override
    public void setContentType(String contentType) {
        this.contentType = contentType;
        this.type = MediaUtil.contentTypeToMediaType(this.getContentType());
    }

    @Override
    public File getFile() {
        return media;
    }

    @Override
    public void setFile(File file) {
        this.media = file;
    }

    /**
     * 是否是文件响应
     *
     * @return boolean
     */
    public boolean isFile() {
        return this.getFile() != null;
    }

    /**
     * 图文消息详情
     */
    @Data
    public static class NewItem {
        /**
         * 图文消息的标题
         */
        @JsonProperty("title")
        private String title;
        /**
         * 图文消息的封面图片素材id（必须是永久mediaID）
         */
        @JsonProperty("thumb_media_id")
        private String thumbMediaId;
        /**
         * 是否显示封面，0为false，即不显示，1为true，即显示
         */
        @JsonProperty("show_cover_pic")
        private WeChatConstant.ShowCover showCoverPic;
        /**
         * 作者
         */
        @JsonProperty("author")
        private String author;
        /**
         * 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
         */
        @JsonProperty("digest")
        private String digest;
        /**
         * 图文消息的具体内容，支持 HTML 标签，必须少于2万字符，小于1M，且此处会去除JS
         */
        @JsonProperty("content")
        private String content;
        /**
         * 图文页的URL
         */
        @JsonProperty("url")
        private String url;
        /**
         * 图文消息的原文地址，即点击“阅读原文”后的URL
         */
        @JsonProperty("content_source_url")
        private String contentSourceUrl;
    }
}

