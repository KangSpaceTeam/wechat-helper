package org.kangspace.wechat.helper.work.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import org.kangspace.wechat.helper.core.message.WeChatEncryptMessage;
import org.kangspace.wechat.helper.core.message.WeChatXmlMessage;

/**
 * 企业微信基础加密XML消息实体
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/25
 */
@Data
@JacksonXmlRootElement(localName = "xml")
public class WeComEncryptXmlMessage implements WeChatEncryptMessage, WeChatXmlMessage {
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
