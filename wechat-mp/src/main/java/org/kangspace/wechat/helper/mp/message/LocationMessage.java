package org.kangspace.wechat.helper.mp.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.ToString;

/**
 * 地理位置消息<br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_standard_messages.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_standard_messages.html</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/01
 */
@Data
@ToString(callSuper = true)
public class LocationMessage extends StandardMessage {

    /**
     * 地理位置纬度
     */
    @JacksonXmlProperty(localName = "Location_X")
    @JacksonXmlCData
    private String locationX;
    /**
     * 地理位置经度
     */
    @JacksonXmlProperty(localName = "Location_Y")
    @JacksonXmlCData
    private String locationY;
    /**
     * 地图缩放大小
     */
    @JacksonXmlProperty(localName = "Scale")
    @JacksonXmlCData
    private String scale;
    /**
     * 地理位置信息
     */
    @JacksonXmlProperty(localName = "Label")
    @JacksonXmlCData
    private String label;

}
