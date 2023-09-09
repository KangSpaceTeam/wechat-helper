package org.kangspace.wechat.helper.mp.constant;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

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
    @Getter
    enum MediaType {
        /**
         * 图片（image）: 10M，支持PNG\JPEG\JPG\GIF格式
         */
        IMAGE(new String[]{"png", "jpeg", "jpg", "git"}),
        /**
         * 语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
         */
        VOICE(new String[]{"amr", "mp3"}),
        /**
         * 视频（video）：10MB，支持MP4格式
         */
        VIDEO(new String[]{"mp4"}),
        /**
         * 缩略图（thumb）：64KB，支持 JPG 格式
         */
        THUMB(new String[]{"png", "jpeg", "jpg", "git"}),
        /**
         * 图文
         */
        NEWS(null),
        ;

        private String[] supportTypes;

        MediaType(String[] supportTypes) {
            this.supportTypes = supportTypes;
        }

        @JsonValue
        public String getValue() {
            return this.name().toLowerCase();
        }

        @Override
        public String toString() {
            return getValue();
        }

        /**
         * 通过contentType获取指定类型
         *
         * @param contentType contentType
         * @return {@link MediaType}
         */
        public static MediaType parseByContentType(String contentType) {
            if (contentType == null) {
                return null;
            }
            return Arrays.stream(values()).filter(t -> Arrays.stream(t.getSupportTypes()).anyMatch(contentType::contains)).findFirst().orElse(null);
        }
    }
}
