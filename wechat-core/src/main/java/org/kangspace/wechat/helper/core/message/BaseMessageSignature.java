package org.kangspace.wechat.helper.core.message;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 消息签名信息
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/25
 */
@NoArgsConstructor
@Data
public class BaseMessageSignature {
    /**
     * 微信加密签名，signature结合了开发者填写的 token 参数和请求中的 timestamp 参数、nonce参数。
     */
    @JsonProperty("signature")
    @JsonAlias("msg_signature")
    private String signature;
    /**
     * 时间戳
     */
    private String timestamp;
    /**
     * 随机数
     */
    private String nonce;

    public BaseMessageSignature(String timestamp, String nonce) {
        this.timestamp = timestamp;
        this.nonce = nonce;
    }

    public BaseMessageSignature(String signature, String timestamp, String nonce) {
        this.signature = signature;
        this.timestamp = timestamp;
        this.nonce = nonce;
    }
}
