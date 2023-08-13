package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * 审批状态通知事件 <br>
 * 接口文档:
 * <a href="https://developer.work.weixin.qq.com/document/path/90240">https://developer.work.weixin.qq.com/document/path/90240</a> <br>
 * <p>
 * 本事件触发时机为：<br>
 * 1.自建/第三方应用调用审批流程引擎发起申请之后，审批状态发生变化时<br>
 * 2.自建/第三方应用调用审批流程引擎发起申请之后，在“审批中”状态，有任意审批人进行审批操作时<br>
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OpenApprovalChangeEvent extends WeComXmlEvent {
    public static final String EVENT = "open_approval_change";
    /**
     * 审批信息
     */
    @JacksonXmlProperty(localName = "approvalInfo")
    private ApprovalInfo approvalInfo;

    @Data
    public static class ApprovalInfo {
        /**
         * 审批单编号，由开发者在发起申请时自定义
         */
        @JacksonXmlProperty(localName = "ThirdNo")
        @JacksonXmlCData
        private String thirdNo;
        /**
         * 审批模板名称
         */
        @JacksonXmlProperty(localName = "OpenSpName")
        @JacksonXmlCData
        private String openSpName;
        /**
         * 审批模板id
         */
        @JacksonXmlProperty(localName = "OpenTemplateId")
        @JacksonXmlCData
        private String openTemplateId;
        /**
         * 申请单当前审批状态：1-审批中；2-已通过；3-已驳回；4-已取消
         */
        @JacksonXmlProperty(localName = "OpenSpStatus")
        private Integer openSpStatus;
        /**
         * 提交申请时间
         */
        @JacksonXmlProperty(localName = "ApplyTime")
        private Long applyTime;
        /**
         * 提交者姓名
         */
        @JacksonXmlProperty(localName = "ApplyUserName")
        @JacksonXmlCData
        private String applyUserName;
        /**
         * 提交者userid
         */
        @JacksonXmlProperty(localName = "ApplyUserId")
        @JacksonXmlCData
        private String applyUserId;
        /**
         * 提交者所在部门
         */
        @JacksonXmlProperty(localName = "ApplyUserParty")
        @JacksonXmlCData
        private String applyUserParty;
        /**
         * 提交者头像
         */
        @JacksonXmlProperty(localName = "ApplyUserImage")
        @JacksonXmlCData
        private String applyUserImage;

        /**
         * 审批流程信息，可以有多个审批节点
         */
        @JacksonXmlElementWrapper(localName = "ApprovalNodes")
        @JacksonXmlProperty(localName = "ApprovalNode")
        private List<ApprovalNode> approvalNodes;

        /**
         * 抄送信息，可能有多个抄送人
         */
        @JacksonXmlElementWrapper(localName = "NotifyNodes")
        @JacksonXmlProperty(localName = "NotifyNode")
        private List<NotifyNode> notifyNodes;

        /**
         * 当前审批节点：0-第一个审批节点；1-第二个审批节点…以此类推
         */
        @JacksonXmlProperty(localName = "approverstep")
        private Integer approverStep;
    }

    /**
     * 审批流程信息，可以有多个审批节点
     */
    @Data
    public static class ApprovalNode {
        /**
         * 节点审批操作状态：1-审批中；2-已同意；3-已驳回；4-已转审
         */
        @JacksonXmlProperty(localName = "NodeStatus")
        private Integer nodeStatus;
        /**
         * 审批节点属性：1-或签；2-会签
         */
        @JacksonXmlProperty(localName = "NodeAttr")
        private Integer nodeAttr;
        /**
         * 审批节点类型：1-固定成员；2-标签；3-上级
         */
        @JacksonXmlProperty(localName = "NodeType")
        private Integer nodeType;
        /**
         * 审批节点信息，当节点为标签或上级时，一个节点可能有多个分支
         */
        @JacksonXmlElementWrapper(localName = "Items")
        @JacksonXmlProperty(localName = "Item")
        private List<Item> items;
    }


    /**
     * 审批节点分支，当节点为标签或上级时，一个节点可能有多个分支
     */
    @Data
    public static class Item {
        /**
         * 分支审批人姓名
         */
        @JacksonXmlProperty(localName = "ItemName")
        @JacksonXmlCData
        private String itemName;
        /**
         * 分支审批人userid
         */
        @JacksonXmlProperty(localName = "ItemUserId")
        @JacksonXmlCData
        private String itemUserId;
        /**
         * 分支审批人头像
         */
        @JacksonXmlProperty(localName = "ItemImage")
        @JacksonXmlCData
        private String itemImage;
        /**
         * 分支审批审批操作状态：1-审批中；2-已同意；3-已驳回；4-已转审
         */
        @JacksonXmlProperty(localName = "ItemStatus")
        private Integer itemStatus;
        /**
         * 分支审批人审批意见
         */
        @JacksonXmlProperty(localName = "ItemSpeech")
        @JacksonXmlCData
        private String itemSpeech;
        /**
         * 分支审批人操作时间
         */
        @JacksonXmlProperty(localName = "ItemOpTime")
        private Long itemOpTime;

    }


    /**
     * 抄送人信息
     */
    @Data
    public static class NotifyNode {
        /**
         * 抄送人姓名
         */
        @JacksonXmlProperty(localName = "ItemName")
        @JacksonXmlCData
        private String itemName;
        /**
         * 抄送人userid
         */
        @JacksonXmlProperty(localName = "ItemUserId")
        @JacksonXmlCData
        private String itemUserId;
        /**
         * 抄送人头像
         */
        @JacksonXmlProperty(localName = "ItemImage")
        @JacksonXmlCData
        private String itemImage;
    }
}
