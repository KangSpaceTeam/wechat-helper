package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 微信公众号获得jsapi_ticket响应
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/11 17:55:40
 */
@Setter
@Getter
@ToString
public class WebAppsJsApiSignResponse {

    /**
     * 有效的jsapi_ticket
     */
    @JsonProperty("jsapi_ticket")
    private String jsapiTicket;

    /**
     * 当前网页的URL，不包含#及其后面部分
     */
    @JsonProperty("url")
    private String url;

    /**
     * 随机字符串
     */
    @JsonProperty("noncestr")
    private String nonceStr;

    /**
     * 时间戳(Unix)
     */
    @JsonProperty("timestamp")
    private String timestamp;

    /**
     * 签名
     */
    @JsonProperty("sign")
    private String sign;

    public WebAppsJsApiSignResponse() {
    }

    public WebAppsJsApiSignResponse(String jsapiTicket, String url, String nonceStr, String timestamp, String sign) {
        this.jsapiTicket = jsapiTicket;
        this.url = url;
        this.nonceStr = nonceStr;
        this.timestamp = timestamp;
        this.sign = sign;
    }
}
