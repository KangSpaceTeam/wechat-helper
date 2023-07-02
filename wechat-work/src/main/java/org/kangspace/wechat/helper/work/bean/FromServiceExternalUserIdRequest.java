package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.annotation.Nonnull;

/**
 * 帐号ID 接口-自建应用与第三方应用的对接-external_userid转换 请求参数
 * <pre>
 * 如:
 * {
 *   "external_userid":"aaa",
 *   "source_agentid":100001
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/2
 */
@Data
@ToString(callSuper = true)
public class FromServiceExternalUserIdRequest {
    /**
     * 企业授权的代开发自建应用或第三方应用的agentid
     * 必填
     */
    @Nonnull
    @JsonProperty("source_agentid")
    private Long sourceAgentId;

    /**
     * 服务商主体的external_userid，必须是source_agentid对应的应用所获取
     * 必填
     */
    @Nonnull
    @JsonProperty("external_userid")
    private String externalUserId;

    public FromServiceExternalUserIdRequest() {
    }

    public FromServiceExternalUserIdRequest(@Nonnull Long sourceAgentId, @Nonnull String externalUserId) {
        this.sourceAgentId = sourceAgentId;
        this.externalUserId = externalUserId;
    }
}
