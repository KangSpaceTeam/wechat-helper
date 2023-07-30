package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nonnull;

/**
 * 通讯录管理-获取下级/下游企业小程序session 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/27
 */
@Setter
@Getter
public class MiniProgramTransferSessionResponse extends WeComResponseEntity {
    /**
     * 下级/下游企业用户的ID
     */
    @Nonnull
    @JsonProperty("userid")
    private String userId;

    /**
     * 属于下级/下游企业的会话密钥
     */
    @Nonnull
    @JsonProperty("session_key")
    private String session_key;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "MiniProgramTransferSessionResponse{" +
                        "userId='" + userId + '\'' +
                        ", session_key='" + session_key + '\'' +
                        "}"
        );
    }
}
