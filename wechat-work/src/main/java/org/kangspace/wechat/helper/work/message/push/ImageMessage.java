package org.kangspace.wechat.helper.work.message.push;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;

/**
 * 消息推送-发送应用消息-图片消息
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
public class ImageMessage extends WeComPushMessage {
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

    @NoArgsConstructor
    @Builder
    @Data
    public static class Image {
        /**
         * 图片媒体文件id，可以调用上传临时素材接口获取
         */
        @Nonnull
        @JsonProperty("media_id")
        private String mediaId;

        public Image(@Nonnull String mediaId) {
            this.mediaId = mediaId;
        }
    }


}
