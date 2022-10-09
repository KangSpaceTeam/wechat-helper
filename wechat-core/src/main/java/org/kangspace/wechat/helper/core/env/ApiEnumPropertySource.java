package org.kangspace.wechat.helper.core.env;

import static org.kangspace.wechat.helper.core.constant.WeChatConstant.API_BASE_PATH_NAME;

/**
 * 枚举配置源
 *
 * @author kango2gler@gmail.com
 * @date 2022/9/29
 */
public abstract class ApiEnumPropertySource<T extends Enum> extends EnumPropertySource {
    private static final String NAME = "apiEnumPropertySource";

    public ApiEnumPropertySource(Class<T> enumClass) {
        this(NAME, enumClass);
    }

    public ApiEnumPropertySource(String name, Class<T> enumClass) {
        super(name, enumClass);
    }

    public String getApiBasePath() {
        return getPropertyString(API_BASE_PATH_NAME);
    }

    /**
     * 获取当前枚举Api值
     * @param e 枚举
     * @return 值
     */
    public abstract String getValue(T e);
}
