package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 帐号ID 接口-自建应用与第三方应用的对接-userid转换 请求参数
 * <pre>
 * 如:
 * {
 *   "open_userid_list":["xxx", "yyy"],
 *   "source_agentid":100001
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/2
 */
@Data
@ToString(callSuper = true)
public class BatchOpenUserIdToUserIdRequest {
    /**
     * 企业授权的代开发自建应用或第三方应用的agentid
     * 必填
     */
    @Nonnull
    @JsonProperty("source_agentid")
    private Long sourceAgentId;

    /**
     * open_userid列表，最多不超过1000个。必须是source_agentid对应的应用所获取
     * 必填
     */
    @Nonnull
    @JsonProperty("open_userid_list")
    private List<String> openUserIdList;


    public BatchOpenUserIdToUserIdRequest() {
    }

    public BatchOpenUserIdToUserIdRequest(@Nonnull Long sourceAgentId, @Nonnull List<String> openUserIdList) {
        this.sourceAgentId = sourceAgentId;
        this.openUserIdList = openUserIdList;
    }
}
