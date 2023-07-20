package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * userid与openid互换-userid转openid 响应对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/20
 */
@Setter
@Getter
public class UserConvertToOpenIdResponse extends WeComResponseEntity {

    /**
     * 企业微信成员userid对应的openid
     */
    @JsonProperty("openid")
    private String openId;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "UserConvertToOpenIdResponse{" +
                        "openId='" + openId + '\'' +
                        "}"
        );
    }
}
