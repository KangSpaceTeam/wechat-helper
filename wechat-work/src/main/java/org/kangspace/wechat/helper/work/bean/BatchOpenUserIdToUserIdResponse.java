package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 帐号ID 接口-自建应用与第三方应用的对接-userid转换 响应参数
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/2
 */
@Getter
@Setter
public class BatchOpenUserIdToUserIdResponse extends WeComResponseEntity{
    /**
     * 明文userid
     */
    @JsonProperty("userid_list")
    private UserId userIdList;

    /**
     * 不合法的open_userid列表
     */
    @JsonProperty("invalid_open_userid_list")
    private List<String> invalidOpenUserIdList;


    public BatchOpenUserIdToUserIdResponse() {
    }

    public BatchOpenUserIdToUserIdResponse(UserId userIdList, List<String> invalidOpenUserIdList) {
        this.userIdList = userIdList;
        this.invalidOpenUserIdList = invalidOpenUserIdList;
    }

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "BatchOpenUserIdToUserIdResponse{" +
                        "userIdList=" + userIdList +
                        ", invalidOpenUserIdList=" + invalidOpenUserIdList +
                        "}"
        );
    }

    @Data
    public static class UserId {
        /**
         * 转换成功的open_userid
         */
        @JsonProperty("open_userid")
        private String openUserId;
        /**
         * 转换成功的open_userid对应的userid
         */
        @JsonProperty("userid")
        private String userId;

        public UserId() {
        }

        public UserId(String openUserId, String userId) {
            this.openUserId = openUserId;
            this.userId = userId;
        }
    }

}
