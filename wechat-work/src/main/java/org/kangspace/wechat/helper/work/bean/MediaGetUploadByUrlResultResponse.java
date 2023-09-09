package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 素材管理-查询异步任务结果 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/9/8
 */
@Setter
@Getter
public class MediaGetUploadByUrlResultResponse extends WeComResponseEntity {

    /**
     * 任务状态。1-处理中，2-完成，3-异常失败
     */
    @JsonProperty("status")
    private Integer status;

    /**
     * 结果明细
     */
    @JsonProperty("detail")
    private Detail detail;

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Detail extends WeComResponseEntity {
        /**
         * 媒体文件上传后获取的唯一标识，3天内有效。当status为2时返回。
         */
        @JsonProperty("media_id")
        private String mediaId;

        /**
         * 媒体文件创建的时间戳。当status为2时返回。
         */
        @JsonProperty("created_at")
        private Long createdAt;

        @Override
        public String toString() {
            return super.isError() ? super.toString() : (
                    "Detail{" +
                            "mediaId='" + mediaId + '\'' +
                            ", createdAt=" + createdAt +
                            "}"
            );
        }
    }

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "MediaGetUploadByUrlResultResponse{" +
                        "status=" + status +
                        ", detail=" + detail +
                        "}"
        );
    }
}
