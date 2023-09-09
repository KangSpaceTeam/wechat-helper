package org.kangspace.wechat.helper.mp.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 上报地理位置事件 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_event_pushes.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_event_pushes.html</a> <br>
 * <pre>
 * 用户同意上报地理位置后，每次进入公众号会话时，都会在进入时上报地理位置，或在进入会话后每5秒上报一次地理位置，公众号可以在公众平台网站中修改以上设置。上报地理位置时，微信会将上报地理位置事件推送到开发者填写的URL。
 *
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LocationEvent extends WeChatMpXmlEvent {

    /**
     * 地理位置纬度
     */
    @JacksonXmlProperty(localName = "Latitude")
    @JacksonXmlCData
    private String latitude;

    /**
     * 地理位置经度
     */
    @JacksonXmlProperty(localName = "Longitude")
    @JacksonXmlCData
    private String longitude;

    /**
     * 地理位置精度
     */
    @JacksonXmlProperty(localName = "Precision")
    @JacksonXmlCData
    private String precision;
}
