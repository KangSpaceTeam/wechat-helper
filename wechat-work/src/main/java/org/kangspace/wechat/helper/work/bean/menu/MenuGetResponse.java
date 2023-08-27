package org.kangspace.wechat.helper.work.bean.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;

import java.util.List;

/**
 * 应用管理-自定义菜单-获取菜单 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
@Setter
@Getter
public class MenuGetResponse extends WeComResponseEntity {
    /**
     * 一级菜单数组，个数应为1~3个
     */
    @JsonProperty("button")
    List<MenuButton> button;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "MenuGetResponse{" +
                        "button=" + button +
                        "}"
        );
    }

    @Data
    public static class MenuButton {

        /**
         * 二级菜单数组，个数应为1~5个
         */
        @JsonProperty("sub_button")
        List<MenuButton> subButton;

        /**
         * 菜单的响应动作类型
         */
        @JsonProperty("type")
        private String type;

        /**
         * 菜单的名字。不能为空，主菜单不能超过16字节，子菜单不能超过40字节。
         */
        @JsonProperty("name")
        private String name;

        /**
         * click等点击类型必须	菜单KEY值，用于消息接口推送，不超过128字节
         */
        @JsonProperty("key")
        private String key;

        /**
         * view类型必须	网页链接，成员点击菜单可打开链接，不超过1024字节。为了提高安全性，建议使用https的url
         */
        @JsonProperty("url")
        private String url;

        /**
         * view_miniprogram类型必须	小程序的页面路径
         */
        @JsonProperty("pagepath")
        private String pagePath;
        /**
         * view_miniprogram类型必须	小程序的appid（仅与企业绑定的小程序可配置）
         */
        @JsonProperty("appid")
        private String appId;
    }
}
