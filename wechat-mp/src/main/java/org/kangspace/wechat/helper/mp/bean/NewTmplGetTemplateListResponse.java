package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.mp.constant.SubscriptionMessagesConstant;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import java.util.List;

/**
 * 订阅通知接口-getTemplateList获取私有模板列表响应对象<br>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#NEW_TMPL_GET_TEMPLATE
 * @since 2023/02/09
 */
@Setter
@Getter
public class NewTmplGetTemplateListResponse extends WeChatMpResponseEntity {

    /**
     * 个人模板列表
     */
    @JsonProperty("data")
    private List<Template> data;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "NewTmplGetTemplateListResponse{" +
                        "data=" + data +
                        "}"
        );
    }

    /**
     * 关键词
     */
    @Data
    public static class Template {
        /**
         * 添加至帐号下的模板 id，发送订阅通知时所需
         */
        private String priTmplId;
        /**
         * 模版标题
         */
        private String title;
        /**
         * 模版内容
         */
        private String content;
        /**
         * 模板内容示例
         */
        private String example;
        /**
         * 模版类型，2 为一次性订阅，3 为长期订阅
         */
        private SubscriptionMessagesConstant.TemplateType type;
    }
}
