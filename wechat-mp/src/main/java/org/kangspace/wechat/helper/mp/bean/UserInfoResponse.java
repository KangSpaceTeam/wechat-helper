package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.core.constant.WeChatLang;
import org.kangspace.wechat.helper.mp.constant.Subscribe;
import org.kangspace.wechat.helper.mp.constant.SubscribeScene;

import java.util.List;

/**
 * 用户管理-获取用户基本信息(UnionID机制) 响应
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/8
 */
@Setter
@Getter
public class UserInfoResponse extends WeChatMpResponseEntity {

    /**
     * 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
     */
    @JsonProperty("subscribe")
    private Subscribe subscribe;
    /**
     * 用户的标识，对当前公众号唯一
     */
    @JsonProperty("openid")
    private String openId;
    /**
     * 用户的语言，简体中文为zh_CN
     */
    @JsonProperty("language")
    private WeChatLang language;
    /**
     * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
     */
    @JsonProperty("subscribe_time")
    private Long subscribeTime;
    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    @JsonProperty("unionid")
    private String unionId;
    /**
     * 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
     */
    @JsonProperty("remark")
    private String remark;
    /**
     * 用户所在的分组ID（兼容旧的用户分组接口）
     */
    @JsonProperty("groupid")
    private Long groupId;
    /**
     * 用户被打上的标签ID列表
     */
    @JsonProperty("tagid_list")
    private List<Long> tagIdList;
    /**
     * 返回用户关注的渠道来源，ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENE_PROFILE_LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_WECHAT_ADVERTISEMENT 微信广告，ADD_SCENE_REPRINT 他人转载 ,ADD_SCENE_LIVESTREAM 视频号直播，ADD_SCENE_CHANNELS 视频号 , ADD_SCENE_OTHERS 其他
     */
    @JsonProperty("subscribe_scene")
    private SubscribeScene subscribeScene;
    /**
     * 二维码扫码场景（开发者自定义）
     */
    @JsonProperty("qr_scene")
    private String qrScene;
    /**
     * 二维码扫码场景描述（开发者自定义）
     */
    @JsonProperty("qr_scene_str")
    private String qrSceneStr;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "UserInfoResponse{" +
                        "subscribe=" + subscribe +
                        ", openId='" + openId + '\'' +
                        ", language=" + language +
                        ", subscribeTime=" + subscribeTime +
                        ", unionId='" + unionId + '\'' +
                        ", remark='" + remark + '\'' +
                        ", groupId=" + groupId +
                        ", tagIdList=" + tagIdList +
                        ", subscribeScene=" + subscribeScene +
                        ", qrScene='" + qrScene + '\'' +
                        ", qrSceneStr='" + qrSceneStr + '\'' +
                        "}"
        );
    }
}
