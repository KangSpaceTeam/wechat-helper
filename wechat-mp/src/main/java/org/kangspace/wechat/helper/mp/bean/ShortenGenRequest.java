package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 账号管理-短key托管 请求参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/25
 */
@NoArgsConstructor
@Data
public class ShortenGenRequest {
    /**
     * 需要转换的长信息，不超过4KB
     */
    @JsonProperty("long_data")
    private String longData;
    /**
     * 过期秒数，最大值为2592000（即30天），默认为2592000
     */
    @JsonProperty("expire_seconds")
    private Long expireSeconds;

    public ShortenGenRequest(String longData, Long expireSeconds) {
        this.longData = longData;
        this.expireSeconds = expireSeconds;
    }
}
