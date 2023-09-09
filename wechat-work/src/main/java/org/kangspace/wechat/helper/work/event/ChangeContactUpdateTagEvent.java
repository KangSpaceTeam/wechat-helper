package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 通讯录回调通知-标签变更通知-标签成员变更事件 <br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90972">https://developer.work.weixin.qq.com/document/path/90972</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ChangeContactUpdateTagEvent extends WeComXmlEvent {
    /**
     * 此时固定为 UPDATE_TAG
     */
    @JacksonXmlProperty(localName = "ChangeType")
    @JacksonXmlCData
    private String changeType = ChangeContactEvent.ChangeType.UPDATE_TAG.getChangeType();

    /**
     * 标签Id
     */
    @JacksonXmlProperty(localName = "TagId")
    private Long tagId;
    /**
     * 标签中新增的成员userid列表，用逗号分隔
     */
    @JacksonXmlProperty(localName = "AddUserItems")
    @JacksonXmlCData
    private String addUserItems;
    /**
     * 标签中删除的成员userid列表，用逗号分隔
     */
    @JacksonXmlProperty(localName = "DelUserItems")
    @JacksonXmlCData
    private String delUserItems;
    /**
     * 标签中新增的部门id列表，用逗号分隔
     */
    @JacksonXmlProperty(localName = "AddPartyItems")
    @JacksonXmlCData
    private String addPartyItems;
    /**
     * 标签中删除的部门id列表，用逗号分隔
     */
    @JacksonXmlProperty(localName = "DelPartyItems")
    @JacksonXmlCData
    private String delPartyItems;
}
