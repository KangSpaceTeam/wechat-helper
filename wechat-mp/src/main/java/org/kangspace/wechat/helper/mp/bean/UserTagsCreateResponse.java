package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 创建用户标签 响应
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/7
 */
@Setter
@Getter
public class UserTagsCreateResponse extends WeChatMpResponseEntity {
    /**
     * 标签信息
     */
    @JsonProperty("tag")
    private Tag tag;

    @Data
    public static class Tag {
        /**
         * 标签id，由微信分配
         */
        private Long id;
        /**
         * 标签名，UTF8编码
         */
        private String name;
    }

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "UserTagsCreateResponse{" +
                        "tag=" + tag +
                        "}"
        );
    }
}
