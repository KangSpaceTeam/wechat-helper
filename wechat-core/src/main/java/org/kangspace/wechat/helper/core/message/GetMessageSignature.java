package org.kangspace.wechat.helper.core.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GET消息签名信息
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/25
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetMessageSignature extends BaseMessageSignature{
    /**
     * 随机字符串(echostr)
     */
    @JsonProperty("echostr")
    private String echoStr;

    public GetMessageSignature(String signature, String timestamp, String nonce, String echoStr) {
        super(signature, timestamp, nonce);
        this.echoStr = echoStr;
    }
}
