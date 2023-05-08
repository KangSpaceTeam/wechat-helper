package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 用户管理-批量获取用户基本信息 响应
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/8
 */
@Setter
@Getter
public class UserInfoBatchGetResponse extends WeChatMpResponseEntity {
    /**
     * 用户信息列表
     */
    @JsonProperty("user_info_list")
    private List<UserInfoResponse> userInfoList;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "UserInfoBatchGetResponse{" +
                        "userInfoList=" + userInfoList +
                        "}"
        );
    }
}
