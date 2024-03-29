package org.kangspace.wechat.helper.mp.bean;

import lombok.Data;

/**
 * 微信公众号OpenApi: 查询 rid 信息参数
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/4
 */
@Data
public class OpenApiRidGetRequest {
    private String rid;

    public OpenApiRidGetRequest() {
    }

    public OpenApiRidGetRequest(String rid) {
        this.rid = rid;
    }
}
