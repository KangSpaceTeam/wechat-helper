package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import javax.annotation.Nonnull;

/**
 * 模板消息-删除模板 请求参数 <br>
 * 如:
 * <pre>
 *  {
 *      "template_id" : "Dyvp3-Ff0cnail_CDSzk1fIc6-9lOkxsQE7exTJbwUE"
 *  }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#TEMPLATE_DEL_PRIVATE_TEMPLATE
 * @since 2022/12/11
 */
@Data
public class TemplateDelPrivateTemplateRequest {
    /**
     * 公众帐号下模板消息ID
     */
    @Nonnull
    @JsonProperty("template_id")
    private String templateId;
}
