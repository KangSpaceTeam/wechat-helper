package org.kangspace.wechat.helper.mp.constant;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 素材管理-常量
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/11
 */
public interface MediaConstant {
    /**
     * 文件上传表单名称
     */
    String FILE_FORM_NAME = "media";

    /**
     * 消息类型
     */
    enum MediaType {
        /**
         * 图片（image）: 10M，支持PNG\JPEG\JPG\GIF格式
         */
        IMAGE,
        /**
         * 语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
         */
        VOICE,
        /**
         * 视频（video）：10MB，支持MP4格式
         */
        VIDEO,
        /**
         * 缩略图（thumb）：64KB，支持 JPG 格式
         */
        THUMB,
        /**
         * 图文
         */
        NEWS,
        ;

        @JsonValue
        public String getValue() {
            return this.name().toLowerCase();
        }

    }
}
