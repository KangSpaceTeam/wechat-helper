package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;

/**
 * 企业互联-获取下级/下游企业的access_token 请求对象<br>
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
@Data
@AllArgsConstructor
@Builder
public class CorpGroupCorpGetTokenRequest {

    /**
     * 已授权的下级/下游企业corpid
     */
    @Nonnull
    @JsonProperty("corpid")
    private String corpId;

    /**
     * 已授权的下级/下游企业应用ID
     */
    @Nonnull
    @JsonProperty("agentId")
    private String agentId;

    /**
     * 填0则为企业互联/局校互联，填1则表示上下游企业
     */
    @JsonProperty("business_type")
    private String businessType;

    public CorpGroupCorpGetTokenRequest() {
    }
}
