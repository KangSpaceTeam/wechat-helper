package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.kangspace.wechat.helper.core.constant.WeChatConstant;
import org.kangspace.wechat.helper.mp.constant.CustomMenuConstant;

import java.util.List;

/**
 * 自定义菜单-按钮响应
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/10
 */
@Data
public class MenuButtonResponse {

    /**
     * CurrentSelfMenuInfoResponse中的Button,
     * sub_button是对象
     */
    @Data
    @ToString(callSuper = true)
    public static class CurrentSelfMenuButton extends Button {
        /**
         * 子菜单
         */
        @JsonProperty("sub_button")
        private SubButtons subButton;
    }

    /**
     * 普通sub_button是数组
     */
    @Data
    @ToString(callSuper = true)
    public static class MenuButton extends Button {
        /**
         * 子菜单
         */
        @JsonProperty("sub_button")
        private List<Button> subButton;
    }

    /**
     * 菜单按钮
     */
    @Data
    public static class Button {
        /**
         * 菜单的类型，公众平台官网上能够设置的菜单类型有view（跳转网页）、text（返回文本，下同）、img、photo、video、voice。使用 API 设置的则有8种，详见《自定义菜单创建接口》
         */
        private CustomMenuConstant.ButtonType type;
        /**
         * 菜单名称
         */
        private String name;
        /**
         * 对于不同的菜单类型，value的值意义不同。<br>
         * 官网上设置的自定义菜单： Text:保存文字到value； Img、voice：保存 mediaID 到value； Video：保存视频下载链接到value；News：保存图文消息到news_info，同时保存 mediaID 到value； View：保存链接到url。<br>
         * 使用 API 设置的自定义菜单： click、scancode_push、scancode_waitmsg、pic_sysphoto、pic_photo_or_album、 pic_weixin、location_select：保存值到key；view：保存链接到url。<br>
         */
        private String value;
        private String url;
        private String key;
        /**
         * 图文消息的信息
         */
        @JsonProperty("news_info")
        private NewsInfos newsInfo;
    }


    /**
     * 图文消息的信息
     */
    @Data
    public static class SubButtons {
        List<Button> list;
    }

    /**
     * 图文消息的信息
     */
    @Data
    public static class NewsInfos {
        List<NewsInfo> list;
    }

    /**
     * 图文消息的信息详情
     */
    @Data
    public static class NewsInfo {
        /**
         * 图文消息的标题
         */
        private String title;
        /**
         * 摘要
         */
        private String digest;
        /**
         * 作者
         */
        private String author;
        /**
         * 是否显示封面，0为不显示，1为显示
         */
        @JsonProperty("show_cover")
        private WeChatConstant.ShowCover showCover;
        /**
         * 封面图片的URL
         */
        @JsonProperty("cover_url")
        private String coverUrl;
        /**
         * 正文的URL
         */
        @JsonProperty("content_url")
        private String contentUrl;
        /**
         * 原文的URL，若置空则无查看原文入口
         */
        @JsonProperty("source_url")
        private String sourceUrl;

    }
}
