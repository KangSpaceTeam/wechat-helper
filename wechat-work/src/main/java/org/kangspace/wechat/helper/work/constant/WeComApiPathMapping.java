package org.kangspace.wechat.helper.work.constant;

import java.util.Arrays;

import static org.kangspace.wechat.helper.core.constant.WeChatConstant.API_BASE_PATH_NAME;

/**
 * API路径映射类
 * <pre>
 * 路径中参数说明
 *  CORPID: 企微corpId
 *  CORPSECRET: 企微corpSecret
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
public enum WeComApiPathMapping {

    /**
     * 企业微信基础API路径前缀
     */
    API_BASE_PATH(API_BASE_PATH_NAME, "https://qyapi.weixin.qq.com/cgi-bin/"),
    /**
     * 企业微信获取access_token, 参数:CORPID,CORPSECRET
     * API:https://open.work.weixin.qq.com/api/doc/90000/90135/91039
     */
    GET_TOKEN("get_token", "gettoken?corpid=CORPID&corpsecret=CORPSECRET"),
    /**
     * 获取访问用户身份(根据code获取成员信息), 参数:ACCESS_TOKEN, CODE
     * API: https://work.weixin.qq.com/api/doc/90000/90135/91023
     */
    USER_GET_USER_INFO("user_get_user_info", "/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE"),

    // --------------------------- 消息推送相关 ---------------------------
    /**
     * 企业微信发送消息,参数: ACCESS_TOKEN
     * API:https://open.work.weixin.qq.com/api/doc/90001/90143/90372
     */
    MESSAGE_SEND("message_send", "/message/send?access_token=ACCESS_TOKEN"),


    // --------------------------- 企微小程序相关 ---------------------------
    /**
     * 企业微信通过小程序JsCode临时登录凭证校验, 参数: ACCESS_TOKEN,CODE
     * API:https://work.weixin.qq.com/api/doc/90000/90136/91507
     */
    MINIPROGRAM_JSCODE_2_SESSION("miniprogram_jscode_2_session", "/miniprogram/jscode2session?access_token=ACCESS_TOKEN&js_code=CODE&grant_type=authorization_code"),

    // --------------------------- JS-SDK相关 ---------------------------
    /**
     * 企业微信企业jssdk jsApiTcket获取接口 GET, 参数: ACCESS_TOKEN。
     * 用于调用企业微信JS接口的临时票据
     * API:https://open.work.weixin.qq.com/api/doc/90000/90136/90506#%E7%AD%BE%E5%90%8D%E7%AE%97%E6%B3%95
     * JS接口签名校验工具:
     * https://work.weixin.qq.com/api/jsapisign
     */
    GET_JSAPI_TICKET("get_jsapi_ticket", "/get_jsapi_ticket?access_token=ACCESS_TOKEN"),
    ;

    private String pathName;
    private String value;

    WeComApiPathMapping(String pathName, String value) {
        this.pathName = pathName;
        this.value = value;
    }

    /**
     * 通过路径名称获取枚举
     *
     * @param pathName 路径名称 {@link  #name}
     * @return {@link  WeComApiPathMapping}
     */
    public static WeComApiPathMapping parse(String pathName) {
        return Arrays.stream(values()).filter(t -> t.getPathName().equals(pathName)).findFirst().orElse(null);
    }

    public String getPathName() {
        return pathName;
    }

    public String getValue() {
        return value;
    }
}
