package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kangspace.wechat.helper.mp.constant.MessageConstant;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import javax.annotation.Nonnull;

/**
 * 模板消息-设置所属行业 请求参数<br>
 * 如:
 * <pre>
 * {
 *     "industry_id1":"1",
 *     "industry_id2":"4"
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#TEMPLATE_API_SET_INDUSTRY
 * @since 2022/12/11
 */
@Data
public class TemplateApiSetIndustryRequest {
    /**
     * 公众号模板消息所属行业编号
     */
    @Nonnull
    @JsonProperty("industry_id1")
    private MessageConstant.Industry industryId1;

    /**
     * 公众号模板消息所属行业编号
     */
    @Nonnull
    @JsonProperty("industry_id2")
    private MessageConstant.Industry industryId2;

    public TemplateApiSetIndustryRequest() {
    }

    public TemplateApiSetIndustryRequest(@Nonnull MessageConstant.Industry industryId1, @Nonnull MessageConstant.Industry industryId2) {
        this.industryId1 = industryId1;
        this.industryId2 = industryId2;
    }
}
