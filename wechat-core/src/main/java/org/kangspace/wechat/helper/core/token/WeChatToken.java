package org.kangspace.wechat.helper.core.token;

/**
 * WeChatToken接口
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/4
 */
public interface WeChatToken {
    /**
     * 获取Token
     *
     * @return token
     */
    String getToken();

    /**
     * Token超时时间
     *
     * @return 超时时间
     */
    Long getExpiresIn();
}
