package org.kangspace.wechat.helper.work.bean.agent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.annotation.Nonnull;

/**
 * 应用管理-设置应用在用户工作台展示的数据 请求对象<br>
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/19
 */
@Data
@SuperBuilder
public abstract class AgentSetWorkbenchDataRequest {
    /**
     * 应用id
     */
    @Nonnull
    @JsonProperty("agentid")
    private Integer agentId;
    /**
     * 需要设置的用户的userid
     */
    @Nonnull
    @JsonProperty("userid")
    private String userId;

}
