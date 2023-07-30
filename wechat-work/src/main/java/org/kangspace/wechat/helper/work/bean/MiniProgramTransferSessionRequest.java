package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;

/**
 * 企业互联-获取下级/下游企业小程序session 请求对象<br>
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
@Data
@Builder
public class MiniProgramTransferSessionRequest {
    /**
     * 通过code2Session接口获取到的加密的userid,不多于64字节
     */
    @Nonnull
    @JsonProperty("userid")
    private String userId;

    /**
     * 通过code2Session接口获取到的属于上级/上游企业的会话密钥-不多于64字节
     */
    @Nonnull
    @JsonProperty("session_key")
    private String session_key;

    public MiniProgramTransferSessionRequest() {
    }

    public MiniProgramTransferSessionRequest(@Nonnull String userId, @Nonnull String session_key) {
        this.userId = userId;
        this.session_key = session_key;
    }
}
