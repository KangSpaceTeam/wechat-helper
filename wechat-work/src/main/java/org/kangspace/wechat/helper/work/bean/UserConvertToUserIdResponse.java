package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * userid与openid互换-openid转userid 响应对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/20
 */
@Setter
@Getter
public class UserConvertToUserIdResponse extends WeComResponseEntity {

    /**
     * 该openid在企业微信对应的成员userid
     */
    @JsonProperty("userid")
    private String userId;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "UserConvertToUserIdResponse{" +
                        "userId='" + userId + '\'' +
                        "}"
        );
    }
}
