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
public class ShortenGenResponse extends WeChatMpResponseEntity {
    /**
     * 短key，15字节，base62编码(0-9/a-z/A-Z)
     */
    @JsonProperty("short_key")
    private String shortKey;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "ShortenGenResponse{" +
                        "shortKey='" + shortKey + '\'' +
                        "}"
        );
    }
}
