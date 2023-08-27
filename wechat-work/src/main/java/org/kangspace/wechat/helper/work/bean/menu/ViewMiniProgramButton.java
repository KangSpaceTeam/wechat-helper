package org.kangspace.wechat.helper.work.bean.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.annotation.Nonnull;

/**
 * 应用管理-自定义菜单-view_miniprogram	跳转到小程序 菜单按钮
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/27
 */
@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class ViewMiniProgramButton extends MenuButton {
    public static final String TYPE = "view_miniprogram";

    /**
     * 菜单的响应动作类型
     */
    @JsonProperty("type")
    private final String type = TYPE;

    /**
     * view_miniprogram类型必须	小程序的页面路径
     */
    @Nonnull
    @JsonProperty("pagepath")
    private String pagePath;
    /**
     * view_miniprogram类型必须	小程序的appid（仅与企业绑定的小程序可配置）
     */
    @Nonnull
    @JsonProperty("appid")
    private String appId;
}
