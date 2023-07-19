package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 成员对外信息<br>
 * 支持文本、链接、小程序类型<br>
 * <a href="https://developer.work.weixin.qq.com/document/path/92230#13450">https://developer.work.weixin.qq.com/document/path/92230#13450</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/17
 */
@Data
public class ExternalAttr {
    /**
     * 属性类型: 0-文本 1-网页 2-小程序
     */
    private Integer type;
    /**
     * 属性名称： 需要先确保在管理端有创建该属性，否则会忽略
     */
    private String name;

    /**
     * 文本类型的属性,type为0时必填
     */
    private Text text;


    /**
     * 网页类型的属性，url和title字段要么同时为空表示清除该属性，要么同时不为空,type为1时必填
     */
    private Web web;

    /**
     * 程序类型的属性，appid和title字段要么同时为空表示清除该属性，要么同时不为空,type为2时必填
     */
    @JsonProperty("miniprogram")
    private MiniProgram miniProgram;

    @Data
    public static class Text {
        /**
         * 文本属性内容，长度限制32个UTF8字符
         */
        private String value;
    }

    @Data
    public static class Web {
        /**
         * 网页的url，必须包含http或者https头
         */
        private String url;

        /**
         * 网页的展示标题，长度限制12个UTF8字符
         */
        private String title;
    }

    @Data
    public static class MiniProgram {
        /**
         * 小程序appid，必须是有在本企业安装授权的小程序，否则会被忽略
         */
        @JsonProperty("appid")
        private String appId;

        /**
         * 小程序的展示标题，长度限制12个UTF8字符
         */
        private String title;

        /**
         * 小程序的页面路径
         */
        @JsonProperty("pagepath")
        private String pagePath;
    }
}
