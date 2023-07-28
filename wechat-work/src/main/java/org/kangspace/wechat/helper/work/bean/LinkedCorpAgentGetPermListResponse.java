package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 通讯录管理-互联企业-获取应用的可见范围 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/27
 */
@Setter
@Getter
public class LinkedCorpAgentGetPermListResponse extends WeComResponseEntity {
    /**
     * 可见的userids，是用 CorpId + ’/‘ + USERID 拼成的字符串
     */
    @JsonProperty("userids")
    private List<String> userIds;

    /**
     * 可见的department_ids，是用 linkedid + ’/‘ + department_id 拼成的字符串
     */
    @JsonProperty("department_ids")
    private List<String> departmentIds;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "LinkedCorpAgentGetPermListResponse{" +
                        "userIds=" + userIds +
                        ", departmentIds=" + departmentIds +
                        "}"
        );
    }
}
