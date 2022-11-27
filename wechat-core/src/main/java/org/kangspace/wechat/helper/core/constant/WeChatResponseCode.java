package org.kangspace.wechat.helper.core.constant;

import java.util.Arrays;

/**
 * 微信公共响应码
 * @author kango2gler@gmail.com
 * @since 2022/11/26
 */
public enum WeChatResponseCode {
    /**
     * 系统繁忙，此时请开发者稍候再试
     */
    CODE_NE_1(-1, "系统繁忙，此时请开发者稍候再试"),
    /*
     * 请求成功
     */
    SUCCESS(0, "请求成功"),
    ;

    /**
     * 返回码
     */
    private final Integer code;
    /**
     * 返回码说明
     */
    private final String message;

    WeChatResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 通过code获取枚举
     *
     * @param code 响应码
     * @return {@link WeChatResponseCode}
     */
    WeChatResponseCode parse(Integer code) {
        return code != null ? Arrays.stream(values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(null) : null;
    }
}
