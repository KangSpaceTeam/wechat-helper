package org.kangspace.wechat.helper.work.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

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
        EVENT("event"),
        /**
         * 文本消息: text
         */
        TEXT("text"),
        /**
         * 图片消息: image
         */
        IMAGE("image"),
        /**
         * 语音消息: voice
         */
        VOICE("voice"),
        /**
         * 视频消息: video
         */
        VIDEO("video"),
        /**
         * 文件消息: file
         */
        FILE("file"),
        /**
         * 文本卡片消息
         */
        TEXT_CARD("textcard"),
        /**
         * 图文消息
         */
        NEWS("news"),
        /**
         * 图文消息(mpnews)
         */
        MP_NEWS("mpnews"),
        /**
         * markdown消息
         */
        MARK_DOWN("markdown"),
        /**
         * 小程序通知消息
         */
        MINI_PROGRAM_NOTICE("miniprogram_notice"),
        /**
         * 模版卡片消息
         */
        TEMPLATE_CARD("template_card"),
        /**
         * 地理位置
         */
        LOCATION("location"),
        /**
         * 链接消息
         */
        LINK("link"),
        ;

        private final String type;

        MessageType(String type) {
            this.type = type;
        }

        @JsonValue
        public String getType() {
            return this.type;
        }

        @JsonCreator
        public MessageType parse(String type) {
            return Arrays.stream(values()).filter(t -> Objects.equals(t.getType(), type)).findFirst().orElse(null);
        }
    }


    /**
     * 模板卡片消息-消息类型
     */
    enum MessageCardType {
        /**
         * 文本通知型
         */
        TEXT_NOTICE("text_notice"),
        /**
         * 图文展示型
         */
        NEWS_NOTICE("news_notice"),
        /**
         * 按钮交互型
         */
        BUTTON_INTERACTION("button_interaction"),
        /**
         * 投票选择型
         */
        VOTE_INTERACTION("vote_interaction"),
        /**
         * 多项选择型
         */
        MULTIPLE_INTERACTION("multiple_interaction"),
        ;

        private final String type;

        MessageCardType(String type) {
            this.type = type;
        }

        @JsonValue
        public String getType() {
            return this.type;
        }
    }

    /**
     * 是否是保密消息，默认为0
     */
    enum Safe {
        /**
         * 1表示不能分享且内容显示水印
         */
        SAFE(1),
        /**
         * 0表示可对外分享
         */
        UN_SAFE(0);
        private final Integer type;

        Safe(Integer type) {
            this.type = type;
        }

        @JsonValue
        public Integer getType() {
            return type;
        }
    }

    /**
     * 来源文字的颜色，目前支持：0(默认) 灰色，1 黑色，2 红色，3 绿色
     */
    @Getter
    enum SourceColor {
        /**
         * 0 (默认)灰色
         */
        DEFAULT(0),
        /**
         * 1 黑色
         */
        BLACK(1),
        /**
         * 2 红色
         */
        RED(2),
        /**
         * 3 绿色
         */
        GREEN(3);
        private final Integer color;

        SourceColor(Integer color) {
            this.color = color;
        }
    }
}
