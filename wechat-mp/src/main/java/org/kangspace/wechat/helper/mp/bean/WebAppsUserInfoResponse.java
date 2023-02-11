package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 微信公众号拉取用户信息(需 scope 为 snsapi_userinfo)响应
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/11 17:55:40
 */
@Setter
@Getter
public class WebAppsUserInfoResponse extends WeChatMpResponseEntity {
    /**
     * 用户的唯一标识
     */
    @JsonProperty("openid")
    private String openId;
    /**
     * 用户昵称
     */
    @JsonProperty("nickname")
    private String nickname;
    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    @JsonProperty("sex")
    private String sex;
    /**
     * 用户个人资料填写的省份
     */
    @JsonProperty("province")
    private String province;
    /**
     * 普通用户个人资料填写的城市
     */
    @JsonProperty("city")
    private String city;
    /**
     * 国家，如中国为CN
     */
    @JsonProperty("country")
    private String country;
    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像 URL 将失效。
     */
    @JsonProperty("headimgurl")
    private String headImgUrl;
    /**
     * 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     */
    @JsonProperty("privilege")
    private List<String> privilege;
    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    @JsonProperty("unionid")
    private String unionId;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "WebAppsUserInfoResponse{" +
                        "openId='" + openId + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", sex='" + sex + '\'' +
                        ", province='" + province + '\'' +
                        ", city='" + city + '\'' +
                        ", country='" + country + '\'' +
                        ", headImgUrl='" + headImgUrl + '\'' +
                        ", privilege=" + privilege +
                        ", unionId='" + unionId + '\'' +
                        "}"
        );
    }
}
