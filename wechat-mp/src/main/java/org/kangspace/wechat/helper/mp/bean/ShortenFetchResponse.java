package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 账号管理-短key托管-还原长信息  信息响应
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/27
 */
@Getter
@Setter
public class ShortenFetchResponse extends WeChatMpResponseEntity {
    /**
     * 长信息
     */
    @JsonProperty("long_data")
    private String longData;
    /**
     * 创建的时间戳
     */
    @JsonProperty("create_time")
    private Long createTime;
    /**
     * 剩余的过期秒数
     */
    @JsonProperty("expire_seconds")
    private Long expireSeconds;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "ShortenFetchResponse{" +
                        "longData='" + longData + '\'' +
                        ", createTime=" + createTime +
                        ", expireSeconds=" + expireSeconds +
                        "}"
        );
    }
}
