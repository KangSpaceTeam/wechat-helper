package org.kangspace.wechat.helper.work.bean.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.annotation.Nonnull;

/**
 * 应用管理-自定义菜单-view 跳转URL菜单按钮
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/27
 */
@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class ViewMenuButton extends MenuButton {
    public static final String TYPE = "view";

    /**
     * 菜单的响应动作类型
     */
    @JsonProperty("type")
    private final String type = TYPE;

    /**
     * view类型必须	网页链接，成员点击菜单可打开链接，不超过1024字节。为了提高安全性，建议使用https的url
     */
    @Nonnull
    @JsonProperty("url")
    private String url;
}
