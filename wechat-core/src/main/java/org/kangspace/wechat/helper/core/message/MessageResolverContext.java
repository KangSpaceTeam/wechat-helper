package org.kangspace.wechat.helper.core.message;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;

/**
 * 消息解析器上下文
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/28
 */
@Data
@ToString(callSuper = true)
public class MessageResolverContext extends HashMap<String, Object> {

    /**
     * 是否是加密消息
     */
    private Boolean encryptMessage;

    /**
     * 消息加解密对象
     */
    private MessageCipher messageCipher;

    public MessageResolverContext() {
    }

    public MessageResolverContext(Boolean encryptMessage, MessageCipher messageCipher) {
        this.messageCipher = messageCipher;
        this.encryptMessage = encryptMessage;
    }
}
