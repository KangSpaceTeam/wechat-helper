package org.kangspace.wechat.helper.work.bean;

import lombok.Data;

import java.util.List;

/**
 * 成员对外信息<br>
 * 支持文本、链接、小程序类型<br>
 * <a href="https://developer.work.weixin.qq.com/document/path/92230#13450">https://developer.work.weixin.qq.com/document/path/92230#13450</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/17
 */
@Data
public class ExtAttr {
    private List<ExternalAttr> attrs;

    public ExtAttr() {
    }

    public ExtAttr(List<ExternalAttr> attrs) {
        this.attrs = attrs;
    }
}
