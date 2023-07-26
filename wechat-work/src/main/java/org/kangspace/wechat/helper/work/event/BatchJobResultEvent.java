package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Arrays;
import java.util.Objects;

/**
 * 通讯录回调通知-异步任务完成通知 <br>
 * 接口文档:
 * <a href="https://developer.work.weixin.qq.com/document/path/90973">https://developer.work.weixin.qq.com/document/path/90973</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/26
 */
@Data
@ToString(callSuper = true)
public class BatchJobResultEvent extends WeComXmlEvent {
    public static final String EVENT = "batch_job_result";

    @JacksonXmlProperty(localName = "BatchJob")
    private BatchJob batchJob;

    @Data
    public static class BatchJob {

        /**
         * 异步任务id，最大长度为64字符
         */
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "JobId")
        private String jobId;
        /**
         * 操作类型，字符串，目前分别有：sync_user(增量更新成员)、 replace_user(全量覆盖成员）、invite_user(邀请成员关注）、replace_party(全量覆盖部门)
         */
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "JobType")
        private String jobType;
        /**
         * 返回码
         */
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "ErrCode")
        private String errCode;
        /**
         * 对返回码的文本描述内容
         */
        @JacksonXmlCData
        @JacksonXmlProperty(localName = "ErrMsg")
        private String errMsg;

    }

    public enum JobType {
        /**
         * 增量更新成员
         */
        SYNC_USER,
        /**
         * 全量覆盖成员
         */
        REPLACE_USER,
        /**
         * 邀请成员关注
         */
        INVITE_USER,
        /**
         * 全量覆盖部门
         */
        REPLACE_PARTY,
        ;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }

        @JsonValue
        public String getJobType() {
            return toString();
        }

        @JsonCreator
        public JobType parse(String jobType) {
            return Arrays.stream(values()).filter(t -> Objects.equals(t.getJobType(), jobType)).findFirst().orElse(null);
        }
    }
}
