package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 获取公众号已创建的标签 响应
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/7
 */
@Setter
@Getter
public class UserTagsGetResponse extends WeChatMpResponseEntity {
    /**
     * 标签信息
     */
    @JsonProperty("tags")
    private List<Tag> tags;

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
        /**
         * 此标签下粉丝数
         */
        private Integer count;
    }

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "UserTagsGetResponse{" +
                        "tags=" + tags +
                        "}"
        );
    }
}
