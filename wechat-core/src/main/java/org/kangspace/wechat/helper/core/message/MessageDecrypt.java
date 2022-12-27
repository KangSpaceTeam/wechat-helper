package org.kangspace.wechat.helper.core.message;

import lombok.Data;

import java.util.Objects;

/**
 * 消息解码器
 * @author kango2gler@gmail.com
 * @since 2022/12/26
 */
@Data
public class MessageDecrypt {
    /**
     * 公众号第三方平台的 EncodingAESKey
     */
    private String encodingAESKey;

    public MessageDecrypt(String encodingAESKey) {
        this.encodingAESKey = encodingAESKey;
    }

    /**
     * 消息解码
     * @param messageSignature 消息签名
     * @param rawMessage 原始消息内容
     * @return 解码后的消息
     */
    public String decrypt(MessageSignature messageSignature, String rawMessage) {
        Objects.requireNonNull(this.encodingAESKey,"encodingAESKey must be not null! 需设置WeChatConfig.getEncodingAESKey()!");
        // TODO xxx
        return null;
    }
}
