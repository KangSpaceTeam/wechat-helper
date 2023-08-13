package org.kangspace.wechat.helper.core.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.kangspace.wechat.helper.core.constant.WeChatConstant;

/**
 * POST消息签名信息 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/2.0/api/Before_Develop/Message_encryption_and_decryption.html">https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/2.0/api/Before_Develop/Message_encryption_and_decryption.html</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/25
 */
@Data
@ToString(callSuper = true)
public class MessageSignature extends BaseMessageSignature {
    /**
     * 加密类型，为 aes
     *
     * @see org.kangspace.wechat.helper.core.constant.WeChatConstant.EncryptType#AES
     */
    @JsonProperty("encrypt_type")
    private String encryptType;

    /**
     * 消息体签名，用于验证消息体的正确性
     */
    @JsonProperty("msg_signature")
    private String msgSignature;

    public MessageSignature() {
    }

    public MessageSignature(String timestamp, String nonce) {
        super(timestamp, nonce);
    }

    public MessageSignature(String signature, String timestamp, String nonce) {
        super(signature, timestamp, nonce);
    }

    public MessageSignature(String msgSignature, String timestamp, String nonce, String encryptType) {
        super(msgSignature, timestamp, nonce);
        this.encryptType = encryptType;
        this.msgSignature = msgSignature;
    }

    public MessageSignature(String signature, String timestamp, String nonce, String encryptType, String msgSignature) {
        super(signature, timestamp, nonce);
        this.encryptType = encryptType;
        this.msgSignature = msgSignature;
    }

    /**
     * 是否加密消息
     *
     * @return boolean
     */
    public boolean isEncrypt() {
        return this.getEncryptType() != null || this.getMsgSignature() != null;
    }

    /**
     * 构建msgSignature类型的消息签名对象
     *
     * @param msgSignature 消息签名字符串
     * @param timestamp    时间戳
     * @param nonce        随机数
     * @return {@link MessageSignature}
     */
    public static MessageSignature buildMsgSignature(String msgSignature, String timestamp, String nonce) {
        return new MessageSignature(msgSignature, timestamp, nonce, WeChatConstant.EncryptType.AES.getValue());
    }
}
