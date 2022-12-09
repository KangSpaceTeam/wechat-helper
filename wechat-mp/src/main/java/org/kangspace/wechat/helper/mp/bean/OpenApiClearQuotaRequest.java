package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 微信公众号OpenApi: 清空 api 的调用quota参数
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/4
 */
@Data
public class OpenApiClearQuotaRequest {
    @JsonProperty("appid")
    private String appId;

    public OpenApiClearQuotaRequest() {
    }

    public OpenApiClearQuotaRequest(String appId) {
        this.appId = appId;
    }
}
