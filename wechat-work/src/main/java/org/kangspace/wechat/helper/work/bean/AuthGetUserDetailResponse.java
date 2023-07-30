package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 身份验证-获取访问用户敏感信息 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
@Setter
@Getter
public class AuthGetUserDetailResponse extends WeComResponseEntity {
    /**
     * 成员UserID。对应管理端的帐号，企业内必须唯一。不区分大小写，长度为1~64个字节
     */
    @JsonProperty("userid")
    private String userId;

    /**
     * 性别。0表示未定义，1表示男性，2表示女性。仅在用户同意snsapi_privateinfo授权时返回真实值，否则返回0.
     */
    @JsonProperty("gender")
    private Integer gender;

    /**
     * 头像url。仅在用户同意snsapi_privateinfo授权时返回真实头像，否则返回默认头像
     */
    @JsonProperty("avatar")
    private String avatar;

    /**
     * 员工个人二维码（扫描可添加为外部联系人），仅在用户同意snsapi_privateinfo授权时返回
     */
    @JsonProperty("qr_code")
    private String qrCode;

    /**
     * 手机，仅在用户同意snsapi_privateinfo授权时返回，第三方应用不可获取
     */
    @JsonProperty("mobile")
    private String mobile;

    /**
     * 邮箱，仅在用户同意snsapi_privateinfo授权时返回，第三方应用不可获取
     */
    @JsonProperty("email")
    private String email;

    /**
     * 企业邮箱，仅在用户同意snsapi_privateinfo授权时返回，第三方应用不可获取
     */
    @JsonProperty("biz_mail")
    private String bizMail;

    /**
     * 仅在用户同意snsapi_privateinfo授权时返回，第三方应用不可获取
     */
    @JsonProperty("address")
    private String address;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "AuthGetUserDetailResponse{" +
                        "userId='" + userId + '\'' +
                        ", gender=" + gender +
                        ", avatar='" + avatar + '\'' +
                        ", qrCode='" + qrCode + '\'' +
                        ", mobile='" + mobile + '\'' +
                        ", email='" + email + '\'' +
                        ", bizMail='" + bizMail + '\'' +
                        ", address='" + address + '\'' +
                        "}"
        );
    }
}
