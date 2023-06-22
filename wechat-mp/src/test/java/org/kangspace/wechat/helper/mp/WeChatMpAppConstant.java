package org.kangspace.wechat.helper.mp;

import org.kangspace.devhelper.str.StringHelper;

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

    /**
     * 全局验证TOKEN
     */
    public static String GLOBAL_TOKEN = "";

    /**
     * 全局encodingAESKey
     */
    public static String GLOBAL_ENCODING_AES_KEY = "";

    static {
        StringHelper.requireNonBlank(GLOBAL_APPID, "请指定AppId");
        StringHelper.requireNonBlank(GLOBAL_APPSECRET, "请指定AppSecret");
    }
}
