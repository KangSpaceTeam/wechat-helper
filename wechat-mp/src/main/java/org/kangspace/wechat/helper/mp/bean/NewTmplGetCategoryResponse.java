package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import java.util.List;

/**
 * 订阅通知接口-getCategory获取公众号类目响应对象<br>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#NEW_TMPL_GET_CATEGORY
 * @since 2023/02/09
 */
@Setter
@Getter
public class NewTmplGetCategoryResponse extends WeChatMpResponseEntity {
    /**
     * 类目列表
     */
    @JsonProperty("data")
    private List<Category> data;

    /**
     * 类目对象
     */
    @Data
    public static class Category {
        /**
         * 类目id，查询公共模板库时需要
         */
        private Long id;
        /**
         * string	类目的中文名
         */
        private String name;
    }

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "NewTmplGetCategoryResponse{" +
                        "data=" + data +
                        "}"
        );
    }
}
