package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 邀请成员 响应对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/20
 */
@Setter
@Getter
public class BatchInviteResponse extends WeComResponseEntity {

    /**
     * 非法成员列表
     */
    @JsonProperty("invaliduser")
    private List<String> invalidUser;
    /**
     * 非法部门列表
     */
    @JsonProperty("invalidparty")
    private List<Long> invalidParty;
    /**
     * 非法标签列表。
     */
    @JsonProperty("invalidtag")
    private List<String> invalidTag;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "BatchInviteResponse{" +
                        "invalidUser=" + invalidUser +
                        ", invalidParty=" + invalidParty +
                        ", invalidTag=" + invalidTag +
                        "}"
        );
    }
}
