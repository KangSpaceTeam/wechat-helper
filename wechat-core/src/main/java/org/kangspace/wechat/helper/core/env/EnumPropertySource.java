package org.kangspace.wechat.helper.core.env;

/**
 * 枚举配置源
 *
 * @author kango2gler@gmail.com
 * @since 2022/9/29
 */
public abstract class EnumPropertySource<T extends Enum> extends PropertySource<Class<T>> {
    private static final String NAME = "enumPropertySource";

    public EnumPropertySource(Class<T> enumClass) {
        this(NAME, enumClass);
    }

    public EnumPropertySource(String name, Class<T> enumClass) {
        super(name, enumClass);
    }
}
