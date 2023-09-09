package org.kangspace.wechat.helper.core.util;

import org.kangspace.devhelper.str.StringLiteral;

/**
 * Token相关工具类
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/25
 */
public class TokenUtil {
    /**
     * AccessToken参数名
     */
    public static final String ACCESS_TOKEN_PARAM = "access_token";
    /**
     * AccessToken参数名+"="
     */
    public static final String ACCESS_TOKEN_PARAM_EQUAL = ACCESS_TOKEN_PARAM + StringLiteral.EQUALS;

    /**
     * 校验请求中是否包含accessToken
     *
     * @param url url
     * @return boolean
     */
    public static boolean containAccessToken(String url) {
        return url.contains(ACCESS_TOKEN_PARAM_EQUAL);
    }

    /**
     * 校验请求中是否包含accessToken
     *
     * @param url url
     * @return accessToken
     */
    public static String getAccessToken(String url) {
        if (containAccessToken(url)) {
            int accessTokenIndex = url.indexOf(ACCESS_TOKEN_PARAM_EQUAL) + ACCESS_TOKEN_PARAM_EQUAL.length();
            int accessTokenLength;
            // 是否包含&符号
            if (url.contains(StringLiteral.AND)) {
                accessTokenLength = url.indexOf(StringLiteral.AND, accessTokenIndex) - accessTokenIndex;
            } else {
                accessTokenLength = url.length() - accessTokenIndex;
            }
            return accessTokenIndex == url.length() ? "" : url.substring(accessTokenIndex, accessTokenIndex + accessTokenLength);
        }
        return null;
    }

    /**
     * 校验请求中是否包含accessToken
     *
     * @param url                url
     * @param replaceAccessToken 新的accessToken
     * @return 新的Url
     */
    public static String replaceAccessToken(String url, String replaceAccessToken) {
        if (containAccessToken(url)) {
            int accessTokenIndex = url.indexOf(ACCESS_TOKEN_PARAM_EQUAL) + ACCESS_TOKEN_PARAM_EQUAL.length();
            int accessTokenLength;
            // 是否包含&符号
            if (url.contains(StringLiteral.AND)) {
                accessTokenLength = url.indexOf(StringLiteral.AND, accessTokenIndex) - accessTokenIndex;
            } else {
                accessTokenLength = url.length() - accessTokenIndex;
            }
            if (accessTokenLength > 0) {
                url = url.substring(0, accessTokenIndex) + replaceAccessToken + url.substring(accessTokenIndex + accessTokenLength);
            }
        }
        return url;
    }


    /**
     * 为Url添加token
     *
     * @param url         url
     * @param accessToken accessToken
     * @return 带access_token的url
     */
    public static String appendAccessToken(String url, String accessToken) {
        return url
                + (!url.contains(StringLiteral.QUESTION_MARK) ? "?" : (!url.endsWith(StringLiteral.QUESTION_MARK) ? StringLiteral.AND : ""))
                + ACCESS_TOKEN_PARAM_EQUAL + accessToken;
    }


    public static void main(String[] args) {
        String url = "https://kangspace.org";
        System.out.println(getAccessToken(url));
        url = "https://kangspace.org?";
        System.out.println(getAccessToken(url));
        url = "https://kangspace.org?access_token=";
        System.out.println(getAccessToken(url));
        url = "https://kangspace.org?access_token=123";
        System.out.println(getAccessToken(url));
        url = "https://kangspace.org?access_token=123&";
        System.out.println(getAccessToken(url));
        url = "https://kangspace.org?access_token=123&a=x&b=1";
        System.out.println(getAccessToken(url));
        System.out.println(replaceAccessToken(url, "345?"));
    }

}
