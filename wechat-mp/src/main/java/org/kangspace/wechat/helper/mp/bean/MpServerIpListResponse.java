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
 * 	 "ip_list": [
 * 		"106.55.206.146",
 * 		"106.55.206.211",
 * 		"106.55.207.148"
 * 	  ]
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@Data
@ToString(callSuper = true)
public class MpServerIpListResponse extends WeChatMpResponseEntity {

    /**
     * 服务器Ip列表
     */
    @JsonProperty("ip_list")
    private List<String> ipList;

}
