package org.kangspace.wechat.helper.core.env;

import org.kangspace.wechat.helper.core.constant.WeChatConstant;

/**
 * 枚举配置源
 *
 * @author kango2gler@gmail.com
 * @since 2022/9/29
 */
public abstract class ApiEnumPropertySource<T extends Enum<T>> extends EnumPropertySource<T> {
    private static final String NAME = "apiEnumPropertySource";

    public ApiEnumPropertySource(Class<T> enumClass) {
        this(NAME, enumClass);
    }

    public ApiEnumPropertySource(String name, Class<T> enumClass) {
        super(name, enumClass);
    }

    public String getApiBasePath() {
        return getPropertyString(WeChatConstant.API_BASE_PATH_NAME);
    }

    /**
     * 获取当前枚举Api值
     *
     * @param e 枚举
     * @return 值
     */
    public abstract String getValue(T e);
}
