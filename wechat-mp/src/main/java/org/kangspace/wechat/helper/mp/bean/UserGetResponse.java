package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 用户管理-获取用户列表 响应
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/9
 */
@Setter
@Getter
public class UserGetResponse extends WeChatMpResponseEntity {

    /**
     * 关注该公众账号的总用户数
     */
    @JsonProperty("total")
    private Long total;

    /**
     * 拉取的OPENID个数，最大值为10000
     */
    @JsonProperty("count")
    private Integer count;

    /**
     * 拉取列表的最后一个用户的OPENID
     */
    @JsonProperty("next_openid")
    private String nextOpenId;

    /**
     * 列表数据，OPENID的列表
     */
    @JsonProperty("data")
    private OpenIdData data;

    @Data
    private static class OpenIdData {
        /**
         * 列表数据，OPENID的列表
         */
        @JsonProperty("openid")
        private List<String> openIds;
    }


    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "UserGetResponse{" +
                        "total=" + total +
                        ", count=" + count +
                        ", nextOpenId='" + nextOpenId + '\'' +
                        ", data=" + data +
                        "}"
        );
    }
}
