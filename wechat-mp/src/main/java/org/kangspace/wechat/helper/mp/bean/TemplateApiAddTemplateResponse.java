package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

/**
 * 模板消息-获得模板ID 响应参数<br>
 * 如:
 * <pre>
 *  {
 *     "errcode":0,
 *     "errmsg":"ok",
 *     "template_id":"Doclyl5uP7Aciu-qZ7mJNPtWkbkYnWBWVja26EGbNyk"
 *   }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#TEMPLATE_API_ADD_TEMPLATE
 * @since 2022/12/11
 */
@Data
@ToString(callSuper = true)
public class TemplateApiAddTemplateResponse extends WeChatMpResponseEntity {

    /**
     * 模板ID
     */
    @JsonProperty("template_id")
    private String templateId;
}
