package org.kangspace.wechat.helper.work.constant;

import lombok.Getter;

/**
 * 应用授权作用域。<br>
 * snsapi_base：静默授权，可获取成员的基础信息（UserId与DeviceId）；<br>
 * snsapi_privateinfo：手动授权，可获取成员的详细信息，包含头像、二维码等敏感信息。<br>
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
@Getter
public enum Scope{
    /**
     * 静默授权，可获取成员的基础信息（UserId与DeviceId）；
     */
    SNSAPI_BASE("snsapi_base"),

    /**
     * 手动授权，可获取成员的详细信息，包含头像、二维码等敏感信息。
     */
    SNSAPI_PRIVATE_INFO("snsapi_privateinfo"),
    ;

    private final String scope;

    Scope(String scope) {
        this.scope = scope;
    }
}