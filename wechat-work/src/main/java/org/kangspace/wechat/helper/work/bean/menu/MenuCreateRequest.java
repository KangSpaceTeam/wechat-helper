package org.kangspace.wechat.helper.work.bean.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 应用管理-自定义菜单-创建菜单 参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/27
 */
@Data
@Builder
public class MenuCreateRequest {
    /**
     * 一级菜单数组，个数应为1~3个
     */
    @JsonProperty("button")
    List<MenuButton> button;
}
