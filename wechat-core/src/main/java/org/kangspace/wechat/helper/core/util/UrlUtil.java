package org.kangspace.wechat.helper.core.util;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nonnull;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * URL工具类
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/16
 */
public class UrlUtil {
    /**
     * URL编码
     *
     * @param url url
     * @return 编码后的url
     */
    public static String encode(@Nonnull String url) {
        if (StringUtils.isBlank(url)) {
            return url;
        }
        String charset = StandardCharsets.UTF_8.name();
        try {
            return URLEncoder.encode(url, charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
