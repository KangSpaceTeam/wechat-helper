package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.mp.constant.SubscriptionMessagesConstant;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import java.util.List;

/**
 * 订阅通知接口-getPubTemplateTitleList获取类目下的公共模板响应对象<br>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#NEW_TMPL_GET_PUB_TEMPLATE_TITLES
 * @since 2023/02/09
 */
@Setter
@Getter
public class NewTmplGetPubTemplateTitlesResponse extends WeChatMpResponseEntity {

    /**
     * 公共模板列表总数
     */
    private Long count;

    /**
     * 模板标题列表
     */
    @JsonProperty("data")
    private List<Title> data;

    /**
     * 关键词
     */
    @Data
    public static class Title {
        /**
         * 模版标题 id
         */
        private Long tid;
        /**
         * 模版标题
         */
        private String title;
        /**
         * 模版类型，2 为一次性订阅，3 为长期订阅
         */
        private SubscriptionMessagesConstant.TemplateType type;
        /**
         * 模版所属类目 id
         */
        private Long categoryId;
    }

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "NewTmplGetPubTemplateTitlesResponse{" +
                        "count=" + count +
                        ", data=" + data +
                        "}"
        );
    }
}
