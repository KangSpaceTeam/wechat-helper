package org.kangspace.wechat.helper.core.util;

import javax.annotation.Nonnull;
import java.util.Date;

/**
 * 日期工具类
 * @author kango2gler@gmail.com
 * @since 2022/12/12
 */
public class DateUtil {

    /**
     * 将Unix时间戳转换为{@link Date}
     * @param unixTimestamp Unix时间戳,如: 1351776360
     * @return {@link Date}
     */
    public static Date fromUnix(@Nonnull Long unixTimestamp) {
        return new Date(unixTimestamp * 1000L);
    }
}
