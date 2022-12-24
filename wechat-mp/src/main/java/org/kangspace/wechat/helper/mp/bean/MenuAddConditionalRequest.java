package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 创建个性化菜单 请求参数
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/10
 */
@Data
public class MenuAddConditionalRequest {

    /**
     * 一级菜单数组，个数应为1~3个。
     * 必填: 是
     */
    @Nonnull
    private List<MenuCreateRequest.Button> button;
    /**
     * 菜单匹配规则。
     * 必填: 是
     */
    @Nonnull
    @JsonProperty("matchrule")
    private MenuMatchRule matchRule;

    public MenuAddConditionalRequest() {

    }
}
