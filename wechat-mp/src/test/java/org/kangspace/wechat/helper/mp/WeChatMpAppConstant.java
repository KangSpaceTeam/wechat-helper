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
    public static String GLOBAL_APPID = "wx5c45e084735f3ba0";
    /**
     * 全局AppSecret
     */
    public static String GLOBAL_APPSECRET = "204845ea503a5a409e96ef36ced63cc4";

    /**
     * 全局验证TOKEN
     */
    public static String GLOBAL_TOKEN = "LTS_TOKEN";

    /**
     * 全局encodingAESKey
     */
    public static String GLOBAL_ENCODING_AES_KEY = "4WJk9nllBCny1LrUwmmpF8jFLYTCO7Tw0jh3dYzJBzs";

    static {
        Objects.requireNonNull(GLOBAL_APPID, "请指定AppId");
        Objects.requireNonNull(GLOBAL_APPSECRET, "请指定AppSecret");
    }
}
