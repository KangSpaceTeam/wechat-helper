package org.kangspace.wechat.helper.mp.message.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * 公众号响应加密消息
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/29
 */
@Data
@JacksonXmlRootElement(localName = "xml")
public class WeChatMpEncryptEchoXmlMessage implements WeChatMpEncryptEchoMessage {

    @JacksonXmlProperty(localName = "Encrypt")
    @JacksonXmlCData
    private String encrypt;

    /**
     * 微信加密签名，signature结合了开发者填写的 token 参数和请求中的 timestamp 参数、nonce参数。
     */
    @JacksonXmlProperty(localName = "MsgSignature")
    @JacksonXmlCData
    private String msgSignature;
    /**
     * 时间戳
     */
    @JacksonXmlProperty(localName = "Timestamp")
    @JacksonXmlCData
    private String timestamp;
    /**
     * 随机数
     */
    @JacksonXmlProperty(localName = "Nonce")
    @JacksonXmlCData
    private String nonce;
}
