package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import javax.annotation.Nonnull;

/**
 * 模板消息-获得模板ID 请求参数<br>
 * 如:
 * <pre>
 * {
 *     "template_id_short":"TM00015"
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#TEMPLATE_API_ADD_TEMPLATE
 * @since 2022/12/11
 */
@Data
public class TemplateApiAddTemplateRequest {
    /**
     * 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
     */
    @Nonnull
    @JsonProperty("template_id_short")
    private String templateIdShort;

    public TemplateApiAddTemplateRequest() {
    }

    public TemplateApiAddTemplateRequest(@Nonnull String templateIdShort) {
        this.templateIdShort = templateIdShort;
    }
}
