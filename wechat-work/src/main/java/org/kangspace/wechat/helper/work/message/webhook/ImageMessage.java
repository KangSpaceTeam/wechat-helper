package org.kangspace.wechat.helper.work.message.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;

/**
 * 群机器人-图片消息<br>
 * 注：图片（base64编码前）最大不能超过2M，支持JPG,PNG格式<br>
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
public class ImageMessage extends WebHookMessage {
    /**
     * 图片消息
     */
    @Nonnull
    @JsonProperty("image")
    private Image image;

    /**
     * 消息类型，此时固定为：image
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.IMAGE.getType();

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Image {
        /**
         * 图片内容的base64编码
         */
        @JsonProperty("base64")
        private String base64;
        /**
         * 图片内容（base64编码前）的md5值
         */
        @JsonProperty("md5")
        private String md5;
    }


}
