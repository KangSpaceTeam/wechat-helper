package org.kangspace.wechat.helper.mp.constant;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 网页开发常量
 * @author kango2gler@gmail.com
 * @since 2023/02/11 17:29
 */
public interface WebAppConstant {
    /**
     * 网页授权范围
     */
    enum Scope {
        /**
         * 以snsapi_base为 scope 发起的网页授权，是用来获取进入页面的用户的 openid 的，并且是静默授权并自动跳转到回调页的。用户感知的就是直接进入了回调页（往往是业务页面）
         */
        SNS_API_BASE("snsapi_base"),
        /**
         * 以snsapi_userinfo为 scope 发起的网页授权，是用来获取用户的基本信息的。但这种授权需要用户手动同意，并且由于用户同意过，所以无须关注，就可在授权后获取该用户的基本信息。
         */
        SNS_API_USERINFO("snsapi_userinfo"),
        ;
        String scope;

        Scope(String scope) {
            this.scope = scope;
        }

        @JsonValue
        public String getScope() {
            return scope;
        }
    }
}
