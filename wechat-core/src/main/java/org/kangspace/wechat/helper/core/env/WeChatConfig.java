package org.kangspace.wechat.helper.core.env;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;

/**
 * 微信配置
 * @author kango2gler@gmail.com
 * @since 2022/10/3
 */
@Data
public class WeChatConfig {
    private ApiPathMapping apiPathMapping;

    private RequestConfig request;


    /**
     * 自定义ApiPathMapping
     */
    public static class ApiPathMapping extends HashMap<String, String> {
    }

    @Getter
    public static class RequestConfig{
        /**
         * 是否压缩, default: true
         */
        private boolean compress = true;
        /**
         * 是否重定向, default: true
         */
        private boolean followRedirect = true;
        /**
         * 是否保持连接, default: false
         */
        private boolean keepAlive = false;
        /**
         * 连接超时时间, default: 3000
         */
        private Integer connectionTimeout = 3000;
        /**
         * 读取超时时间时间, default: 3000
         */
        private Long readTimeout = 3000L;
    }
}
