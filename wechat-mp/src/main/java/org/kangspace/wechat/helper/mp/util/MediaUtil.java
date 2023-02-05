package org.kangspace.wechat.helper.mp.util;

import org.kangspace.wechat.helper.mp.constant.MediaConstant;

/**
 * 媒体资源工具类
 * @author kango2gler@gmail.com
 * @since 2023/02/04 00:43
 */
public class MediaUtil {
    /**
     * contentType转换为{@link org.kangspace.wechat.helper.mp.constant.MediaConstant.MediaType}
     * @param contentType contentType
     * @return {@link MediaConstant.MediaType}
     */
    public static MediaConstant.MediaType contentTypeToMediaType(String contentType) {
        return MediaConstant.MediaType.parseByContentType(contentType);
    }
}
