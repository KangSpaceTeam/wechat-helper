package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 消息推送-撤回应用消息 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/1
 */
@Data
@Builder
public class MessageRecallRequest {

    /**
     * 消息ID。从应用发送消息接口处获得。
     */
    @JsonProperty("msgid")
    private String msgId;

    public MessageRecallRequest(String msgId) {
        this.msgId = msgId;
    }

    public MessageRecallRequest() {
    }

}
