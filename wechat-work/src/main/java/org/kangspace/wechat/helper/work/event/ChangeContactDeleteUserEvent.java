package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 通讯录回调通知-删除成员事件 <br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90970">https://developer.work.weixin.qq.com/document/path/90970</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ChangeContactDeleteUserEvent extends WeComXmlEvent {
    /**
     * 此时固定为 delete_user
     */
    @JacksonXmlProperty(localName = "ChangeType")
    @JacksonXmlCData
    private String changeType = ChangeContactEvent.ChangeType.DELETE_USER.getChangeType();

    /**
     * 成员UserID
     */
    @JacksonXmlCData
    @JacksonXmlProperty(localName = "UserID")
    private String userId;
}
