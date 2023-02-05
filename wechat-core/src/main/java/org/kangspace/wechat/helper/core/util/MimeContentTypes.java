package org.kangspace.wechat.helper.core.util;

import io.netty.handler.codec.http.HttpHeaderValues;

/**
 * MIME的ContentType集合
 *
 * @author kango2gler@gmail.com
 * @see HttpHeaderValues
 * @since 2023/1/17
 */
public interface MimeContentTypes {

    /**
     * charset=utf-8
     */
    String CHARSET_UTF8 = "charset=utf-8";

    /**
     * 文件上传
     */
    String MULTIPART_FORM_DATA = "multipart/form-data";

    /**
     * 所有类型
     */
    String ALL = "*/*";
    /**
     * graphql
     */
    String APPLICATION_GRAPHQL = "application/graphql+json";
    /**
     * json
     */
    String APPLICATION_JSON = "application/json";
    /**
     * utf-8编码的json
     */
    String APPLICATION_JSON_UTF8 = APPLICATION_JSON + ";" + CHARSET_UTF8;
    /**
     * octet-stream
     */
    String APPLICATION_OCTET_STREAM = "application/octet-stream";
    /**
     * xml
     */
    String APPLICATION_XML = "application/xml";
    /**
     * git
     */
    String IMAGE_GIF = "image/gif";
    /**
     * jpeg
     */
    String IMAGE_JPEG = "image/jpeg";
    /**
     * png
     */
    String IMAGE_PNG = "image/png";
    /**
     * html
     */
    String TEXT_HTML = "text/html";
    /**
     * text/plain
     */
    String TEXT_PLAIN = "text/plain";
    /**
     * text/plain
     */
    String TEXT_PLAIN_UTF8 = TEXT_PLAIN + ";" + CHARSET_UTF8;
    /**
     * text/xml
     */
    String TEXT_XML = "text/xml";
}
