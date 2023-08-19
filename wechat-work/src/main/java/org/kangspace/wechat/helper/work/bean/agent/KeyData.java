package org.kangspace.wechat.helper.work.bean.agent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 应用管理-模版类型数据结构-关键数据型 对象<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KeyData {

    @JsonProperty("items")
    private List<Item> items;

    @Data
    @Builder
    public static class Item {
        /**
         * 关键数据名称，需要设置在模版中
         */
        @JsonProperty("key")
        private String key;
        /**
         * 关键数据
         */
        @Nonnull
        @JsonProperty("data")
        private String data;
        /**
         * 点击跳转url，若不填且应用设置了主页url，则跳转到主页url，否则跳到应用会话窗口
         */
        @JsonProperty("jump_url")
        private String jumpUrl;
        /**
         * 若应用为小程序类型，该字段填小程序pagepath，若未设置，跳到小程序主页
         */
        @JsonProperty("pagepath")
        private String pagePath;
    }
}
