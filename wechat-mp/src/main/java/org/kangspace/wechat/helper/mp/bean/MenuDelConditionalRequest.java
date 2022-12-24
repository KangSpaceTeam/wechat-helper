package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 删除个性化菜单 请求参数
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/10
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuDelConditionalRequest {
    /**
     * 菜单Id
     */
    @JsonProperty("menuid")
    private String menuId;
}
