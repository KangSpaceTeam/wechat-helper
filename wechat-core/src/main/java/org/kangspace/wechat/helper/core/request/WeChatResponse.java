package org.kangspace.wechat.helper.core.request;

import java.util.Map;
import java.util.Set;

/**
 * 微信公众号公共Http响应对象
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/1
 */
public interface WeChatResponse<T> {
    /**
     * 获取响应码,200,201等
     *
     * @return status
     */
    int status();

    /**
     * 获取响应体
     *
     * @return T
     */
    T getContent();

    /**
     * 响应头
     *
     * @return Map
     */
    Map<String, String> headers();

    /**
     * cookie
     *
     * @return Map
     */
    Map<String, Set<String>> cookies();
}
