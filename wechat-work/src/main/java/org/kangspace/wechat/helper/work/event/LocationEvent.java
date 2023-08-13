package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 上报地理位置 <br>
 * 接口文档:
 * <a href="https://developer.work.weixin.qq.com/document/path/90240">https://developer.work.weixin.qq.com/document/path/90240</a> <br>
 * <p>
 * 成员同意上报地理位置后，每次在进入应用会话时都会上报一次地理位置。<br>
 * 企业可以在管理端修改应用是否需要获取地理位置权限。<br>
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LocationEvent extends WeComXmlEvent {
    public static final String EVENT = "LOCATION";
    /**
     * 地理位置纬度
     */
    @JacksonXmlProperty(localName = "Latitude")
    private String latitude;
    /**
     * 地理位置经度
     */
    @JacksonXmlProperty(localName = "Longitude")
    private String longitude;
    /**
     * 地理位置精度
     */
    @JacksonXmlProperty(localName = "Precision")
    private String precision;
    /**
     * app类型，在企业微信固定返回wxwork，在微信不返回该字段
     */
    @JacksonXmlProperty(localName = "AppType")
    @JacksonXmlCData
    private String appType;

}
