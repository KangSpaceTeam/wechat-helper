package org.kangspace.wechat.helper.work.message;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 基础消息能力-常量
 *
 * @author kango2gler@gmail.com
 * @since 2023/07/25
 */
public interface MessageConstant {
    /**
     * 消息颜色
     */
    enum Color {
        /**
         * 默认颜色: 黑色
         */
        DEFAULT("#000000"),
        /**
         * 默认蓝色
         */
        DEFAULT_BLUE("#173177"),
        /**
         * 默认红色
         */
        DEFAULT_RED("#FF0000"),
        /**
         * 默认橙色
         */
        DEFAULT_ORANGE("#FFA500"),
        ;
        private final String color;

        Color(String color) {
            this.color = color;
        }

        @JsonValue
        public String getColor() {
            return color;
        }
    }

    /**
     * 消息类型
     */
    enum MessageType {
        /**
         * 事件消息: event
         */
        EVENT,
        /**
         * 文本消息: text
         */
        TEXT,
        /**
         * 图片消息: image
         */
        IMAGE,
        /**
         * 语音消息: voice
         */
        VOICE,
        /**
         * 视频消息: video
         */
        VIDEO;

        @JsonValue
        public String getValue() {
            return this.name().toLowerCase();
        }

    }
}
