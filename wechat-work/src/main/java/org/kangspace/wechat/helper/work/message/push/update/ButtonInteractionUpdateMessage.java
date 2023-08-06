package org.kangspace.wechat.helper.work.message.push.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.push.TemplateCard;

import javax.annotation.Nonnull;

/**
 * 更新为新的卡片-按钮交互型 <br>
 * 可回调的卡片可以更新成任何一种模板卡片 <br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/3
 */
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class ButtonInteractionUpdateMessage extends UpdateTemplateCardMessage {
    /**
     * 表示是否开启id转译，0表示否，1表示是，默认0，id转译说明
     */
    @JsonProperty("enable_id_trans")
    private Integer enableIdTrans;

    @Nonnull
    @JsonProperty("template_card")
    private TemplateCard.ButtonInteraction templateCard;
}
