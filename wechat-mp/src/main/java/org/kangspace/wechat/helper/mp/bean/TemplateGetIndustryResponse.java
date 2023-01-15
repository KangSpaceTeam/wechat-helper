package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

/**
 * 模板消息-设置所属行业 响应参数 <br>
 * 如:
 * <pre>
 * {
 *     "primary_industry":{"first_class":"运输与仓储","second_class":"快递"},
 *     "secondary_industry":{"first_class":"IT科技","second_class":"互联网|电子商务"}
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#TEMPLATE_GET_INDUSTRY
 * @since 2022/12/11
 */
@Setter
@Getter
public class TemplateGetIndustryResponse extends WeChatMpResponseEntity {
    /**
     * 帐号设置的主营行业
     */
    @JsonProperty("primary_industry")
    private Industry primaryIndustry;

    /**
     * 帐号设置的副营行业
     */
    @JsonProperty("secondary_industry")
    private Industry secondaryIndustry;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "TemplateGetIndustryResponse{" +
                        "primaryIndustry=" + primaryIndustry +
                        ", secondaryIndustry=" + secondaryIndustry +
                        "}"
        );
    }

    /**
     * 行业详情
     */
    @Data
    public static class Industry {
        /**
         * 主行业
         */
        @JsonProperty("first_class")
        private String firstClass;

        /**
         * 副行业
         */
        @JsonProperty("second_class")
        private String secondClass;
    }

}
