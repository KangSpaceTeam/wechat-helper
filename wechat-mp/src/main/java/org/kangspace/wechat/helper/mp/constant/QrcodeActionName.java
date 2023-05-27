package org.kangspace.wechat.helper.mp.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 二维码类型 <br>
 * 二维码类型，QR_SCENE 为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/25
 */
public enum QrcodeActionName {
    /**
     * 临时的整型参数值
     */
    QR_SCENE,
    /**
     * 临时的字符串参数值
     */
    QR_STR_SCENE,
    /**
     * 永久的整型参数值
     */
    QR_LIMIT_SCENE,
    /**
     * 永久的字符串参数值
     */
    QR_LIMIT_STR_SCENE;

    @JsonCreator
    public QrcodeActionName parse(String name) {
        return QrcodeActionName.valueOf(name);
    }

    @JsonValue
    @Override
    public String toString() {
        return this.name();
    }
}
