package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;

/**
 * 用户管理-设置用户备注名 请求参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/8
 */
@NoArgsConstructor
@Data
public class UserInfoUpdateRemarkRequest {
    /**
     * 用户OpenId
     */
    @Nonnull
    @JsonProperty("openid")
    private String openId;

    /**
     * 新的备注名，长度必须小于30字节
     */
    @Nonnull
    @JsonProperty("remark")
    private String remark;

    public UserInfoUpdateRemarkRequest(@Nonnull String openId, @Nonnull String remark) {
        this.openId = openId;
        this.remark = remark;
    }
}
