package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 获取标签下粉丝列表 响应
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/7
 */
@Setter
@Getter
public class UserTagGetResponse extends WeChatMpResponseEntity {
    /**
     * 这次获取的粉丝数量
     */
    @JsonProperty("count")
    private Integer count;
    /**
     * 粉丝列表
     */
    @JsonProperty("data")
    private UserData data;
    /**
     * 拉取列表最后一个用户的openid
     */
    @JsonProperty("next_openid")
    private String nextOpenId;

    @Data
    public static class UserData {
        /**
         * //粉丝列表
         */
        @JsonProperty("openid")
        List<String> openIds;
    }

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "UserTagGetResponse{" +
                        "count=" + count +
                        ", data=" + data +
                        ", nextOpenId='" + nextOpenId + '\'' +
                        "}"
        );
    }
}
