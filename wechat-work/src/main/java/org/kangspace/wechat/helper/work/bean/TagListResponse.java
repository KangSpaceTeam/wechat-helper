package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 企业微信"通讯录管理-标签管理"-获取标签列表 响应对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/22
 */
@Setter
@Getter
public class TagListResponse extends WeComResponseEntity {

    /**
     * 标签列表
     */
    @JsonProperty("taglist")
    private List<Tag> tagList;

    @Data
    public static class Tag {
        /**
         * 标签名
         */
        @JsonProperty("tagid")
        private Long tagId;
        /**
         * 标签名
         */
        @JsonProperty("tagname")
        private String tagName;
    }

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "TagListResponse{" +
                        "tagList=" + tagList +
                        "}"
        );
    }
}
