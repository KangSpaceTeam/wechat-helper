package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;

/**
 * 通讯录管理-互联企业-获取互联企业成员详细信息 请求对象<br>
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/27
 */
@Data
@Builder
public class LinkedCorpUserGetRequest {
    /**
     * 该字段用的是互联应用可见范围接口返回的userids参数，用的是 CorpId + ’/‘ + USERID 拼成的字符串
     */
    @Nonnull
    @JsonProperty("userid")
    private String userId;

    public LinkedCorpUserGetRequest(@Nonnull String userId) {
        this.userId = userId;
    }

    public LinkedCorpUserGetRequest() {
    }
}
