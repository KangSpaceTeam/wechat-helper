package org.kangspace.wechat.helper.mp.constant;

import org.kangspace.wechat.helper.core.constant.WeChatConstant;

import java.util.Arrays;

/**
 * API路径映射类
 * <pre>
 * 路径中参数说明
 *  APPID: 微信APP_ID
 *  APPSECRET: 微信APP_SECRET
 *  SCOPE: 微信网页授权SCOPE
 *  STATE: 微信网页授权STATE
 *  CODE: 微信网页授权回调CODE
 *  REDIRECT_URI: 微信回调重定向地址
 *  ACCESS_TOKEN: 微信ACCESS_TOKEN
 *  OPENID: 微信OPENID
 *  LANG: 微信获取用户信息的国家地区语言版本
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/2
 */
public enum WeChatMpApiPathMapping {

    /**
     * 企业微信基础API路径前缀
     */
    API_BASE_PATH(WeChatConstant.API_BASE_PATH_NAME, "https://qyapi.weixin.qq.com/cgi-bin/"),
    ;

    private final String pathName;
    private final String value;

    WeChatMpApiPathMapping(String pathName, String value) {
        this.pathName = pathName;
        this.value = value;
    }

    /**
     * 通过路径名称获取枚举
     *
     * @param pathName 路径名称 {@link #name()}
     * @return {@link  WeChatMpApiPathMapping}
     */
    public static WeChatMpApiPathMapping parse(String pathName) {
        return Arrays.stream(values()).filter(t -> t.getPathName().equals(pathName)).findFirst().orElse(null);
    }

    public String getPathName() {
        return pathName;
    }

    public String getValue() {
        return value;
    }
}
