package org.kangspace.wechat.helper.mp.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 用户关注的渠道来源 <br>
 * ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENE_PROFILE_LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_WECHAT_ADVERTISEMENT 微信广告，ADD_SCENE_REPRINT 他人转载 ,ADD_SCENE_LIVESTREAM 视频号直播，ADD_SCENE_CHANNELS 视频号 , ADD_SCENE_OTHERS 其他
 * @author kango2gler@gmail.com
 * @since 2023/5/8
 */
public enum SubscribeScene {
    /**
     *  公众号搜索
     */
    ADD_SCENE_SEARCH,
    /**
     *  公众号迁移
     */
    ADD_SCENE_ACCOUNT_MIGRATION,
    /**
     *  名片分享
     */
    ADD_SCENE_PROFILE_CARD,
    /**
     *  扫描二维码
     */
    ADD_SCENE_QR_CODE,
    /**
     *  图文页内名称点击
     */
    ADD_SCENE_PROFILE_LINK,
    /**
     *  图文页右上角菜单
     */
    ADD_SCENE_PROFILE_ITEM,
    /**
     *  支付后关注
     */
    ADD_SCENE_PAID,
    /**
     *  微信广告
     */
    ADD_SCENE_WECHAT_ADVERTISEMENT,
    /**
     *  他人转载 ,ADD_SCENE_LIVESTREAM 视频号直播
     */
    ADD_SCENE_REPRINT,
    /**
     *  视频号 , ADD_SCENE_OTHERS 其他
     */
    ADD_SCENE_CHANNELS,
    ;

    @JsonCreator
    public SubscribeScene parse(String name) {
        return SubscribeScene.valueOf(name);
    }

    @JsonValue
    @Override
    public String toString() {
        return this.name();
    }
}
