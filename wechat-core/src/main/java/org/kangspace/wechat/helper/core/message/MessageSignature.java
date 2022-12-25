package org.kangspace.wechat.helper.core.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 消息签名信息
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/25
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MessageSignature {
    /**
     * 微信加密签名，signature结合了开发者填写的 token 参数和请求中的 timestamp 参数、nonce参数。
     */
    private String signature;
    /**
     * 时间戳
     */
    private String timestamp;
    /**
     * 随机数
     */
    private String nonce;
    /**
     * 随机字符串(echostr)
     */
    @JsonProperty("echostr")
    private String echoStr;
}
