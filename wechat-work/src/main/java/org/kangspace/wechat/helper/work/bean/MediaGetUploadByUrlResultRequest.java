package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;

/**
 * 素材管理-查询异步任务结果 请求对象<br>
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/9/8
 */
@Data
@Builder
public class MediaGetUploadByUrlResultRequest {
    /**
     * 任务id。可通过此jobid查询结果
     */
    @Nonnull
    @JsonProperty("jobid")
    private String jobId;

    public MediaGetUploadByUrlResultRequest(@Nonnull String jobId) {
        this.jobId = jobId;
    }
}
