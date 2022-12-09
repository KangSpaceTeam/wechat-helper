package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 微信服务器Ip列表响应对象
 * <pre>
 * 如:
 * {
 *     "dns": [
 *         {
 *             "ip": "111.161.64.40",
 *             "real_operator": "UNICOM"
 *         },
 *         {
 *             "ip": "111.161.64.48",
 *             "real_operator": "UNICOM"
 *         }
 *     ],
 *     "ping": [
 *         {
 *             "ip": "111.161.64.40",
 *             "from_operator": "UNICOM",
 *
 *
 *             "package_loss": "0%",
 *             "time": "23.079ms"
 *         },
 *         {
 *             "ip": "111.161.64.48",
 *             "from_operator": "UNICOM",
 *             "package_loss": "0%",
 *             "time": "21.434ms"
 *         }
 *     ]
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@Data
@ToString(callSuper = true)
public class CallbackCheckResponse extends WeChatMpResponseEntity {

    /**
     * dns结果列表
     */
    private List<Dns> dns;
    /**
     * ping结果列表
     */
    private List<Ping> ping;


    @Data
    public static class Dns {
        /**
         * 解析出来的ip
         */
        private String ip;

        /**
         * ip对应的运营商
         */
        @JsonProperty("real_operator")
        private String realOperator;
    }


    @Data
    public static class Ping {
        /**
         * ping的ip，执行命令为ping ip –c 1-w 1 -q
         */
        private String ip;
        /**
         * ping的源头的运营商，由请求中的check_operator控制
         */
        @JsonProperty("from_operator")
        private String fromOperator;
        /**
         * ping的丢包率，0%表示无丢包，100%表示全部丢包。
         * 因为目前仅发送一个 ping 包，因此取值仅有0%或者100%两种可能。
         */
        @JsonProperty("package_loss")
        private String packageLoss;
        /**
         * ping的耗时，取 ping 结果的 avg 耗时。
         */
        private String time;
    }
}
