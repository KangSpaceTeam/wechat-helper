package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;

/**
 * 安全管理-设备管理-获取成员使用设备 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/31
 */
@Data
@Builder
public class SecurityTrustDeviceGetByUserRequest {
    /**
     * 最后登录的成员userid
     */
    @Nonnull
    @JsonProperty("last_login_userid")
    private String lastLoginUserid;
    /**
     * 查询设备类型，1-可信企业设备 2-未知设备 3-可信个人设备
     */
    @Nonnull
    @JsonProperty("type")
    private Integer type;

    public SecurityTrustDeviceGetByUserRequest(@Nonnull String lastLoginUserid, @Nonnull Integer type) {
        this.lastLoginUserid = lastLoginUserid;
        this.type = type;
    }

    public SecurityTrustDeviceGetByUserRequest() {
    }
}
