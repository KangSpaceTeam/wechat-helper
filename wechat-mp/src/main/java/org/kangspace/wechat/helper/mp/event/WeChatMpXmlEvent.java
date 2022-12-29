package org.kangspace.wechat.helper.mp.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.mp.message.WeChatMpXmlMessage;

/**
 * 微信公众号事件Xml消息
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/12
 */
@Setter
@Getter
public class WeChatMpXmlEvent extends WeChatMpXmlMessage implements WeChatMpEvent {
    /**
     * 事件 KEY 值，与自定义菜单接口中 KEY 值对应
     */
    @JacksonXmlProperty(localName = "EventKey")
    @JacksonXmlCData
    private String eventKey;
}
