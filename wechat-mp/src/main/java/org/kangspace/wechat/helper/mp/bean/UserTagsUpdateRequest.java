package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;

/**
 * 创建/更新用户标签 请求参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/7
 */
@NoArgsConstructor
@Data
public class UserTagsUpdateRequest {
    /**
     * 标签内容
     */
    @Nonnull
    @JsonProperty("tag")
    private Tag tag;

    @Data
    public static class Tag {
        /**
         * 标签id，由微信分配
         */
        private Long id;
        /**
         * 标签名（30个字符以内）
         */
        @Nonnull
        private String name;

        public Tag(@Nonnull Long id) {
            this.id = id;
        }

        public Tag(@Nonnull String name) {
            this.name = name;
        }

        public Tag(@Nonnull Long id, @Nonnull String name) {
            this.id = id;
            this.name = name;
        }
    }

    public UserTagsUpdateRequest(@Nonnull Tag tag) {
        this.tag = tag;
    }
}
