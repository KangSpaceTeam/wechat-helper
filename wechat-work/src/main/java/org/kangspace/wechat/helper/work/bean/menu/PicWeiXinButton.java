package org.kangspace.wechat.helper.work.bean.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 应用管理-自定义菜单-pic_weixin	弹出企业微信相册发图器 菜单按钮
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/27
 */
@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class PicWeiXinButton extends MenuButton {
    public static final String TYPE = "pic_weixin";

    /**
     * 菜单的响应动作类型
     */
    @JsonProperty("type")
    private final String type = TYPE;
}
