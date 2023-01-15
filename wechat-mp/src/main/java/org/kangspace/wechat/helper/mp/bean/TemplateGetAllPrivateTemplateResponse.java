package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import java.util.List;

/**
 * 模板消息-获取模板列表 响应参数 <br>
 * 如:
 * <pre>
 * {
 *      "template_list": [{
 *       "template_id": "iPk5sOIt5X_flOVKn5GrTFpncEYTojx6ddbt8WYoV5s",
 *       "title": "领取奖金提醒",
 *       "primary_industry": "IT科技",
 *       "deputy_industry": "互联网|电子商务",
 *       "content": "{ {result.DATA} }\n\n领奖金额:{ {withdrawMoney.DATA} }\n领奖  时间:    { {withdrawTime.DATA} }\n银行信息:{ {cardInfo.DATA} }\n到账时间:  { {arrivedTime.DATA} }\n{ {remark.DATA} }",
 *       "example": "您已提交领奖申请\n\n领奖金额：xxxx元\n领奖时间：2013-10-10 12:22:22\n银行信息：xx银行(尾号xxxx)\n到账时间：预计xxxxxxx\n\n预计将于 xxxx 到达您的银行卡"
 *    }]
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#TEMPLATE_GET_ALL_PRIVATE_TEMPLATE
 * @since 2022/12/11
 */
@Setter
@Getter
public class TemplateGetAllPrivateTemplateResponse extends WeChatMpResponseEntity {
    /**
     * 模版列表
     */
    @JsonProperty("template_list")
    private List<Template> templateList;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "TemplateGetAllPrivateTemplateResponse{" +
                        "templateList=" + templateList +
                        "}"
        );
    }

    /**
     * 模版详情
     */
    @Data
    public static class Template {
        /**
         * 模板ID
         * 必填: 是
         */
        @JsonProperty("template_id")
        private String templateId;
        /**
         * 模板标题
         * 必填: 是
         */
        private String title;
        /**
         * 模板所属行业的一级行业
         * 必填: 是
         */
        @JsonProperty("primary_industry")
        private String primaryIndustry;
        /**
         * 模板所属行业的二级行业
         * 必填: 是
         */
        @JsonProperty("deputy_industry")
        private String deputyIndustry;
        /**
         * 模板内容
         * 必填: 是
         */
        private String content;
        /**
         * 模板示例
         * 必填: 是
         */
        private String example;
    }
}
