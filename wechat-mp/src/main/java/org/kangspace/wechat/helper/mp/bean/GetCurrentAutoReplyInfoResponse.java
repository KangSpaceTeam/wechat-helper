package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.kangspace.wechat.helper.core.constant.WeChatConstant;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import java.util.List;

/**
 * 获取公众号的自动回复规则 响应参数<br>
 * 如:
 * <pre>
 * {
 *    "is_add_friend_reply_open": 1,
 *    "is_autoreply_open": 1,
 *    "add_friend_autoreply_info": {
 *        "type": "text",
 *        "content": "Thanks for your attention!"
 *    },
 *    "message_default_autoreply_info": {
 *        "type": "text",
 *        "content": "Hello, this is autoreply!"
 *    },
 *    "keyword_autoreply_info": {
 *        "list": [
 *            {
 *                "rule_name": "autoreply-news",
 *                "create_time": 1423028166,
 *                "reply_mode": "reply_all",
 *                "keyword_list_info": [
 *                    {
 *                        "type": "text",
 *                        "match_mode": "contain",
 *                        "content": "news测试"//此处 content 即为关键词内容
 *                    }
 *                ],
 *                "reply_list_info": [
 *                    {
 *                        "type": "news",
 *                        "news_info": {
 *                            "list": [
 *                                {
 *                                    "title": "it's news",
 *                                    "author": "jim",
 *                                    "digest": "it's digest",
 *                                    "show_cover": 1,  "cover_url": "http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKbE8sWdt2DDcL0dMfQWJWTVn1N8DxI0gcRmrtqBOuwQHeuPKmFLK0ZQ/0",
 *                                    "content_url": "http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=203929886&idx=1&sn=628f964cf0c6d84c026881b6959aea8b#rd",
 *                                    "source_url": "http://www.url.com"
 *                                }
 *                            ]
 *                        }
 *                    },
 *                    {
 *                        "type": "news",
 *                        "content":"KQb_w_Tiz-nSdVLoTV35Psmty8hGBulGhEdbb9SKs-o",
 *                        "news_info": {
 *                            "list": [
 *                                {
 *                                    "title": "MULTI_NEWS",
 *                                    "author": "JIMZHENG",
 *                                    "digest": "text",
 *                                    "show_cover": 0,
 *                                    "cover_url": "http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfK0HKuBIa1A1cypS0uY1wickv70iaY1gf3I1DTszuJoS3lAVLvhTcm9sDA/0",
 *                                    "content_url": "http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=1&sn=80ce6d9abcb832237bf86c87e50fda15#rd",
 *                                    "source_url": ""
 *                                },
 *                                {
 *                                    "title": "MULTI_NEWS4",
 *                                    "author": "JIMZHENG",
 *                                    "digest": "MULTI_NEWSMULTI_NEWSMULTI_NEWSMULTI_NEWSMULTI_NEWSMULT",
 *                                    "show_cover": 1,
 * "cover_url": "http://mmbiz.qpic.cn/mmbiz/GE7et87vE9vicuCibqXsX9GPPLuEtBfXfKbE8sWdt2DDcL0dMfQWJWTVn1N8DxI0gcRmrtqBOuwQHeuPKmFLK0ZQ/0",
 *                                    "content_url": "http://mp.weixin.qq.com/s?__biz=MjM5ODUwNTM3Ng==&mid=204013432&idx=5&sn=b4ef73a915e7c2265e437096582774af#rd",
 *                                    "source_url": ""
 *                                }
 *                            ]
 *                        }
 *                    }
 *                ]
 *            },
 *            {
 *                "rule_name": "autoreply-voice",
 *                "create_time": 1423027971,
 *                "reply_mode": "random_one",
 *                "keyword_list_info": [
 *                    {
 *                        "type": "text",
 *                        "match_mode": "contain",
 *                        "content": "voice测试"
 *                    }
 *                ],
 *                "reply_list_info": [
 *                    {
 *                        "type": "voice",
 *                        "content": "NESsxgHEvAcg3egJTtYj4uG1PTL6iPhratdWKDLAXYErhN6oEEfMdVyblWtBY5vp"
 *                    }
 *                ]
 *            },
 *            {
 *                "rule_name": "autoreply-text",
 *                "create_time": 1423027926,
 *                "reply_mode": "random_one",
 *                "keyword_list_info": [
 *                    {
 *                        "type": "text",
 *                        "match_mode": "contain",
 *                        "content": "text测试"
 *                    }
 *                ],
 *                "reply_list_info": [
 *                    {
 *                        "type": "text",
 *                        "content": "hello!text!"
 *                    }
 *                ]
 *            },
 *            {
 *                "rule_name": "autoreply-video",
 *                "create_time": 1423027801,
 *                "reply_mode": "random_one",
 *                "keyword_list_info": [
 *                    {
 *                        "type": "text",
 *                        "match_mode": "equal",
 *                        "content": "video测试"
 *                    }
 *                ],
 *                "reply_list_info": [
 *                    {
 *                  "type": "video",
 * "content": "http://61.182.133.153/vweixinp.tc.qq.com/1007_114bcede9a2244eeb5ab7f76d951df5f.f10.mp4?vkey=7183E5C952B16C3AB1991BA8138673DE1037CB82A29801A504B64A77F691BF9DF7AD054A9B7FE683&sha=0&save=1"
 *                    }
 *                ]
 *            }
 *        ]
 *    }
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#GET_CURRENT_AUTOREPLY_INFO
 * @since 2022/12/12
 */
