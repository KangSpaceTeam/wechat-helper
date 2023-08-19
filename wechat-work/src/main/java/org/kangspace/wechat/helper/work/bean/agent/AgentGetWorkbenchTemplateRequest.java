package org.kangspace.wechat.helper.work.bean.agent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;

/**
 * 应用管理-获取应用在工作台展示的模版 请求对象<br>
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentGetWorkbenchTemplateRequest {
    /**
     * 应用id
     */
    @Nonnull
    @JsonProperty("agentid")
    private Integer agentId;
}
