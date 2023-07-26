package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.ToString;

/**
 * 通讯录回调通知-修改成员事件 <br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90970">https://developer.work.weixin.qq.com/document/path/90970</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/26
 */
@Data
@ToString(callSuper = true)
public class ChangeContactUpdateUserEvent extends ChangeContactEvent {
    /**
     * 此时固定为 update_user
     */
    @JacksonXmlProperty(localName = "ChangeType")
    @JacksonXmlCData
    private String changeType = ChangeContactEvent.ChangeType.UPDATE_USER.getChangeType();
}
