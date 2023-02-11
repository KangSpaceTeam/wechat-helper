package org.kangspace.wechat.helper.core.constant;

/**
 * 常用字符串常量
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public interface StringLiteral {
    /**
     * 等于号
     */
    String EQUALS = "=";
    /**
     * 加号
     */
    String PLUS = "+";
    /**
     * &符
     */
    String AND = "&";
    /**
     * 问号
     */
    String QUESTION_MARK = "?";
    /**
     * 冒号
     */
    String COLON = ":";
    /**
     * 分号
     */
    String SEMICOLON = ";";
    /**
     * 逗号
     */
    String COMMA = ",";

    /**
     * 左小括号(left round bracket)
     */
    String LRB = "(";

    /**
     * 右小括号(right round bracket)
     */
    String RRB = ")";

    /**
     * 左中括号(left square bracket)
     */
    String LSB = "[";

    /**
     * 右中括号(right square bracket)
     */
    String RSB = "]";


    /**
     * 左花括号(left curly bracket)
     */
    String LCB = "{";

    /**
     * 右花括号(right curly bracket)
     */
    String RCB = "}";

    /**
     * [{
     */
    String LSB_LCB = LSB + LCB;

    /**
     * }]
     */
    String RCB_RSB = RCB + RSB;

    /**
     * 点
     */
    String DOT = ".";

}
