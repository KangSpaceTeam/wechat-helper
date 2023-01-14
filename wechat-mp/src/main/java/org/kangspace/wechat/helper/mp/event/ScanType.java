package org.kangspace.wechat.helper.mp.event;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 扫描类型
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/31
 */
public enum ScanType {
    /**
     * 二维码
     */
    QR_CODE("qrcode"),
    ;

    private final String scanType;

    ScanType(String scanType) {
        this.scanType = scanType;
    }

    @JsonValue
    public String getScanType() {
        return scanType;
    }
}
