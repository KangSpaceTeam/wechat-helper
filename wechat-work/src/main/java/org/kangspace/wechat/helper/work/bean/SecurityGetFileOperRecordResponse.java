package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 安全管理-文件防泄漏 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/31
 */
@Setter
@Getter
public class SecurityGetFileOperRecordResponse extends WeComResponseEntity {
    /**
     * 是否还有更多数据
     */
    @JsonProperty("has_more")
    private Boolean hasMore;

    /**
     * 仅has_more值为true时返回该字段，下一次调用将该值填到cursor字段，以实现分页查询
     */
    @JsonProperty("next_cursor")
    private String nextCursor;

    /**
     * 仅has_more值为true时返回该字段，下一次调用将该值填到cursor字段，以实现分页查询
     */
    @JsonProperty("record_list")
    private Record recordList;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "SecurityGetFileOperRecordResponse{" +
                        "hasMore=" + hasMore +
                        ", nextCursor='" + nextCursor + '\'' +
                        ", recordList=" + recordList +
                        "}"
        );
    }

    @Data
    public static class Record {
        /**
         * 操作时间
         */
        @JsonProperty("time")
        private Integer time;
        /**
         * 企业用户账号id，当操作者为企业内部用户时返回该字段
         */
        @JsonProperty("userid")
        private String userId;
        /**
         * 企业外部人员帐号信息，参考ExternalUser结构说明，当操作者为企业外部用户时返回该结构
         */
        @JsonProperty("external_user")
        private String externalUser;
        /**
         * 参考Operation结构说明
         */
        @JsonProperty("operation")
        private SecurityOperation operation;
        /**
         * 文件操作说明
         */
        @JsonProperty("file_info")
        private String fileInfo;
    }
}
