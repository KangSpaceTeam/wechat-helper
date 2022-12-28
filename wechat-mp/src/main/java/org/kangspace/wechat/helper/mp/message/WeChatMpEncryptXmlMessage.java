package org.kangspace.wechat.helper.mp.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import org.kangspace.wechat.helper.core.message.WeChatXmlMessage;

/**
 * 微信公众号基础加密XML消息实体
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/12
 */
@Data
@JacksonXmlRootElement(localName = "xml")
public class WeChatMpEncryptXmlMessage implements WeChatMpEncryptMessage, WeChatXmlMessage {
    /**
     * 消息类型
     */
    @JacksonXmlProperty(localName = "Encrypt")
    @JacksonXmlCData
    private String encrypt;
    /**
     * 原始消息
     */
    private String raw;

    @Override
    public String getRaw() {
        return this.raw;
    }

    @Override
    public String getEncrypt() {
        return encrypt;
    }

    @Override
    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }
}
