package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 素材管理-异步上传临时素材 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
@Setter
@Getter
public class MediaUploadByUrlResponse extends WeComResponseEntity {

    /**
     * 任务id。可通过此jobid查询结果
     */
    @JsonProperty("jobid")
    private String jobId;

    @Override
    public String toString() {
        return super.isError() ? super.toString() :
                ("MediaUploadByUrlResponse{" + "jobId='" + jobId + '\'' + "}");
    }

}
