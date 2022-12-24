package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kangspace.wechat.helper.mp.constant.CustomMenuConstant;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 自定义菜单-创建菜单请求参数
 * click和 view 的请求示例, 如:
 * <pre>
 *     {
 *      "button":[
 *      {
 *           "type":"click",
 *           "name":"今日歌曲",
 *           "key":"V1001_TODAY_MUSIC"
 *       },
 *       {
 *            "name":"菜单",
 *            "sub_button":[
 *            {
 *                "type":"view",
 *                "name":"搜索",
 *                "url":"http://www.soso.com/"
 *             },
 *             {
 *                  "type":"miniprogram",
 *                  "name":"wxa",
 *                  "url":"http://mp.weixin.qq.com",
 *                  "appid":"wx286b93c14bbf93aa",
 *                  "pagepath":"pages/lunar/index"
 *              },
 *             {
 *                "type":"click",
 *                "name":"赞一下我们",
 *                "key":"V1001_GOOD"
 *             }]
 *        }]
 *  }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths#MENU_CREATE
 * @since 2022/12/10
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuCreateRequest {
    /**
     * 一级菜单数组，个数应为1~3个。
     * 必填: 是
     */
    @Nonnull
    private List<Button> button;

    @Builder
    @Data
    public static class Button {
        /**
         * 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型。
         * 必填: 是
         */
        @Nonnull
        private CustomMenuConstant.ButtonType type;
        /**
         * 菜单标题，不超过16个字节，子菜单不超过60个字节。
         * 必填: 是
         */
        @Nonnull
        private String name;
        /**
         * 菜单 KEY 值，用于消息接口推送，不超过128字节。
         * 必填: click等点击类型必须
         */
        private String key;
        /**
         * 网页 链接，用户点击菜单可打开链接，不超过1024字节。 type为 miniprogram 时，不支持小程序的老版本客户端将打开本url。
         * 必填: view、miniprogram类型必须
         */
        private String url;
        /**
         * 调用新增永久素材接口返回的合法media_id。
         * 必填: media_id类型和view_limited类型必须
         */
        @JsonProperty("media_id")
        private String mediaId;
        /**
         * 发布后获得的合法 article_id
         * 必填: article_id类型和article_view_limited类型必须
         */
        @JsonProperty("article_id")
        private String articleId;
        /**
         * 小程序的appid（仅认证公众号可配置）。
         * 必填: miniprogram类型必须
         */
        @JsonProperty("appid")
        private String appId;
        /**
         * 小程序的页面路径。
         * 必填: miniprogram类型必须
         */
        @JsonProperty("pagepath")
        private String pagePath;
        /**
         * 二级菜单数组，个数应为1~5个。
         * 必填: 否
         */
        @JsonProperty("sub_button")
        private List<Button> subButton;
    }
}
