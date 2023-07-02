package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 帐号ID 接口-自建应用与第三方应用的对接-external_userid转换 响应参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/2
 */
@Getter
@Setter
public class FromServiceExternalUserIdResponse extends WeComResponseEntity{
    /**
     * 企业主体的external_userid
     */
    @JsonProperty("external_userid")
    private String externalUserId;

    public FromServiceExternalUserIdResponse() {
    }

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "FromServiceExternalUserIdResponse{" +
                        "externalUserId='" + externalUserId + '\'' +
                        "}"
        );
    }

    public FromServiceExternalUserIdResponse(String externalUserId) {
        this.externalUserId = externalUserId;
    }

}
