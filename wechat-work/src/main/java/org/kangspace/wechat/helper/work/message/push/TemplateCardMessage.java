package org.kangspace.wechat.helper.work.message.push;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;

/**
 * 消息推送-发送应用消息-模版卡片消息
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
public class TemplateCardMessage extends WeComPushMessage {
    /**
     * 模版卡片消息
     *
     * @see TemplateCard.TextNotice
     * @see TemplateCard.NewsNotice
     * @see TemplateCard.ButtonInteraction
     * @see TemplateCard.VoteInteraction
     */
    @Nonnull
    @JsonProperty("template_card")
    private TemplateCard templateCard;

    /**
     * 消息类型，此时固定为：template_card
     */
    @JsonProperty("msgtype")
    private final String msgType = MessageConstant.MessageType.TEMPLATE_CARD.getType();
}
