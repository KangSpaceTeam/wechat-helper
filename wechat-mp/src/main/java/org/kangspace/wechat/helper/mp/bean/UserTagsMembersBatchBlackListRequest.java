package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

/**
 * 黑名单管理-拉黑用户 请求参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/9
 */
@NoArgsConstructor
@Data
public class UserTagsMembersBatchBlackListRequest {
    /**
     * 需要拉入黑名单的用户的openid，一次拉黑最多允许20个
     */
    @JsonProperty("openid_list")
    private List<String> openIdList;

    public UserTagsMembersBatchBlackListRequest(String... openIdList) {
        this.openIdList = Arrays.asList(openIdList);
    }

    public UserTagsMembersBatchBlackListRequest(List<String> openIdList) {
        this.openIdList = openIdList;
    }
}
