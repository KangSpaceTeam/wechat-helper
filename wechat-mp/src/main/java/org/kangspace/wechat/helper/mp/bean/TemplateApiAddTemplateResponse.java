package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
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
@Setter
@Getter
public class TemplateApiAddTemplateResponse extends WeChatMpResponseEntity {

    /**
     * 模板ID
     */
    @JsonProperty("template_id")
    private String templateId;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "TemplateApiAddTemplateResponse{" +
                        "templateId='" + templateId + '\'' +
                        "}"
        );
    }
}