@Setter
@Getter
public class GetCurrentAutoReplyInfoResponse extends WeChatMpResponseEntity {
    /**
     * 关注后自动回复是否开启，0代表未开启，1代表开启
     */
    @JsonProperty("is_add_friend_reply_open")
    private WeChatConstant.OpenStatus isAddFriendReplyOpen;

    /**
     * 消息自动回复是否开启，0代表未开启，1代表开启
     */
    @JsonProperty("is_autoreply_open")
    private WeChatConstant.OpenStatus isAutoReplyOpen;

    /**
     * 关注后自动回复的信息
     */
    @JsonProperty("add_friend_autoreply_info")
    private BaseAutoReplyInfo addFriendAutoReplyInfo;

    /**
     * 消息自动回复的信息
     */
    @JsonProperty("message_default_autoreply_info")
    private BaseAutoReplyInfo messageDefaultAutoReplyInfo;

    /**
     * 关键词自动回复的信息
     */
    @JsonProperty("keyword_autoreply_info")
    private KeywordAutoReplyInfos keywordAutoReplyInfo;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "GetCurrentAutoReplyInfoResponse{" +
                        "isAddFriendReplyOpen=" + isAddFriendReplyOpen +
                        ", isAutoReplyOpen=" + isAutoReplyOpen +
                        ", addFriendAutoReplyInfo=" + addFriendAutoReplyInfo +
                        ", messageDefaultAutoReplyInfo=" + messageDefaultAutoReplyInfo +
                        ", keywordAutoReplyInfo=" + keywordAutoReplyInfo +
                        "}"
        );
    }

    /**
     * 基本自动回复信息
     */
    @Data
    public static class BaseAutoReplyInfo {
        /**
         * 自动回复的类型。关注后自动回复和消息自动回复的类型仅支持文本（text）、图片（img）、语音（voice）、视频（video），关键词自动回复则还多了图文消息（news）
         */
        private String type;
        /**
         * 对于文本类型，content是文本内容，对于图文、图片、语音、视频类型，content是mediaID
         */
        private String content;
    }

    /**
     * 关键字自动回复信息列表
     */
    @Data
    public static class KeywordAutoReplyInfos {
        /**
         * 关键字自动回复信息列表
         */
        private List<KeywordAutoReplyInfo> list;
    }

    /**
     * 关键字自动回复信息
     */
    @Data
    public static class KeywordAutoReplyInfo {
        /**
         * 规则名称
         */
        @JsonProperty("rule_name")
        private String ruleName;
        /**
         * 回复模式，reply_all代表全部回复，random_one代表随机回复其中一条
         */
        @JsonProperty("reply_mode")
        private String replyMode;
        /**
         * 创建时间,Unix时间戳
         */
        @JsonProperty("create_time")
        private Long createTime;
        /**
         * 匹配的关键词列表
         */
        @JsonProperty("keyword_list_info")
        private List<KeywordListInfo> keywordListInfo;
        /**
         *
         */
        @JsonProperty("reply_list_info")
        private List<ReplyListInfo> replyListInfo;
    }

    /**
     * 关键字自动回复信息
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    public static class KeywordListInfo extends BaseAutoReplyInfo {
        /**
         * 匹配模式，contain代表消息中含有该关键词即可，equal表示消息内容必须和关键词严格相同
         */
        @JsonProperty("match_mode")
        private String matchMode;
    }

    /**
     * 关键字自动回复信息
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    public static class ReplyListInfo extends BaseAutoReplyInfo {
        /**
         * 图文消息的信息
         */
        @JsonProperty("news_info")
        private NewsInfos newsInfo;
    }


    /**
     * 图文消息列表
     */
    @Data
    public static class NewsInfos {
        @JsonProperty("news_info")
        private List<NewsInfo> list;
    }

    /**
     * 图文消息
     */
    @Data
    public static class NewsInfo {
        /**
         * 作者
         */
        @JsonProperty("author")
        private String author;
        /**
         * 正文的URL
         */
        @JsonProperty("content_url")
        private String contentUrl;
        /**
         * 封面图片的URL
         */
        @JsonProperty("cover_url")
        private String coverUrl;
        /**
         * 摘要
         */
        @JsonProperty("digest")
        private String digest;
        /**
         * 是否显示封面，0为不显示，1为显示
         */
        @JsonProperty("show_cover")
        private WeChatConstant.ShowCover showCover;
        /**
         * 原文的URL，若置空则无查看原文入口
         */
        @JsonProperty("source_url")
        private String sourceUrl;
        /**
         * 图文消息的标题
         */
        @JsonProperty("title")
        private String title;
    }
}
