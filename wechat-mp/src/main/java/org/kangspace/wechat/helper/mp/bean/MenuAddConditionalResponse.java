package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 创建个性化菜单 响应参数
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/10
 */
@Setter
@Getter
public class MenuAddConditionalResponse extends WeChatMpResponseEntity {
    /**
     * 菜单Id
     */
    @JsonProperty("menuid")
    private String menuId;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "MenuAddConditionalResponse{" +
                        "menuId='" + menuId + '\'' +
                        "}"
        );
    }
}
