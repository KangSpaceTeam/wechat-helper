package org.kangspace.wechat.helper.work.bean.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 应用管理-自定义菜单-location_select	弹出地理位置选择器 菜单按钮
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/27
 */
@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class LocationSelectButton extends MenuButton {
    public static final String TYPE = "location_select";

    /**
     * 菜单的响应动作类型
     */
    @JsonProperty("type")
    private final String type = TYPE;
}
