package org.kangspace.wechat.helper.mp;

import java.util.Objects;

/**
 * 微信公众号App常量
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/2
 */
public class WeChatMpAppConstant {
    /**
     * 全局AppId
     */
    public static String GLOBAL_APPID = "";
    /**
     * 全局AppSecret
     */
    public static String GLOBAL_APPSECRET = "";

    static {
        Objects.requireNonNull(GLOBAL_APPID, "请指定AppId");
        Objects.requireNonNull(GLOBAL_APPSECRET, "请指定AppSecret");
    }
}
