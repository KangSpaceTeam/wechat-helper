package org.kangspace.wechat.helper.work.message.push;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 消息推送-发送应用消息-小程序通知消息
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/2
 */
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class MiniProgramNoticeMessage extends WeComPushMessage {
    /**
     * 小程序通知消息
     */
    @Nonnull
    @JsonProperty("miniprogram_notice")
    private MiniProgramNotice miniProgramNotice;

    /**
     * 消息类型，此时固定为：miniprogram_notice
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.MINI_PROGRAM_NOTICE.getType();

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class MiniProgramNotice {
        /**
         * 小程序appid，必须是与当前应用关联的小程序
         */
        @Nonnull
        @JsonProperty("appid")
        private String appId;

        /**
         * 点击消息卡片后的小程序页面，最长1024个字节，仅限本小程序内的页面。该字段不填则消息点击后不跳转。
         */
        @JsonProperty("page")
        private String page;

        /**
         * 消息标题，长度限制4-12个汉字（支持id转译）
         */
        @Nonnull
        @JsonProperty("title")
        private String title;

        /**
         * 消息描述，长度限制4-12个汉字（支持id转译）
         */
        @JsonProperty("description")
        private String description;

        /**
         * 是否放大第一个content_item
         */
        @JsonProperty("emphasis_first_item")
        private Boolean emphasisFirstItem;

        /**
         * 消息内容键值对，最多允许10个item
         */
        @JsonProperty("content_item")
        private List<Item> contentItem;
    }

    @NoArgsConstructor
    @Data
    public static class Item {
        /**
         * 长度10个汉字以内
         */
        @Nonnull
        @JsonProperty("key")
        private String key;
        /**
         * 长度30个汉字以内（支持id转译）
         */
        @Nonnull
        @JsonProperty("value")
        private String value;

        public Item(@Nonnull String key, @Nonnull String value) {
            this.key = key;
            this.value = value;
        }
    }


}
