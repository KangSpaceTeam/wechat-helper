package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

/**
 * 微信公众号OpenApi: 查询 openAPI 调用quota响应
 * <pre>
 * 示例:
 * {
 *   "errcode": 0,
 *   "errmsg": "ok",
 *   "quota":{
 *     "daily_limit": 0,
 *     "used": 0,
 *     "remain": 0}
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/4
 */
@Data
@ToString(callSuper = true)
public class MpOpenApiQuotaGetResponse extends WeChatMpResponseEntity {
    @JsonProperty("quota")
    private Quota quota;

    @Data
    public static class Quota {
        /**
         * 当天该账号可调用该接口的次数
         */
        @JsonProperty("daily_limit")
        private Integer dailyLimit;

        /**
         * 当天已经调用的次数
         */
        @JsonProperty("used")
        private Integer used;

        /**
         * 当天剩余调用次数
         */
        @JsonProperty("remain")
        private Integer remain;
    }
}
