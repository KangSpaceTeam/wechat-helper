package org.kangspace.wechat.helper.work.bean.agent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 应用管理-模版类型数据结构-webview型 对象<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Webview {
    /**
     * 渲染展示的url
     */
    @JsonProperty("url")
    private String url;
    /**
     * 点击跳转url。若不填且应用设置了主页url，则跳转到主页url，否则跳到应用会话窗口。如果enable_webview_click为true，则jump_url失效，点击不再跳转。
     */
    @JsonProperty("jump_url")
    private String jumpUrl;
    /**
     * 若应用为小程序类型，该字段填小程序pagepath，若未设置，跳到小程序主页
     */
    @JsonProperty("pagepath")
    private String pagePath;
    /**
     * 高度。可以有两种选择：single_row与double_row。当为single_row时，高度与关键数据型一致，当为double_row时，高度固定为170px。默认值为double_row
     */
    @JsonProperty("height")
    private String height;
    /**
     * 是否要隐藏展示了应用名称的标题部分，默认值为false
     */
    @JsonProperty("hide_title")
    private String hideTitle;
    /**
     * 是否开启webview内的链接跳转能力，默认值为false。注意：开启之后，会使jump_url失效。链接跳转仅支持以下schema方式：wxwork://openurl?url=xxxx，注意url需要进行编码。参考示例：<a href="wxwork://openurl?url=https%3A%2F%2Fwork.weixin.qq.com%2F">今日要闻</a>
     */
    @JsonProperty("enable_webview_click")
    private String enableWebviewClick;
}
