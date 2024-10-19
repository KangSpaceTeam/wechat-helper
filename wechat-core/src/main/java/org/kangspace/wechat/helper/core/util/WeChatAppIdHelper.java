package org.kangspace.wechat.helper.core.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 微信AppId 工具类
 * 
 * @author kango2gler@gmail.com
 * @since 0.1.1
 */
public class WeChatAppIdHelper {
    /**
     * 微信AppId 前缀
     */
    private static final String WECHAT_APP_ID_PREFIX = "wx";

    /**
     * 检查是否为AppId
     * 
     * @param appId 微信AppId
     * @return 是否为AppId
     */
    public static boolean isAppId(String appId) {
        if (StringUtils.isBlank(appId) || appId.length() != 18) {
            return false;
        }
        return appId.startsWith(WECHAT_APP_ID_PREFIX)
                && appId.matches("^" + WECHAT_APP_ID_PREFIX + "[a-zA-Z0-9]{16}$");
    }

}
