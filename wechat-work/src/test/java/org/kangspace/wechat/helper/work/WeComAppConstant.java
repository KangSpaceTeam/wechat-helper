package org.kangspace.wechat.helper.work;

import org.kangspace.devhelper.str.StringHelper;

/**
 * 企业微信App常量
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/2
 */
public class WeComAppConstant {
    /**
     * 全局corpId
     */
    public static String GLOBAL_CORP_ID = "";
    /**
     * 全局corpSecret
     */
    public static String GLOBAL_CORP_SECRET = "";

    static {
        StringHelper.requireNonBlank(GLOBAL_CORP_ID, "请指定corpId");
        StringHelper.requireNonBlank(GLOBAL_CORP_SECRET, "请指定corpSecret");
    }
}
