package org.kangspace.wechat.helper.core.constant;

/**
 * Api配置文件相关常量
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/2
 */
public interface WeChatConstant {

    /**
     * Api基础路径前缀名称
     */
    String API_BASE_PATH_NAME = "api_base_path";

    /**
     * oAuth认证GrateType枚举
     */
    enum OAuthGrantType {
        /**
         * 客户端认证模式
         */
        CLIENT_CREDENTIAL,
        ;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}
