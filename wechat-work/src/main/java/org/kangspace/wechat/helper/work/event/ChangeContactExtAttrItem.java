package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

/**
 * 通讯录回调通知-新增成员事件-扩展属性
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/26
 */
@Data
public class ChangeContactExtAttrItem {
    /**
     * 名称
     */
    @JacksonXmlProperty(localName = "Name")
    @JacksonXmlCData
    private Integer name;
    /**
     * 扩展属性类型: 0-本文 1-网页
     */
    @JacksonXmlProperty(localName = "Type")
    private Integer type;
    /**
     * 文本属性类型，扩展属性类型为0时填写 文本属性内容
     */
    @JacksonXmlElementWrapper(localName = "Text")
    private Text text;

    /**
     * 网页类型属性，扩展属性类型为1时填写
     */
    @JacksonXmlProperty(localName = "Web")
    @JacksonXmlCData
    private Web web;


    @Data
    public static class Text {
        /**
         * 文本属性内容，长度限制32个UTF8字符
         */
        @JacksonXmlProperty(localName = "Value")
        @JacksonXmlCData
        private String value;
    }

    @Data
    public static class Web {
        /**
         * 网页的url
         */
        @JacksonXmlProperty(localName = "Url")
        @JacksonXmlCData
        private String url;

        /**
         * 网页的展示标题
         */
        @JacksonXmlProperty(localName = "Title")
        @JacksonXmlCData
        private String title;
    }
}
