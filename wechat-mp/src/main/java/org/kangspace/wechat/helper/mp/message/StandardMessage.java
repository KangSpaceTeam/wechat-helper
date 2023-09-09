package org.kangspace.wechat.helper.mp.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 普通消息<br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_standard_messages.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_standard_messages.html</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StandardMessage extends WeChatMpXmlMessage {

    /**
     * 消息的数据ID（消息如果来自文章时才有）
     */
    @JacksonXmlProperty(localName = "MsgDataId")
    @JacksonXmlCData
    private String msgDataId;

    /**
     * 多图文时第几篇文章，从1开始（消息如果来自文章时才有）
     */
    @JacksonXmlProperty(localName = "Idx")
    @JacksonXmlCData
    private Integer idx;
}
