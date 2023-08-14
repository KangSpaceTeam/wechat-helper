package org.kangspace.wechat.helper.work.bean.appchat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 应用推送消息
 * @author kango2gler@gmail.com
 * @since 2023/8/14
 */
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AppChatMessage {
    /**
     * 群聊id
     */
    @JsonProperty("chatid")
    private String chatId;

    /**
     表示是否是保密消息，0表示否，1表示是，默认0
     */
    @JsonProperty("safe")
    private Integer safe;

}
