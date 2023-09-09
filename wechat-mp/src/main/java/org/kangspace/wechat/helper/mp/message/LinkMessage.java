package org.kangspace.wechat.helper.mp.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 链接消息<br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_standard_messages.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_standard_messages.html</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LinkMessage extends StandardMessage {

    /**
     * 消息标题
     */
    @JacksonXmlProperty(localName = "Title")
    @JacksonXmlCData
    private String title;

    /**
     * 消息描述
     */
    @JacksonXmlProperty(localName = "Description")
    @JacksonXmlCData
    private String description;

    /**
     * 消息链接
     */
    @JacksonXmlProperty(localName = "Url")
    @JacksonXmlCData
    private String url;
}
