package org.kangspace.wechat.helper.work.message.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;

/**
 * 群机器人-模版卡片消息
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/2
 */
@Data
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TemplateCardMessage extends WebHookMessage {
    /**
     * 模版卡片消息
     *
     * @see TemplateCard.TextNotice
     * @see TemplateCard.NewsNotice
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
