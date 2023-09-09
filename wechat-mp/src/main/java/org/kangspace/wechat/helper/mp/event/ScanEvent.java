package org.kangspace.wechat.helper.mp.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户已关注时的事件推送 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_event_pushes.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_event_pushes.html</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ScanEvent extends SubscribeEvent {

    /**
     * 事件 KEY 值，是一个32位无符号整数，即创建二维码时的二维码scene_id
     */
    @JacksonXmlProperty(localName = "EventKey")
    @JacksonXmlCData
    private String eventKey;
}
