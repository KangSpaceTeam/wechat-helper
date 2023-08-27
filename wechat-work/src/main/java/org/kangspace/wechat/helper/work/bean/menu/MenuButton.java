package org.kangspace.wechat.helper.work.bean.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 应用管理-自定义菜单-菜单按钮
 *
 * @author kango2gler@gmail.com
 * @see ClickMenuButton
 * @see ViewMenuButton
 * @see ScanCodePushButton
 * @see ScanCodeWaitMsgButton
 * @see PicSysPhotoButton
 * @see PicPhotoOrAlbumButton
 * @see PicWeiXinButton
 * @see LocationSelectButton
 * @see ViewMiniProgramButton
 * @since 2023/8/27
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MenuButton {

    /**
     * 二级菜单数组，个数应为1~5个
     */
    @JsonProperty("sub_button")
    List<MenuButton> subButton;

    /**
     * 菜单的响应动作类型
     */
    @JsonProperty("type")
    private String type;
    /**
     * 菜单的名字。不能为空，主菜单不能超过16字节，子菜单不能超过40字节。
     */
    @Nonnull
    @JsonProperty("name")
    private String name;
    /**
     * click等点击类型必须	菜单KEY值，用于消息接口推送，不超过128字节
     */
    @JsonProperty("key")
    private String key;
}
