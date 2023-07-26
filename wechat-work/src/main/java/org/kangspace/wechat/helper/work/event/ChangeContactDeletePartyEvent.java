package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.ToString;

/**
 * 通讯录回调通知-删除部门事件 <br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90971">https://developer.work.weixin.qq.com/document/path/90971</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/26
 */
@Data
@ToString(callSuper = true)
public class ChangeContactDeletePartyEvent extends WeComXmlEvent {
    /**
     * 此时固定为 delete_party
     */
    @JacksonXmlProperty(localName = "ChangeType")
    @JacksonXmlCData
    private String changeType = ChangeContactEvent.ChangeType.DELETE_PARTY.getChangeType();
    /**
     * 部门Id
     */
    @JacksonXmlProperty(localName = "Id")
    private Long id;
}
