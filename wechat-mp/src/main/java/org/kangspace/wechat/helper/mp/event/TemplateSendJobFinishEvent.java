package org.kangspace.wechat.helper.mp.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static org.kangspace.wechat.helper.core.constant.WeChatConstant.SUCCESS_FLAG;

/**
 * 模板消息发送成功事件 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html#5">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html#5</a>
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/016
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TemplateSendJobFinishEvent extends WeChatMpXmlEvent {

    /**
     * 发送状态
     */
    @JacksonXmlProperty(localName = "Status")
    @JacksonXmlCData
    private String status;


    /**
     * 是否发送成功
     *
     * @return boolean
     */
    public boolean isSuccess() {
        return SUCCESS_FLAG.equals(status);
    }
}
