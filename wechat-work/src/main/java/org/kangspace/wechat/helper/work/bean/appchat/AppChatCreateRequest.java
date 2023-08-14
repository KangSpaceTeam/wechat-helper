package org.kangspace.wechat.helper.work.bean.appchat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 应用发送消息到群聊会话-创建群聊会话 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/14
 */
@Data
@Builder
public class AppChatCreateRequest {
    /**
     * 群聊名，最多50个utf8字符，超过将截断
     */
    @JsonProperty("name")
    private String name;
    /**
     * 指定群主的id。如果不指定，系统会随机从userlist中选一人作为群主
     */
    @JsonProperty("owner")
    private String owner;
    /**
     * 群成员id列表。至少2人，至多2000人
     */
    @Nonnull
    @JsonProperty("userlist")
    private List<String> userList;
    /**
     * 群聊的唯一标志，不能与已有的群重复；字符串类型，最长32个字符。只允许字符0-9及字母a-zA-Z。如果不填，系统会随机生成群id
     */
    @JsonProperty("chatid")
    private String chatId;

    public AppChatCreateRequest(String name, String owner, @Nonnull List<String> userList, String chatId) {
        this.name = name;
        this.owner = owner;
        this.userList = userList;
        this.chatId = chatId;
    }

    public AppChatCreateRequest() {
    }

    public AppChatCreateRequest(@Nonnull List<String> userList) {
        this.userList = userList;
    }
}
