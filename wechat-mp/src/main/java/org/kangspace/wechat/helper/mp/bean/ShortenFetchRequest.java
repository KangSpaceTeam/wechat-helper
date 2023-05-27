package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 账号管理-短key托管-还原长信息 请求参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/25
 */
@NoArgsConstructor
@Data
public class ShortenFetchRequest {
    /**
     * 短key
     */
    @JsonProperty("short_key")
    private String shortKey;

    public ShortenFetchRequest(String shortKey) {
        this.shortKey = shortKey;
    }
}
