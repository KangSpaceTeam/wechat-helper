package org.kangspace.wechat.helper.work.bean.agent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.annotation.Nonnull;

/**
 * 应用管理-设置应用在工作台展示的模版 请求对象<br>
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/19
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class AgentSetWorkbenchTemplateRequest {

    /**
     * 应用id
     */
    @Nonnull
    @JsonProperty("agentid")
    private Integer agentId;

    /**
     * 是否覆盖用户工作台的数据。设置为true的时候，会覆盖企业所有用户当前设置的数据。若设置为false,则不会覆盖用户当前设置的所有数据。默认为false
     */
    @JsonProperty("replace_user_data")
    private Boolean replaceUserData;
}
