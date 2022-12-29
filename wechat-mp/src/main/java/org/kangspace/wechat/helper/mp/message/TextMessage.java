package org.kangspace.wechat.helper.mp.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 文本消息
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/29
 */
public class TextMessage extends WeChatMpXmlMessage {

    /**
     * 文本消息内容
     */
    @JacksonXmlProperty(localName = "Content")
    @JacksonXmlCData
    private String content;
}
