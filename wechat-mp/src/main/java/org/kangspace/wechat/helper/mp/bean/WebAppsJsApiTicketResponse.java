package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 微信公众号获得jsapi_ticket响应
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/11 17:55:40
 */
@Setter
@Getter
public class WebAppsJsApiTicketResponse extends WeChatMpResponseEntity {
    /**
     * ticket
     */
    @JsonProperty("ticket")
    private String ticket;

    /**
     * 超时时间,单位s,默认: 2小时
     */
    @JsonProperty("expires_in")
    private Long expiresIn;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "WebAppsJsApiTicketResponse{" +
                        "ticket='" + ticket + '\'' +
                        ", expiresIn=" + expiresIn +
                        "}"
        );
    }
}
