package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 通讯录回调通知-新增成员事件 <br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90970">https://developer.work.weixin.qq.com/document/path/90970</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ChangeContactCreateUserEvent extends ChangeContactEvent {
    /**
     * 此时固定为create_user
     */
    @JacksonXmlProperty(localName = "ChangeType")
    @JacksonXmlCData
    private String changeType = ChangeType.CREATE_USER.getChangeType();
}
