package org.kangspace.wechat.helper.work.bean.appchat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

/**
 * 图片消息
 * @author kango2gler@gmail.com
 * @since 2023/8/14
 */
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ImageMessage extends AppChatMessage{
    /**
     * 消息类型，此时固定为：image
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.IMAGE.getType();

    /**
     * 消息
     */
    @JsonProperty("image")
    private Image image;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Image{
        /**
         * 文件id，可以调用上传临时素材接口获取
         */
        @JsonProperty("media_id")
        private String mediaId;
    }
}
