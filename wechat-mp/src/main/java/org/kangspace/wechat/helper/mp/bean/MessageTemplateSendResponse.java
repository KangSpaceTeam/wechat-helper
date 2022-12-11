package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

/**
 * 模板消息-发送模板消息 响应参数<br>
 * 如:
 * <pre>
 *  {
 *     "errcode":0,
 *      "errmsg":"ok",
 *      "msgid":200228332
 *   }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#MESSAGE_TEMPLATE_SEND
 * @since 2022/12/11
 */
@Data
@ToString(callSuper = true)
public class MessageTemplateSendResponse extends WeChatMpResponseEntity {

    /**
     * 消息ID
     */
    @JsonProperty("msgid")
    private String msgId;
}
