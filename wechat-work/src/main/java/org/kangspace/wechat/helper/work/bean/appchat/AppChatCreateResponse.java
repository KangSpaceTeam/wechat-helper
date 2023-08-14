package org.kangspace.wechat.helper.work.bean.appchat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;

/**
 * 应用发送消息到群聊会话-创建群聊会话 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
@Setter
@Getter
public class AppChatCreateResponse extends WeComResponseEntity {
    /**
     * 	群聊的唯一标志
     */
    @JsonProperty("chatid")
    private String chatId;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "AppChatCreateResponse{" +
                        "chatId='" + chatId + '\'' +
                        "}"
        );
    }
}
