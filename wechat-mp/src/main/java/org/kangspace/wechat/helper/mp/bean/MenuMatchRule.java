package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kangspace.wechat.helper.mp.constant.CustomMenuConstant;

/**
 * 菜单匹配规则
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/10
 */
@Data
public class MenuMatchRule {
    /**
     * 用户标签的id，可通过用户标签管理接口获取。
     * 必填: 否
     */
    @JsonProperty("tag_id")
    private String tagId;

    /**
     * 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配。
     * 必填: 否
     */
    @JsonProperty("client_platform_type")
    private CustomMenuConstant.ClientPlatformType clientPlatformType;

    public MenuMatchRule() {
    }

    public MenuMatchRule(String tagId) {
        this.tagId = tagId;
    }
}
