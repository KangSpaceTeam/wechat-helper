package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 微信公众号OpenApi: 查询 rid 信息响应
 * <pre>
 * 示例:
 * {"errcode":0,
 *   "errmsg":"ok",
 *   "request":{
 *       "invoke_time":1635156704,
 *       "cost_in_ms":30,
 *       "request_url":"access_token=50_Im7xxxx",
 *       "request_body":"",
 *       "response_body":"{\"errcode\":45009,\"errmsg\":\"reach max api daily quota limit rid: 617682e0-09059ac5-34a8e2ea\"}",
 *       "client_ip": "113.xx.70.51"
 *   }
 * }
 *
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/4
 */
@Data
public class MpOpenApiRidGetResponse {
    /**
     * 该 rid 对应的请求详情
     */
    @JsonProperty("request")
    private Request request;

    @Data
    public static class Request {
        /**
         * 发起请求的时间戳
         */
        @JsonProperty("invoke_time")
        private String invokeTime;
        /**
         * 请求毫秒级耗时
         */
        @JsonProperty("cost_in_ms")
        private String costInMs;
        /**
         * 请求的 URL 参数
         */
        @JsonProperty("request_url")
        private String requestUrl;
        /**
         * post请求的请求参数
         */
        @JsonProperty("request_body")
        private String requestBody;
        /**
         * 接口请求返回参数
         */
        @JsonProperty("response_body")
        private String responseBody;
        /**
         * 接口请求的客户端ip
         */
        @JsonProperty("client_ip")
        private String clientIp;
    }

}
