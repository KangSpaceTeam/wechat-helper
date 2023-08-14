package org.kangspace.wechat.helper.work.bean.appchat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;

import java.util.List;

/**
 * 应用发送消息到群聊会话-获取群聊会话 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
@Setter
@Getter
public class AppChatGetResponse extends WeComResponseEntity {
    /**
     * 	群聊信息
     */
    @JsonProperty("chat_info")
    private ChatInfo chatInfo;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "AppChatGetResponse{" +
                        "chatInfo=" + chatInfo +
                        "}"
        );
    }

    @Data
    public static class ChatInfo{
        /**
         * 	群聊唯一标志
         */
        @JsonProperty("chatid")
        private String chatId;
        /**
         * 	群聊名
         */
        @JsonProperty("name")
        private String name;
        /**
         * 	群主id
         */
        @JsonProperty("owner")
        private String owner;
        /**
         * 	群成员id列表
         */
        @JsonProperty("userlist")
        private List<String> userList;
    }

}
