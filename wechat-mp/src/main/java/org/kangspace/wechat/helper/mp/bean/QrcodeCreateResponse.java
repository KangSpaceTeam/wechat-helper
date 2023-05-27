package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 账号管理-生成带参数的二维码  信息响应
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/25
 */
@Getter
@Setter
public class QrcodeCreateResponse extends WeChatMpResponseEntity {
    /**
     * 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
     */
    @JsonProperty("ticket")
    private String ticket;
    /**
     * 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
     */
    @JsonProperty("expire_seconds")
    private Long expireSeconds;
    /**
     * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
     */
    @JsonProperty("url")
    private String url;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "QrcodeCreateResponse{" +
                        "ticket='" + ticket + '\'' +
                        ", expireSeconds=" + expireSeconds +
                        ", url='" + url + '\'' +
                        "}"
        );
    }
}
