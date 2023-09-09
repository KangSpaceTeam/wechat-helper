package org.kangspace.wechat.helper.core.request;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.cookie.Cookie;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.kangspace.devhelper.CollectionUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 微信公众号公共Http响应对象
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/1
 */
@Slf4j
@ToString
@Getter
@Setter
public class WeChatNettyResponse<T> extends AbstractWeChatResponse {
    private int status;
    private Map<String, String> headers;
    private Map<String, Set<String>> cookies;

    private T content;

    public WeChatNettyResponse() {
    }

    public WeChatNettyResponse(int status, T content) {
        this.status = status;
        this.content = content;
    }

    public WeChatNettyResponse(int status, T content, Map<String, String> headers, Map<String, Set<String>> cookies) {
        this.status = status;
        this.headers = headers;
        this.cookies = cookies;
        this.content = content;
    }

    /**
     * Header转换
     *
     * @param headers {@link HttpHeaders}
     * @return Map
     */
    public static Map<String, String> toHeaders(HttpHeaders headers) {
        if (headers == null) {
            return Collections.emptyMap();
        }
        Map<String, String> headersMap = new HashMap<>();
        headers.forEach(t -> {
            headersMap.put(t.getKey(), t.getValue());
        });
        return headersMap;
    }

    /**
     * Cookies转换
     *
     * @param cookies {@link Map}
     * @return Map
     */
    public static Map<String, Set<String>> toCookies(Map<CharSequence, Set<Cookie>> cookies) {
        if (CollectionUtil.isEmpty(cookies)) {
            return Collections.emptyMap();
        }
        Map<String, Set<String>> cookiesMap = new HashMap<>();
        cookies.forEach((k, v) -> {
            cookiesMap.put(k.toString(), Arrays.stream(v.toArray()).map(Object::toString).collect(Collectors.toSet()));
        });
        return cookiesMap;
    }

    @Override
    public int status() {
        return status;
    }

    @Override
    public T getContent() {
        return content;
    }

    @Override
    public Map<String, String> headers() {
        return headers;
    }

    @Override
    public Map<String, Set<String>> cookies() {
        return cookies;
    }

    public String getContentString() {
        return content != null ? content.toString() : null;
    }
}
