package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 企业微信服务器Ip列表响应对象
 * <pre>
 * 如:
 * {
 * 	 "ip_list": [
 * 		"106.55.206.146",
 * 		"106.55.206.211",
 * 		"106.55.207.148"
 * 	  ]
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/6/26
 */
@Setter
@Getter
public class ServerIpListResponse extends WeComResponseEntity {

    /**
     * 服务器Ip列表
     */
    @JsonProperty("ip_list")
    private List<String> ipList;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "ServerIpListResponse{" +
                        "ipList=" + ipList +
                        "}"
        );
    }
}
