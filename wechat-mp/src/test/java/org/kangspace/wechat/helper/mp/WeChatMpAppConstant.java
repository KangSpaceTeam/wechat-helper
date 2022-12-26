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
    public static String GLOBAL_APPID = "wx84285874067fd860";
    /**
     * 全局AppSecret
     */
    public static String GLOBAL_APPSECRET = "f0827da32acfd93375beb8f971e3bbf7";

    /**
     * 全局验证TOKEN
     */
    public static String GLOBAL_TOKEN = "LTS_TOKEN";

    static {
        Objects.requireNonNull(GLOBAL_APPID, "请指定AppId");
        Objects.requireNonNull(GLOBAL_APPSECRET, "请指定AppSecret");
    }
}
