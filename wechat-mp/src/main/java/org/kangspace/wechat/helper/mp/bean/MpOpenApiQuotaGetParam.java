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
public class MpOpenApiQuotaGetParam {
    @JsonProperty("cgi_path")
    private String cgiPath;

    public MpOpenApiQuotaGetParam() {
    }

    public MpOpenApiQuotaGetParam(String cgiPath) {
        this.cgiPath = cgiPath;
    }
}
