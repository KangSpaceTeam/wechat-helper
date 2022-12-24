package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kangspace.wechat.helper.mp.constant.CustomMenuConstant;

import java.util.List;

/**
 * 自定义菜单查询接口响应 <br/>
 * 样例: <a href="https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Querying_Custom_Menus.html">https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Querying_Custom_Menus.html</a> <br/>
 * 如果公众号是在公众平台官网通过网站功能发布菜单，则本接口返回的自定义菜单配置样例如下：
 * <pre>
 * {
 *    "is_menu_open": 1,
 *    "selfmenu_info": {
 *        "button": [
 *            {
 *                "name": "button",
 *                "sub_button": {
 *                    "list": [
 *                        {
 *                            "type": "view",
 *                            "name": "view_url",
 *                            "url": "http://www.qq.com"
 *                        },
 *                        {
 *                            "type": "news",
 *                            "name": "news",
 *                            "value":"KQb_w_Tiz-nSdVLoTV35Psmty8hGBulGhEdbb9SKs-o",
 *                            "news_info": {
 *                                "list": [
 *                                    {
 *                                        "title": "MULTI_NEWS",
 *                                        "author": "JIMZHENG",
 *                                        "digest": "text",
 *                                        "show_cover": 0,
 *                                        "cover_url": "http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfK0HKuBIa1A1cypS0uY1wickv70iaY1gf3I1DTszuJoS3lAVLvhTcm9sDA/0",
 *                                        "content_url": "http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=1&sn=80ce6d9abcb832237bf86c87e50fda15#rd",
 *                                        "source_url": ""
 *                                    },
 *                                    {
 *                                        "title": "MULTI_NEWS1",
 *                                        "author": "JIMZHENG",
 *                                        "digest": "MULTI_NEWS1",
 *                                        "show_cover": 1,
 *                                        "cover_url": "http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKnmnpXYgWmQD5gXUrEApIYBCgvh2yHsu3ic3anDUGtUCHwjiaEC5bicd7A/0",
 *                                        "content_url": "http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=2&sn=8226843afb14ecdecb08d9ce46bc1d37#rd",
 *                                        "source_url": ""
 *                                    }
 *                                ]
 *                            }
 *                        },
 *                        {
 *                            "type": "video",
 *                            "name": "video",
 *                            "value": "http://61.182.130.30/vweixinp.tc.qq.com/1007_114bcede9a2244eeb5ab7f76d951df5f.f10.mp4?vkey=77A42D0C2015FBB0A3653D29C571B5F4BBF1D243FBEF17F09C24FF1F2F22E30881BD350E360BC53F&sha=0&save=1"
 *                        },
 *                        {
 *                            "type": "voice",
 *                            "name": "voice",
 *                            "value": "nTXe3aghlQ4XYHa0AQPWiQQbFW9RVtaYTLPC1PCQx11qc9UB6CiUPFjdkeEtJicn"
 *                        }
 *                    ]
 *                }
 *            },
 *            {
 *                "type": "text",
 *                "name": "text",
 *                "value": "This is text!"
 *            },
 *            {
 *                "type": "img",
 *                "name": "photo",
 *                "value": "ax5Whs5dsoomJLEppAvftBUuH7CgXCZGFbFJifmbUjnQk_ierMHY99Y5d2Cv14RD"
 *            }
 *        ]
 *    }
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/10
 */
@Data
public class CurrentSelfMenuInfoResponse extends WeChatMpResponseEntity {
    /**
     * 菜单是否开启，0代表未开启，1代表开启
     */
    @JsonProperty("is_menu_open")
    private CustomMenuConstant.IsMenuOpen isMenuOpen;
    /**
     * 菜单信息
     */
    @JsonProperty("selfmenu_info")
    private SelfMenuInfo selfMenuInfo;

    /**
     * 菜单信息
     */
    @Data
    public static class SelfMenuInfo {
        /**
         * 菜单按钮
         */
        private List<MenuButtonResponse.CurrentSelfMenuButton> button;
    }
}
