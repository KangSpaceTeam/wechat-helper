package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 通讯录回调通知-新增部门事件 <br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90971">https://developer.work.weixin.qq.com/document/path/90971</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ChangeContactCreatePartyEvent extends WeComXmlEvent {
    /**
     * 此时固定为 create_party
     */
    @JacksonXmlProperty(localName = "ChangeType")
    @JacksonXmlCData
    private String changeType = ChangeContactEvent.ChangeType.CREATE_PARTY.getChangeType();
    /**
     * 部门Id
     */
    @JacksonXmlProperty(localName = "Id")
    private Long id;
    /**
     * 部门名称;代开发自建应用需要管理员授权才返回
     */
    @JacksonXmlProperty(localName = "Name")
    @JacksonXmlCData
    private String name;
    /**
     * 父部门id
     */
    @JacksonXmlProperty(localName = "ParentId")
    @JacksonXmlCData
    private Long parentId;
    /**
     * 部门排序
     */
    @JacksonXmlProperty(localName = "Order")
    @JacksonXmlCData
    private Integer order;
}
