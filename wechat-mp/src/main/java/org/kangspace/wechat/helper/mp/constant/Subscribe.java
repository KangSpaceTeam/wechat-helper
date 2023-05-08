package org.kangspace.wechat.helper.mp.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * 用户是否订阅该公众号标识，值为0时，
 * 代表此用户没有关注该公众号，拉取不到其余信息
 * @author kango2gler@gmail.com
 * @since 2023/5/8
 */
public enum Subscribe {
    /**
     * 已关注
     */
    YES(1),

    /**
     * 未关注
     */
    NO(0),
    ;
    private final Integer value;

    Subscribe(Integer value) {
        this.value = value;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }

    @JsonCreator
    public static Subscribe valueOf(Integer value) {
        if (value == null) {
            return null;
        }
        return Arrays.stream(values()).filter(t -> t.getValue().equals(value)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return this.getValue().toString();
    }
}
