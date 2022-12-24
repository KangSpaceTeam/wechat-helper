package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 创建个性化菜单 响应参数
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/10
 */
@Data
public class MenuAddConditionalResponse extends WeChatMpResponseEntity {
    /**
     * 菜单Id
     */
    @JsonProperty("menuid")
    private String menuId;
}
