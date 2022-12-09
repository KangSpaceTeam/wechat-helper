package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 微信公众号OpenApi: 查询 openAPI 调用quota参数
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/4
 */
@Data
public class OpenApiQuotaGetRequest {
    @JsonProperty("cgi_path")
    private String cgiPath;

    public OpenApiQuotaGetRequest() {
    }

    public OpenApiQuotaGetRequest(String cgiPath) {
        this.cgiPath = cgiPath;
    }
}
