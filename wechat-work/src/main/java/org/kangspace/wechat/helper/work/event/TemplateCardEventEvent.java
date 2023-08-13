package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * 模板卡片事件推送 <br>
 * 接口文档:
 * <a href="https://developer.work.weixin.qq.com/document/path/90240">https://developer.work.weixin.qq.com/document/path/90240</a> <br>
 * <p>
 * 应用下发的模板卡片消息，用户点击按钮之后触发此事件<br>
 * 应用收到该事件之后，可以响应回复模板卡片更新消息<br>
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TemplateCardEventEvent extends WeComXmlEvent {
    public static final String EVENT = "template_card_event";

    /**
     * 与发送模板卡片消息时指定的task_id相同
     */
    @JacksonXmlProperty(localName = "TaskId")
    @JacksonXmlCData
    private String taskId;
    /**
     * 通用模板卡片的类型，类型有"text_notice", "news_notice", "button_interaction", "vote_interaction", "multiple_interaction"五种
     */
    @JacksonXmlProperty(localName = "CardType")
    @JacksonXmlCData
    private String cardType;
    /**
     * 用于调用更新卡片接口的ResponseCode，72小时内有效，且只能使用一次
     */
    @JacksonXmlProperty(localName = "ResponseCode")
    @JacksonXmlCData
    private String responseCode;

    /**
     *
     */
    @JacksonXmlElementWrapper(localName = "SelectedItems")
    @JacksonXmlProperty(localName = "SelectedItem")
    private List<SelectedItem> selectedItems;

    @Data
    public static class SelectedItem {
        /**
         * 问题的key值
         */
        @JacksonXmlProperty(localName = "QuestionKey")
        private String questionKey;
        /**
         * 对应问题的选项列表
         */
        @JacksonXmlElementWrapper(localName = "OptionIds")
        @JacksonXmlProperty(localName = "OptionId")
        private List<String> optionIds;
    }

}
