package org.kangspace.wechat.helper.work.message.push.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 更新按钮为不可点击状态 <br>
 * 仅原卡片为 按钮交互型、投票选择型、多项选择型的卡片可以更新按钮，可以将按钮更新为不可点击状态，并且自定义文案 <br>
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
public class UnClickableUpdateMessage extends UpdateTemplateCardMessage {

    /**
     * 更新整个任务接收人员,1:是,0:否
     */
    @JsonProperty("atall")
    private Integer atAll;

    /**
     * 企业的标签ID列表（最多支持100个）
     */
    @JsonProperty("tagids")
    private List<Long> tagIds;

    /**
     * 需要更新的按钮
     */
    @Nonnull
    @JsonProperty("button")
    private Button button;


    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Button {
        /**
         * 需要更新的按钮的文案
         */
        @Nonnull
        @JsonProperty("replace_name")
        private String replaceName;
    }
}
