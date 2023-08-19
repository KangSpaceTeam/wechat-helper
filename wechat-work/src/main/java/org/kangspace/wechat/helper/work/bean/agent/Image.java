package org.kangspace.wechat.helper.work.bean.agent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 应用管理-模版类型数据结构-图片型 对象<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    /**
     * 图片url。图片的最佳比例为3.35:1
     */
    @JsonProperty("url")
    private String url;
    /**
     * 点击跳转url。若不填且应用设置了主页url，则跳转到主页url，否则跳到应用会话窗口
     */
    @JsonProperty("jump_url")
    private String jumpUrl;
    /**
     * 若应用为小程序类型，该字段填小程序pagepath，若未设置，跳到小程序主页
     */
    @JsonProperty("pagepath")
    private String pagePath;
}
