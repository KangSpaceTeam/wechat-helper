package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 安全管理-文件防泄漏 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/31
 */
@Data
@Builder
public class SecurityGetFileOperRecordRequest {
    /**
     * 开始时间
     */
    @Nonnull
    @JsonProperty("start_time")
    private Integer startTime;
    /**
     * 结束时间，开始时间到结束时间的范围不能超过14天
     */
    @Nonnull
    @JsonProperty("end_time")
    private Integer endTime;
    /**
     * 需要查询的文件操作者的userid，单次最多可以传100个用户
     */
    @JsonProperty("userid_list")
    private List<String> useridList;
    /**
     * 参考Operation结构说明
     */
    @JsonProperty("operation")
    private SecurityOperation operation;
    /**
     * 由企业微信后台返回，第一次调用可不填
     */
    @JsonProperty("cursor")
    private String cursor;
    /**
     * 限制返回的条数，最多设置为1000
     */
    @JsonProperty("limit")
    private Integer limit;
}
