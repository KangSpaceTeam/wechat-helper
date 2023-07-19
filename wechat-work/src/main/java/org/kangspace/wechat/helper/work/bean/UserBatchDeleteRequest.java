package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

/**
 * 企业微信通讯录管理-成员管理-批量删除成员
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/19
 */
@Data
public class UserBatchDeleteRequest {
    @Nonnull
    @JsonProperty("useridlist")
    private List<String> userIdList;

    public UserBatchDeleteRequest(@Nonnull List<String> userIdList) {
        this.userIdList = userIdList;
    }

    public UserBatchDeleteRequest(@Nonnull String... userIdList) {
        this.userIdList = Arrays.asList(userIdList);
    }

    public UserBatchDeleteRequest() {
    }
}
