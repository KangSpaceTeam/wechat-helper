package org.kangspace.wechat.helper.core.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * POST消息签名信息 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/2.0/api/Before_Develop/Message_encryption_and_decryption.html">https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/2.0/api/Before_Develop/Message_encryption_and_decryption.html</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/25
 */
@NoArgsConstructor
@AllArgsConstructor
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

    public MessageSignature(String timestamp, String nonce, String encryptType) {
        super(null, timestamp, nonce);
        this.encryptType = encryptType;
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
        return this.getEncryptType() != null && this.getMsgSignature() != null;
    }
}
