package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import java.util.List;

/**
 * 订阅通知接口-getPubTemplateKeyWordsById获取模板中的关键词响应对象<br>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#NEW_TMPL_GET_PUB_TEMPLATE_KEYWORDS
 * @since 2023/02/09
 */
@Setter
@Getter
public class NewTmplGetPubTemplateKeyWordsResponse extends WeChatMpResponseEntity {

    /**
     * 公共模板列表总数
     */
    private Long count;

    /**
     * 关键词列表
     */
    @JsonProperty("data")
    private List<KeyWord> data;

    /**
     * 关键词
     */
    @Data
    public static class KeyWord {
        /**
         * 关键词 id，选用模板时需要
         */
        private Long kid;
        /**
         * 关键词内容
         */
        private String name;
        /**
         * 关键词内容对应的示例
         */
        private String example;
        /**
         * 参数类型
         */
        private String rule;
    }

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "NewTmplGetPubTemplateKeyWordsResponse{" +
                        "count=" + count +
                        ", data=" + data +
                        "}"
        );
    }
}
