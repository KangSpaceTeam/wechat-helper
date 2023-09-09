package org.kangspace.wechat.helper.mp.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 文本消息
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_standard_messages.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_standard_messages.html</a>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TextMessage extends StandardMessage {

    /**
     * 文本消息内容
     */
    @JacksonXmlProperty(localName = "Content")
    @JacksonXmlCData
    private String content;
}
