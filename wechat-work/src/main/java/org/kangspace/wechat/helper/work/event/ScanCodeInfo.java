package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

/**
 * 扫描信息
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/13
 */
@Data
public class ScanCodeInfo {
    /**
     * 扫描类型，一般是qrcode
     */
    @JacksonXmlProperty(localName = "ScanType")
    @JacksonXmlCData
    private String scanType;
    /**
     * 扫描结果，即二维码对应的字符串信息
     */
    @JacksonXmlProperty(localName = "ScanResult")
    @JacksonXmlCData
    private String scanResult;
}
