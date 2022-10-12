package org.kangspace.wechat.helper.core.constant;

/**
 * 微信支持的语言列表
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/2
 */
public enum WeChatLang {
    /**
     * 简体中文
     */
    ZH_CN("zh_CN"),
    ZH_TW("zh_TW"),
    EN("en");

    private final String lang;

    WeChatLang(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    @Override
    public String toString() {
        return this.lang;
    }
}
