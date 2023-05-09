package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 黑名单管理-获取公众号的黑名单列表 请求参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/9
 */
@NoArgsConstructor
@Data
public class UserTagsMembersGetBlackListRequest {
    /**
     * 当 begin_openid 为空时，默认从开头拉取。
     */
    @JsonProperty("begin_openid")
    private String beginOpenId;

    public UserTagsMembersGetBlackListRequest(String beginOpenId) {
        this.beginOpenId = beginOpenId;
    }
}
