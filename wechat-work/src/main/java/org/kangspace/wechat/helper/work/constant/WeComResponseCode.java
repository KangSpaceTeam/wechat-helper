package org.kangspace.wechat.helper.work.constant;

import java.util.Arrays;
import java.util.Objects;

/**
 * <pre>
 * 企业微信全局返回码 枚举。
 * 全局返回码文档: <a href="https://developer.work.weixin.qq.com/document/path/90313">https://developer.work.weixin.qq.com/document/path/90313</a>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public enum WeComResponseCode {
    /**
     * 系统繁忙，此时请开发者稍候再试
     */
    CODE_NE_1(-1, "系统繁忙，此时请开发者稍候再试"),
    /*
     * 请求成功
     */
    SUCCESS(0, "请求成功"),
    CODE_40014(40014, "不合法的access_token"),
    CODE_41001(41001, "缺少access_token参数"),
    CODE_42001(42001, "access_token已过期"),
    ;

    /**
     * 返回码
     */
    private final Integer code;
    /**
     * 返回码说明
     */
    private final String message;

    WeComResponseCode(Integer code, String message) {
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
     * @return {@link WeComResponseCode}
     */
    WeComResponseCode parse(Integer code) {
        return code != null ? Arrays.stream(values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(null) : null;
    }

    /**
     * 是否无效Token
     * @param code code
     * @return boolean
     */
    public static boolean isInvalidToken(Integer code) {
        return code != null
                && (Objects.equals(CODE_41001.getCode(), code)
                || Objects.equals(CODE_40014.getCode(), code)
                || Objects.equals(CODE_42001.getCode(), code));
    }
}
