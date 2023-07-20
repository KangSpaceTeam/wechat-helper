package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 邮箱获取userid 响应对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/20
 */
@Setter
@Getter
public class UserGetUserIdByEmailResponse extends WeComResponseEntity {


    /**
     * 成员UserID。对应管理端的帐号，企业内必须唯一。不区分大小写，长度为1~64个字节。注意：第三方应用获取的值是密文的userid
     */
    @JsonProperty("userid")
    private String userId;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "UserGetUserIdByEmailResponse{" +
                        "userId='" + userId + '\'' +
                        "}"
        );
    }

}
